package com.hridoykrisna.Lazeez.repository;

import com.hridoykrisna.Lazeez.model.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMenuRepo extends JpaRepository<FoodMenu, Integer> {

    @Query(value = "from FoodMenu where status=?1")
    List<FoodMenu> findAllByStatus(int status);

}
