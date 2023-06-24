package com.tianhui.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.tianhui.po.OrderDetailet;

import java.util.List;


@Mapper
public interface OrderDetailetMapper {
    public int saveOrderDetailetBatch(List<OrderDetailet> list);

    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderOd);
    @Insert("insert into orderdetailet (orderId,foodId,quantity) values (#{orderId},#{foodId},#{quantity})")
    public int saveOrderDetailet(OrderDetailet orderDetailet);
}
