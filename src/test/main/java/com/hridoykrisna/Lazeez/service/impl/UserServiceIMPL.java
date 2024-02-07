package com.hridoykrisna.Lazeez.service.impl;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.Customer;
import com.hridoykrisna.Lazeez.repository.UserRepo;
import com.hridoykrisna.Lazeez.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;

    @Override
    public void saveUser(Customer customer) {
        System.out.println(customer);
        userRepo.save(customer);
    }

    @Override
    public int makeLogin(Customer customer) {
        Optional<Customer> data = userRepo.findByEmailAndPassword(customer.getEmail(), customer.getPassword());
        if (data.isPresent()) {
            CommonUtils.isUserAuthenticate = true;
            CommonUtils.customer = data.get();
            return 1;
        } else {
            return 0;
        }
    }
}
