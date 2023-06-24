package com.tianhui.service;

import com.tianhui.po.Food;

import java.util.List;

public interface FoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);
    public int saveFood(Food food);
}