package com.hridoykrisna.Lazeez.controller.frontend;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.service.FoodMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("")
public class FoodMenuController {
    private final FoodMenuService foodMenuService;

    @GetMapping("/menu")
    public String getFoodMenu(Model model) {
        model.addAttribute("userAuthentic", CommonUtils.isUserAuthenticate);
        model.addAttribute("foodMenuList", foodMenuService.getActiveFoodMenuList());
        return "frontend/menu.html";
    }

}
