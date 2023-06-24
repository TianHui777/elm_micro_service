package com.tianhui.service.impl;


import com.tianhui.mapper.CartMapper;
import com.tianhui.po.Cart;
import com.tianhui.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 查询购物车
     * @param cart
     * @return
     */
    @Override
    public List<Cart> listCart(Cart cart) {
        return cartMapper.listCart(cart);
    }

    /**
     * 查询购物车
     * @param userId
     * @param businessId
     * @return
     */
    @Override
    public List<Cart> listCartAll(String userId,Integer businessId) {
        return cartMapper.listCartByUB(userId,businessId);
    }

    /**
     * 新增
     * @param cart
     * @return
     */
    @Override
    public int saveCart(Cart cart) {
        return cartMapper.saveCart(cart);
    }

    /**
     * 修改
     * @param cart
     * @return
     */
    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    /**
     * 删除
     * @param cart
     * @return
     */
    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }

}