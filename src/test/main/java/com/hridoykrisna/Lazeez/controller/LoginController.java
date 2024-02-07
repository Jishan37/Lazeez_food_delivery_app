package com.hridoykrisna.Lazeez.controller;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Employee;
import com.hridoykrisna.Lazeez.service.LoginService;
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
public class LoginController {
    private final LoginService loginService;

    @GetMapping({"/login", "login/"})
    public String login() {
        return "login.html";
    }

    @PostMapping("/login-form")
    public String loginForm(@Valid @ModelAttribute("login") Employee employee, Model model, RedirectAttributes redirectAttributes) {
        int result = loginService.makeLogin(employee);
        if (result == 1) {
            return "redirect:/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("failed", "Wrong Credentials, Please Enter valid Value");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        if (CommonUtils.isAdminAuthenticate) {
            CommonUtils.employee = null;
            CommonUtils.isAdminAuthenticate = false;
        }
        return "/login";
    }
}
