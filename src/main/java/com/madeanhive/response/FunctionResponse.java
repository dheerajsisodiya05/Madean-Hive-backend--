package com.madeanhive.response;

import com.madeanhive.dto.OrderHistory;
import com.madeanhive.model.Cart;
import com.madeanhive.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}
