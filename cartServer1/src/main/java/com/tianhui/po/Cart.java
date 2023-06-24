package com.tianhui.po;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class Cart {

    private Integer cartId;
    private Integer foodId;
    private Integer businessId;
    private String userId;
    private Integer quantity;

    private Food food;
    private Business business;


}
