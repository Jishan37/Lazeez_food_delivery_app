package com.hridoykrisna.Lazeez.service.impl;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.FoodMenu;
import com.hridoykrisna.Lazeez.repository.FoodMenuRepo;
import com.hridoykrisna.Lazeez.service.FoodMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodMenuIMPL implements FoodMenuService {
    private final FoodMenuRepo foodMenuRepo;

    @Override
    public void addFood(FoodMenu foodMenu) {
        foodMenu.setCreatedBy(CommonUtils.employee.getCreatedBy());
        foodMenu.setStatus(1);
        foodMenuRepo.save(foodMenu);
    }

    @Override
    public List<FoodMenu> getFoodMenuList() {
        System.out.println(foodMenuRepo.findAll());
        return foodMenuRepo.findAll();
    }

    @Override
    public List<FoodMenu> getActiveFoodMenuList() {
        return foodMenuRepo.findAllByStatus(1);
    }

    @Override
    public int changeFoodStatus(int id, int status) {
        Optional<FoodMenu> foodMenuOptional = foodMenuRepo.findById(id);
        if (foodMenuOptional.isPresent()) {
            foodMenuOptional.get().setStatus(status);
            foodMenuRepo.save(foodMenuOptional.get());
            return 1;
        }
        return 0;
    }
}
