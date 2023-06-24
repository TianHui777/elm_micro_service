package com.tianhui.mapper;


import com.tianhui.po.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CartMapper {
    public List<Cart> listCart(Cart cart);
    @Select("select * from cart where userId=#{userId} and businessId=#{businessId}")
    public List<Cart> listCartByUB(String userId,Integer businessId);

    @Insert("insert into cart (foodId,businessId,userId,quantity) values(#{foodId},#{businessId},#{userId},1)")
    public int saveCart(Cart cart);


    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
    public int updateCart(Cart cart);


    public int removeCart(Cart cart);
}