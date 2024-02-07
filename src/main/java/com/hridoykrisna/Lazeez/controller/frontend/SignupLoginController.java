package com.hridoykrisna.Lazeez.controller.frontend;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Customer;
import com.hridoykrisna.Lazeez.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("")
public class SignupLoginController {

    private final UserService userService;

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("userAuthentic", CommonUtils.isUserAuthenticate);
        return "frontend/signup.html";
    }

    @PostMapping("/signup-form")
    public String userRegistration(@Valid @ModelAttribute("user") Customer customer) {
        userService.saveUser(customer);
        return "redirect:/login-customer";
    }

    @GetMapping("/login-customer")
    public String getLoginUser(Model model) {
        model.addAttribute("userAuthentic", CommonUtils.isUserAuthenticate);
        return "frontend/login.html";
    }

    @PostMapping("/customer-login-form")
    public String userLogin(@Valid @ModelAttribute("login") Customer customer, Model model, RedirectAttributes redirectAttributes) {
        int result = userService.makeLogin(customer);
        if (result == 1) {
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("failed", "Wrong Credentials, Please Enter valid Value");
            return "redirect:/login-customer";
        }
    }

    @GetMapping("/customer-logout")
    public String logOut() {
        CommonUtils.isUserAuthenticate = false;
        CommonUtils.customer = null;
        return "redirect:/";
    }
}
