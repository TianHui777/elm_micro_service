package com.tianhui.service;




import com.tianhui.po.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> listCart(Cart cart);
    public List<Cart> listCartAll(String userId,Integer businessId);


    public int saveCart(Cart cart);

    public int updateCart(Cart cart);

    public int removeCart(Cart cart);

}