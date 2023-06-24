package com.tianhui.service;

import com.tianhui.po.Cart;
import com.tianhui.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(value = "cart-server",fallback = OrderFeignImpl.class)

public interface OrderFeign {
    @GetMapping("/Cart/CartListAll/{userId}/{businessId}")
    public CommonResult<List<Cart>> getCartList(@PathVariable("userId") String userId,@PathVariable("businessId") Integer businessId);
}
