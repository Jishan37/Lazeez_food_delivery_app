package com.hridoykrisna.Lazeez.Utils;

import com.hridoykrisna.Lazeez.model.Customer;
import com.hridoykrisna.Lazeez.model.Employee;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CommonUtils {
    public static String ImagePath = "images/";
    public static Boolean isAdminAuthenticate = false;
    public static Boolean isUserAuthenticate = false;
    public static Customer customer;
    public static Employee employee;
    public static List<Employee> driverList;

    public static long calculateSecondsBetween(LocalDateTime a, LocalDateTime b) {
        return Duration.between(a, b).getSeconds();
    }
}
