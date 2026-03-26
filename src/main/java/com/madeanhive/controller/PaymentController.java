package com.madeanhive.controller;

import com.madeanhive.model.*;
import com.madeanhive.service.*;
import com.madeanhive.domain.PaymentMethod;
import com.madeanhive.model.*;
import com.madeanhive.repository.CartItemRepository;
import com.madeanhive.repository.CartRepository;
import com.madeanhive.response.ApiResponse;
import com.madeanhive.response.PaymentLinkResponse;
import com.madeanhive.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final UserService userService;
    private final PaymentService paymentService;
    private final TransactionService transactionService;
    private final SellerReportService sellerReportService;
    private final SellerService sellerService;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    @PostMapping("/api/payment/{paymentMethod}/order/{orderId}")
    public ResponseEntity<PaymentLinkResponse> paymentHandler(
            @PathVariable PaymentMethod paymentMethod,
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserProfileByJwt(jwt);

        PaymentLinkResponse paymentResponse;

        PaymentOrder order= paymentService.getPaymentOrderById(orderId);

//        if(paymentMethod.equals(PaymentMethod.RAZORPAY)){
//            paymentResponse=paymentService.createRazorpayPaymentLink(user,
//                    order.getAmount(),
//                    order.getId());
//        }
//        else{
//            paymentResponse=paymentService.createStripePaymentLink(user,
//                    order.getAmount(),
//                    order.getId());
//        }

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


    @GetMapping("/api/payment/{paymentId}")
    public ResponseEntity<ApiResponse> paymentSuccessHandler(
            @PathVariable String paymentId,
            @RequestParam(required = false) String paymentLinkId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserProfileByJwt(jwt);
        ApiResponse res = new ApiResponse();

        PaymentOrder paymentOrder = null;
        boolean paymentSuccess = false;

        // Try to find payment order by Razorpay payment link ID first
        if (paymentLinkId != null && !paymentLinkId.isEmpty()) {
            try {
                paymentOrder = paymentService.getPaymentOrderByPaymentId(paymentLinkId);
                paymentSuccess = paymentService.ProceedPaymentOrder(paymentOrder, paymentId, paymentLinkId);
            } catch (Exception e) {
                System.out.println("Razorpay payment verification failed: " + e.getMessage());
            }
        }

        // If Razorpay verification failed, try Stripe verification
        if (!paymentSuccess) {
            try {
                PaymentOrder stripePaymentOrder = paymentService.getPaymentOrderRepository().findByStripeSessionId(paymentId);
                if (stripePaymentOrder != null) {
                    paymentOrder = stripePaymentOrder;
                    paymentSuccess = paymentService.verifyStripePayment(paymentId);
                }
            } catch (Exception e) {
                System.out.println("Stripe payment verification failed: " + e.getMessage());
            }
        }

        // If still no payment found, return error
        if (paymentOrder == null) {
            res.setMessage("Payment order not found");
            res.setStatus(false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        if (paymentSuccess) {
            for (Order order : paymentOrder.getOrders()) {
                transactionService.createTransaction(order);
                Seller seller = sellerService.getSellerById(order.getSellerId());
                SellerReport report = sellerReportService.getSellerReport(seller);
                report.setTotalOrders(report.getTotalOrders() + 1);
                report.setTotalEarnings(report.getTotalEarnings() + order.getTotalSellingPrice());
                report.setTotalSales(report.getTotalSales() + order.getOrderItems().size());
                sellerReportService.updateSellerReport(report);
            }
            Cart cart = cartRepository.findByUserId(user.getId());
            if (cart != null) {
                cart.setCouponPrice(0);
                cart.setCouponCode(null);
                cartRepository.save(cart);
            }
            
            res.setMessage("Payment successful");
            res.setStatus(true);
        } else {
            res.setMessage("Payment verification failed");
            res.setStatus(false);
            return new ResponseEntity<>(res, HttpStatus.PAYMENT_REQUIRED);
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
