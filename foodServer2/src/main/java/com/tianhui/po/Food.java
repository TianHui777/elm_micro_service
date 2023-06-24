package com.tianhui.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 食品
 */
@Data
@AllArgsConstructor
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private Double foodPrice;
    private Integer businessId;
    private String remarks;
}
