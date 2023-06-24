package com.tianhui.controller;

import com.tianhui.po.CommonResult;
import com.tianhui.po.Food;
import com.tianhui.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/Food")
public class FoodController {

    @Resource
    private FoodService foodService;

    /**
     * 查询
     * @param businessId
     * @return
     * @throws Exception
     */
    @GetMapping("/BusinessId/{businessId}")
    public CommonResult<List> listFoodByBusinessId(@PathVariable("businessId") Integer businessId) throws Exception {
        List<Food> list = foodService.listFoodByBusinessId(businessId);
        return new CommonResult<List>(200, "success", list);
    }

    /**
     * 新增
     * @param food
     * @return
     */
    @PostMapping("/Save")
    public CommonResult<Food> saveFood(Food food){
        int result = foodService.saveFood(food);
    return new CommonResult<Food>(200,"success",food);
    }
}
