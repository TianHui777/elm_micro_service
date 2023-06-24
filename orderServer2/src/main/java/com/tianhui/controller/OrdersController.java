package com.tianhui.controller;

import com.tianhui.service.OrdersService;
import com.tianhui.po.CommonResult;
import com.tianhui.po.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired

    private OrdersService ordersService;

    /**
     * 新增订单
     * @param orders
     * @return
     * @throws Exception
     */
    @PostMapping("/OrdersId")
    public CommonResult<Integer> createOrders( Orders orders) throws Exception {

        return new CommonResult<>(200, "success", ordersService.createOrders(orders));
    }

    /**
     * 查询订单
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
}