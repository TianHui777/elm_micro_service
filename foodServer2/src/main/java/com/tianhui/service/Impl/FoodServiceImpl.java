package com.tianhui.service.Impl;


import com.tianhui.mapper.FoodMapper;
import com.tianhui.po.Food;
import com.tianhui.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodMapper.listFoodByBusinessId(businessId);
    }

    @Override
    public int saveFood(Food food) {
        return foodMapper.saveFood(food);
    }


}