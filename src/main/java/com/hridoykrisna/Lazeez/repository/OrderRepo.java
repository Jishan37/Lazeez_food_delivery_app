package com.hridoykrisna.Lazeez.repository;

import com.hridoykrisna.Lazeez.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "from Order order by createdAt desc")
    List<Order> getAllOrderByDate();

    @Query(value = "from Order where user_id=?1 order by createdAt desc")
    List<Order> getOrderListByCustomer(int id);

    @Query(value = "select sum(total_price) from Order")
    int sumOfTotalAmount();
}
