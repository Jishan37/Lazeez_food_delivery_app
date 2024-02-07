package com.hridoykrisna.Lazeez.service;

import com.hridoykrisna.Lazeez.model.Customer;

public interface UserService {
    void saveUser(Customer customer);

    int makeLogin(Customer customer);
}
