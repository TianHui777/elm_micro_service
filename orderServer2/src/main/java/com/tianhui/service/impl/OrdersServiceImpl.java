package com.tianhui.service.impl;

import com.tianhui.service.OrdersService;
import jakarta.annotation.Resource;
import com.tianhui.mapper.CartMapper;
import com.tianhui.mapper.OrderDetailetMapper;
import com.tianhui.mapper.OrdersMapper;
import com.tianhui.po.Cart;
import com.tianhui.po.OrderDetailet;
import com.tianhui.po.Orders;
import com.tianhui.service.OrderFeign;
import com.tianhui.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;
    @Autowired
    OrderFeign orderFeign;
    @Resource
    RestTemplate restTemplate;

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        //1、查询当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> cartList = cartMapper.listCart(cart);



        //2、创建订单（返回生成的订单编号）
        orders.setOrderDate(CommonUtil.getCurrentDate());
        ordersMapper.saveOrders(orders);
        int orderId = orders.getOrderId();


        List<OrderDetailet> list = new ArrayList<>();
        for (Cart c : cartList) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            System.out.println(od.getOrderId());
            od.setFoodId(c.getFoodId());
            System.out.println(od.getFoodId());
            od.setQuantity(c.getQuantity());
            System.out.println(od.getQuantity());
            orderDetailetMapper.saveOrderDetailet(od);
        }

        cartMapper.removeCart(cart);

        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.getOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return ordersMapper.listOrdersByUserId(userId);
    }
}
