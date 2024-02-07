package com.hridoykrisna.Lazeez.service;

import com.hridoykrisna.Lazeez.model.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> addToCart(int id);

    List<CartItem> removeFromCart(int id);
}
