package com.tianhui.controller;


import com.tianhui.po.Cart;
import com.tianhui.po.CommonResult;
import com.tianhui.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RefreshScope
@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 查询
     * @param cart
     * @return
     * @throws Exception
     */
    @GetMapping("/CartList")
    public CommonResult<List<Cart>> listCart(Cart cart) throws Exception {
        return new CommonResult<List<Cart>>(200, "success", cartService.listCart(cart));
    }

    /**
     * 查询
     * @param userId
     * @param businessId
     * @return
     * @throws Exception
     */
    @GetMapping("/CartListAll/{userId}/{businessId}")
    public CommonResult<List<Cart>> listCartAll(@PathVariable("userId") String userId,@PathVariable("businessId") Integer businessId) throws Exception {
        return new CommonResult<List<Cart>>(200, "success", cartService.listCartAll(userId,businessId));
    }

    /**
     * 新增
     * @param cart
     * @return
     * @throws Exception
     */
    @PostMapping("/Order")
    public CommonResult<Integer> saveCart(Cart cart) throws Exception {
        return new CommonResult<Integer>(200, "success", cartService.saveCart(cart));
    }

    /**
     * 修改
     * @param cart
     * @return
     * @throws Exception
     */
    @PutMapping("/Order")
    public CommonResult<Integer> updateCart(Cart cart) throws Exception {
        return new CommonResult<Integer>(200, "success", cartService.updateCart(cart));
    }

    /**
     * 删除
     * @param cart
     * @return
     * @throws Exception
     */
    @DeleteMapping("/Order")
    public CommonResult<Integer> removeCart(Cart cart) throws Exception {
        return new CommonResult<Integer>(200, "success", cartService.removeCart(cart));
    }


}