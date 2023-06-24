package com.tianhui.po;

import lombok.Data;

/**
 * 商家
 */
@Data
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


}
