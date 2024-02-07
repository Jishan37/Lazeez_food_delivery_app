package com.hridoykrisna.Lazeez.controller;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Employee;
import com.hridoykrisna.Lazeez.service.EmployeeService;
import com.hridoykrisna.Lazeez.service.util.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final FileService fileService;

    private final String path = CommonUtils.ImagePath;

    @GetMapping({"/employee", "/employee/"})
    public String employee(Model map) {
        if (CommonUtils.isAdminAuthenticate) {
            List<Employee> employeeList = null;
            employeeList = employeeService.employeeList();
            map.addAttribute("employees", employeeList);
            map.addAttribute("currentUserName", CommonUtils.employee.getName());

            if (Objects.equals(CommonUtils.employee.getUser_type(), "ADMIN")) {
                map.addAttribute("user_type", "ADMIN");
            }
            return "employee.html";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/employee-registration-form")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, @RequestParam MultipartFile image, RedirectAttributes redirectAttributes) throws IOException {


        // Save Image & Set Image Path
        String imagePath = fileService.uploadImage(path, image, employee.getName());
        employee.setImagePath(imagePath);

        //Save to Database
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("success", "Employee Registration Successfully Done.");
        return "redirect:/employee";
    }

}
