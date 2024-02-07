package com.hridoykrisna.Lazeez.controller;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Order;
import com.hridoykrisna.Lazeez.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("")
public class OrderController {
    private final OrderService orderService;

    @GetMapping({"/order/", "/order"})
    public String getOrder(Model model) {
        if (CommonUtils.isAdminAuthenticate) {
            List<Order> orderList = orderService.getAllOrder();
            model.addAttribute("orderList", orderList);
            model.addAttribute("currentUserName", CommonUtils.employee.getName());
            if (Objects.equals(CommonUtils.employee.getUser_type(), "ADMIN")) {
                model.addAttribute("user_type", "ADMIN");
            }
            return "order.html";
        } else {
            return "redirect:/login";
        }
    }

}
