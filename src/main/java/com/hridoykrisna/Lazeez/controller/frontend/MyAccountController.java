package com.hridoykrisna.Lazeez.controller.frontend;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Order;
import com.hridoykrisna.Lazeez.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class MyAccountController {
    private final OrderService orderService;

    @GetMapping({"/my-account", "/my-account/"})
    public String geMyAccount(Model model) {
        if (CommonUtils.isUserAuthenticate) {
            model.addAttribute("userAuthentic", CommonUtils.isUserAuthenticate);
            List<Order> orderList = orderService.getOrderByCustomer(CommonUtils.customer.id);
            model.addAttribute("orderList", orderList);
            return "frontend/my_account.html";
        } else {
            return "redirect:/login-customer";
        }
    }
}
