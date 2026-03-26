package com.madeanhive.repository;

import com.madeanhive.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {

    PaymentOrder findByPaymentLinkId(String paymentId);
    
    PaymentOrder findByStripeSessionId(String stripeSessionId);
}
