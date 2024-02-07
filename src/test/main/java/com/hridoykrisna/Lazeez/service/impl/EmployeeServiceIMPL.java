package com.hridoykrisna.Lazeez.service.impl;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Employee;
import com.hridoykrisna.Lazeez.repository.EmployeeRepo;
import com.hridoykrisna.Lazeez.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> employeeList() {
        return employeeRepo.findAllEmployee();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setCreatedBy(CommonUtils.employee.getId());
        var result = employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Employee disableEmployee(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()){
            employee.get().setIsActive(false);
            employeeRepo.save(employee.get());
            return employee.get();
        }
        return null;
    }

    @Override
    public List<Employee> driverList() {
        return employeeRepo.findByDriver();
    }
}
