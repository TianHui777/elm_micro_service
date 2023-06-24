package com.tianhui.service;

import com.tianhui.service.Impl.FoodFeignImpl;
import com.tianhui.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "food-server",fallback = FoodFeignImpl.class)

public interface FoodFeign {
    @GetMapping("/Food/BusinessId/{businessId}")
    public CommonResult listFood(@PathVariable("businessId") Integer businessId);

}
