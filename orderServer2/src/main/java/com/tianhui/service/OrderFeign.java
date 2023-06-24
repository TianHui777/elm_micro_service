package com.tianhui.service;

import com.tianhui.po.Cart;
import com.tianhui.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value = "cartServer",url = "http://localhost:12000")
@Component
public interface OrderFeign {
    @GetMapping("/Cart/CartList")
    public CommonResult<List<Cart>> getCartList(@RequestParam("cart") Cart cart);
}
