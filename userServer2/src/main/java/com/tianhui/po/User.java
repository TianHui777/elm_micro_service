package com.tianhui.po;

import lombok.Data;

/**
 * 用户
 */
@Data
public class User {
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;
}
