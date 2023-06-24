package com.tianhui.service.Impl;

import com.tianhui.service.FoodFeign;
import com.tianhui.po.CommonResult;
import org.springframework.stereotype.Component;

@Component

public class FoodFeignImpl implements FoodFeign {
    @Override
    public CommonResult listFood(Integer businessId) {
        return new CommonResult(403,"fegin触发了熔断降级",null);
    }
}
