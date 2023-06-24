package com.tianhui.service;

import com.tianhui.po.Cart;
import com.tianhui.po.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderFeignImpl implements OrderFeign{
    @Override
    public CommonResult<List<Cart>> getCartList(String userId, Integer businessId) {
        return new CommonResult<>(403,"熔断降级处理",null);
    }
}
