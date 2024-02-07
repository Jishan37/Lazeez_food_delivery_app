package com.hridoykrisna.Lazeez.controller.frontend;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
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
public class About {

    @GetMapping("about")
    public String getAbout(Model model) {
        model.addAttribute("userAuthentic", CommonUtils.isUserAuthenticate);
        System.out.println("User: " + CommonUtils.isUserAuthenticate);
        return "frontend/about.html";
    }
}
