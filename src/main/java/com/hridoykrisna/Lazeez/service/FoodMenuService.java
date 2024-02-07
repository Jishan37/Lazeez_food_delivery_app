package com.hridoykrisna.Lazeez.service;

import com.hridoykrisna.Lazeez.model.FoodMenu;

import java.util.List;

public interface FoodMenuService {
    void addFood(FoodMenu foodMenu);

    List<FoodMenu> getFoodMenuList();

    List<FoodMenu> getActiveFoodMenuList();

    int changeFoodStatus(int id, int status);
}
