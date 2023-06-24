package com.tianhui.po;

import lombok.Data;

/**
 * 食品
 */
@Data
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private Double foodPrice;
    private Integer businessId;
    private String remarks;
}
