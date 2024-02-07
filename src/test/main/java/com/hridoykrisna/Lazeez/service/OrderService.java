package com.hridoykrisna.Lazeez.service;

import com.hridoykrisna.Lazeez.model.CartItem;
import com.hridoykrisna.Lazeez.model.Order;

import java.util.List;

public interface OrderService {
    Order makeOrder(List<CartItem> cartItemList);

    List<Order> getAllOrder();

    String updateStatus(int status, int i);

    List<Order> getOrderByCustomer(int id);
}
