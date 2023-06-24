package com.tianhui.po;

import lombok.Data;

import java.util.List;

@Data
public class Orders {
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;

    private Business business;
    private List<OrderDetailet> list;

}
