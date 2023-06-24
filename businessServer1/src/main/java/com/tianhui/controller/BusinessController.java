package com.tianhui.controller;


import jakarta.annotation.Resource;
import com.tianhui.po.Business;
import com.tianhui.po.CommonResult;
import com.tianhui.service.BusinessService;
import com.tianhui.service.FoodFeign;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/Business")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    @Resource
    private FoodFeign foodFeign;


    @GetMapping("/OrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) throws Exception {
        return new CommonResult<List>(200, "success",
                businessService.listBusinessByOrderTypeId(orderTypeId));
    }

    @GetMapping("/BusinessId/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) throws Exception {

             Business business  = businessService.getBusinessById(businessId);

          CommonResult<List> result = foodFeign.listFood(businessId);
            business.setFoodList(result.getResult());
            return new CommonResult(200, "success", business);


    }
    }

