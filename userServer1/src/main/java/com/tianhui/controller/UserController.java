package com.tianhui.controller;

import com.tianhui.service.UserService;
import com.tianhui.po.CommonResult;
import com.tianhui.po.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

//
//@RefreshScope
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    @GetMapping("/Login")
    public CommonResult<User> getUserByIdByPass(User user) throws Exception {
        return new CommonResult(200, "success", userService.getUserByIdByPass(user));
    }

    /**
     * 查询用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @GetMapping("/UserId")
    public CommonResult<Integer> getUserById(User user) throws Exception {
        User result = userService.getUserById(user.getUserId());
        return new CommonResult(200, "success", result);
    }

    /**
     * 存储用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/UserId")
    public CommonResult<Integer> saveUser(User user) throws Exception {
        int result = userService.saveUser(user);
        return new CommonResult(200, "success", result);
    }
}