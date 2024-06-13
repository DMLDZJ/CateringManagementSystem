package com.dao;

import com.entity.Dishes;

public interface DishDAO {
    Object[][] findAll();
    int getCost(String dishName);
    int getDishId(String dishName);
}
