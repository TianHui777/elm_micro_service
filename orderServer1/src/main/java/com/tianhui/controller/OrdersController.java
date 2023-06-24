package com.tianhui.controller;

import com.tianhui.service.OrdersService;
import jakarta.annotation.Resource;
import com.tianhui.po.CommonResult;
import com.tianhui.po.Orders;
import com.tianhui.service.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired

    private OrdersService ordersService;
    @Resource
    OrderFeign orderFeign;

    /**
     * 创建订单
     * @param orders
     * @return
     * @throws Exception
     */
    @PostMapping("/OrdersId")
    public CommonResult<Integer> createOrders( Orders orders) throws Exception {

        return new CommonResult<>(200, "success", ordersService.createOrders(orders));
    }

    /**
     * 查询
     * @param orders
     * @return
     * @throws Exception
     */
    @GetMapping("/OrdersId")
    public CommonResult<Orders> getOrderById(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.getOrdersById(orders.getOrderId()));
    }

    /**
     * 查询
     * @param orders
     * @return
     * @throws Exception
     */
    @GetMapping("/UserId")
    public CommonResult<List> listOrdersByUserId(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.listOrdersByUserId(orders.getUserId()));
    }

    /**
     * 查询购物车
     * @param userId
     * @param businessId
     * @return
     */
    @GetMapping("/feign/{userId}/{businessId}")
    public CommonResult listCart(@PathVariable("userId") String userId,@PathVariable("businessId")Integer businessId){
        if(orderFeign.getCartList(userId,businessId).getCode()==200){
            return new CommonResult(200,"message",orderFeign.getCartList(userId,businessId));
        }
        else {

            return new CommonResult(403, "error", null);
        }
    }
}