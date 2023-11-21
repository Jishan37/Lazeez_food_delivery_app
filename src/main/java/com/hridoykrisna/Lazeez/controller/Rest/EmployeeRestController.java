package com.hridoykrisna.Lazeez.controller.Rest;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Employee;
import com.hridoykrisna.Lazeez.service.EmployeeService;
import com.hridoykrisna.Lazeez.service.util.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee/")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    private final FileService fileService;

    private final String path = CommonUtils.ImagePath;

    @GetMapping("{id}")
    public Employee getEmpDetails(@Valid @PathVariable("id") int id, Model model) {
        //        System.out.println(employee);
//        model.addAttribute("employee", employee);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("disable")
    public Employee disableEmployee(@RequestParam("id") int id) {
        //        System.out.println(employee);
//        model.addAttribute("employee", employee);
        return employeeService.disableEmployee(id);
    }

}
