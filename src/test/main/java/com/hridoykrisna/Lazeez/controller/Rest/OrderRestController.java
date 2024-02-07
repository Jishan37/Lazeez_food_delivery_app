package com.hridoykrisna.Lazeez.controller.Rest;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.CartItem;
import com.hridoykrisna.Lazeez.model.Order;
import com.hridoykrisna.Lazeez.repository.CartRepo;
import com.hridoykrisna.Lazeez.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderRestController {
    private final OrderService orderService;
    private final CartRepo cartRepo;

    @GetMapping("make-order")
    public Order makeOrder() {
        List<CartItem> cartItemList = cartRepo.getCartListAndStatusOne(CommonUtils.customer.id);
        return orderService.makeOrder(cartItemList);
    }


    @PostMapping("update-status") // Change to @PostMapping
    public String updateOrderStatus(@RequestParam("id") int id, @RequestParam("status") int status) {

        return orderService.updateStatus(id, status);
    }
}
