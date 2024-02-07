package com.hridoykrisna.Lazeez.service.impl;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Employee;
import com.hridoykrisna.Lazeez.repository.EmployeeRepo;
import com.hridoykrisna.Lazeez.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginIMPL implements LoginService {
    private final EmployeeRepo employeeRepo;

    @Override
    public int makeLogin(Employee employee) {
        Optional<Employee> data = employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword());
        if (data.isPresent()) {
            CommonUtils.isAdminAuthenticate = true;
            CommonUtils.employee = data.get();
//            System.out.println(data.get());
            return 1;
        } else {
            return 0;
        }
    }
}
