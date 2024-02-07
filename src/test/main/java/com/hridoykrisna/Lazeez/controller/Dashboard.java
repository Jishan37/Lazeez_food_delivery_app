package com.hridoykrisna.Lazeez.controller;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.repository.EmployeeRepo;
import com.hridoykrisna.Lazeez.repository.FoodMenuRepo;
import com.hridoykrisna.Lazeez.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class Dashboard {
    private final EmployeeRepo employeeRepo;
    private final OrderRepo orderRepo;
    private final FoodMenuRepo foodMenuRepo;

    @GetMapping
    public String dashboard(Model model) {
        if (CommonUtils.isAdminAuthenticate) {
            model.addAttribute("currentUserName", CommonUtils.employee.getName());
            long totalEmp = employeeRepo.count() - 1;
            int totalDriver = employeeRepo.getTotalDriver("DRIVER");
            model.addAttribute("totalEmployee", totalEmp);
            model.addAttribute("totalDriver", totalDriver);
            model.addAttribute("totalOfficer", totalEmp - totalDriver);
            model.addAttribute("totalOrder", orderRepo.count());
            model.addAttribute("totalAmount", orderRepo.sumOfTotalAmount());
            model.addAttribute("totalFood", foodMenuRepo.count());
            return "dashboard.html";
        } else {
            return "redirect:login";
        }
    }
}
