package com.tianhui.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商家
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private double starPrice;
    private double deliveryPrice;
    private String remarks;
    private List<Food> foodList;
}
