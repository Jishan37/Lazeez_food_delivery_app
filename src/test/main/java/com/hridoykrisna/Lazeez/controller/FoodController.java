package com.hridoykrisna.Lazeez.controller;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.FoodMenu;
import com.hridoykrisna.Lazeez.service.FoodMenuService;
import com.hridoykrisna.Lazeez.service.util.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Objects;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("")
public class FoodController {
    private final FoodMenuService foodMenuService;
    private final FileService fileService;
    private final String path = CommonUtils.ImagePath;

    @GetMapping({"/food-menu", "/food-menu/"})
    public String employee(Model map) {
        if (CommonUtils.isAdminAuthenticate) {

            map.addAttribute("foodMenuList", foodMenuService.getFoodMenuList());
            map.addAttribute("currentUserName", CommonUtils.employee.getName());
            if (Objects.equals(CommonUtils.employee.getUser_type(), "ADMIN")) {
                map.addAttribute("user_type", "ADMIN");
            }
            return "food_menu.html";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/add-food")
    public String addFood(@Valid @ModelAttribute("food") FoodMenu foodMenu, @RequestParam MultipartFile image, RedirectAttributes redirectAttributes) throws IOException {


        // Save Image & Set Image Path
        String imagePath = fileService.uploadImage(path, image, foodMenu.getName());
        foodMenu.setImagePath(imagePath);

        //Save to Database
        foodMenuService.addFood(foodMenu);
        redirectAttributes.addFlashAttribute("success", "Food Menu Successfully Added.");
        return "redirect:/food-menu";
    }
}
