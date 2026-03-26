package com.madeanhive.service;


import com.madeanhive.exception.WishlistNotFoundException;
import com.madeanhive.model.Product;
import com.madeanhive.model.User;
import com.madeanhive.model.Wishlist;

public interface WishlistService {

    Wishlist createWishlist(User user);

    Wishlist getWishlistByUserId(User user);

    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}

