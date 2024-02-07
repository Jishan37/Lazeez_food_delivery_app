package com.hridoykrisna.Lazeez.service.impl;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.CartItem;
import com.hridoykrisna.Lazeez.model.Customer;
import com.hridoykrisna.Lazeez.model.FoodMenu;
import com.hridoykrisna.Lazeez.model.Order;
import com.hridoykrisna.Lazeez.repository.CartRepo;
import com.hridoykrisna.Lazeez.repository.OrderRepo;
import com.hridoykrisna.Lazeez.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService {
    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;

    @Override
    public Order makeOrder(List<CartItem> cartItemList) {
        Order order = new Order();
        List<FoodMenu> foodMenuList = new ArrayList<>();
        float totalPrice = 0;
        int totalQuantity = 0;

        for (CartItem item : cartItemList) {
            FoodMenu foodMenu = new FoodMenu();
            foodMenu.setId(item.getFood_id());
            foodMenuList.add(foodMenu);
            totalQuantity += item.getQuantity();
            totalPrice += item.getTotal_price();
            cartRepo.delete(item);
        }

        order.setQuantity(cartItemList.size());
        order.setStatus(0);
        Customer customer = new Customer(CommonUtils.customer.id);
        order.setCustomer(customer);
        order.setUser_id(CommonUtils.customer.getId());
        order.setFoodMenuList(foodMenuList);
        order.setTotal_price(totalPrice);
        order.setQuantity(totalQuantity);
        order.setCreatedBy(CommonUtils.customer.getCreatedBy());
        order.setDate(new Date());
//        System.out.println(order);
//        Save on database
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        System.out.println(orderRepo.getAllOrderByDate());
        return orderRepo.getAllOrderByDate();
    }

    @Override
    public String updateStatus(int id, int status) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            if (status == 3)
                orderOptional.get().setPayment_status(1);
            orderOptional.get().setStatus(status);
            orderRepo.save(orderOptional.get());
            return "Update Successfully";
        }
        return "Update Fail";
    }

    @Override
    public List<Order> getOrderByCustomer(int id) {
        return orderRepo.getOrderListByCustomer(id);
    }
}
