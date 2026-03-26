package com.madeanhive.service;

import com.madeanhive.exception.ReviewNotFoundException;
import com.madeanhive.model.Product;
import com.madeanhive.model.Review;
import com.madeanhive.model.User;
import com.madeanhive.request.CreateReviewRequest;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ReviewService {

    Review createReview(CreateReviewRequest req,
                        User user,
                        Product product);

    List<Review> getReviewsByProductId(Long productId);

    Review updateReview(Long reviewId,
                        String reviewText,
                        double rating,
                        Long userId) throws ReviewNotFoundException, AuthenticationException;


    void deleteReview(Long reviewId, Long userId) throws ReviewNotFoundException, AuthenticationException;

}
