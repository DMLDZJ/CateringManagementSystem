package com.entity;

import java.sql.Date;

public class Dishes {
    private int dishId;
    private String dishName;
    private int dishCost;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishCost() {
        return dishCost;
    }

    public void setDishCost(int dishCost) {
        this.dishCost = dishCost;
    }
}
