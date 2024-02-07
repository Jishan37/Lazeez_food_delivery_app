package com.hridoykrisna.Lazeez.repository;

import com.hridoykrisna.Lazeez.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<CartItem, Integer> {
    @Query("select ci from CartItem ci where ci.status = 1 and ci.createdBy = ?1 and ci.isActive = true")
    List<CartItem> getCartListAndStatusOne(int id);

}
