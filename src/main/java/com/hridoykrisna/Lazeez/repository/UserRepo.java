package com.hridoykrisna.Lazeez.repository;

import com.hridoykrisna.Lazeez.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Customer, Integer> {
    @Query(value = "from Customer where email=?1 And password=?2")
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
