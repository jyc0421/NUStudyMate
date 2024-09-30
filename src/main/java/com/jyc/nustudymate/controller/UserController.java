package com.jyc.nustudymate.controller;

import com.jyc.nustudymate.model.domain.User;
import com.jyc.nustudymate.model.request.UserLoginRequest;
import com.jyc.nustudymate.model.request.UserRegisterRequest;
import com.jyc.nustudymate.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author jyc
 * @Date 2024/9/30 2:10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest==null){
            return null;
        }
        return userService.userRegister(userRegisterRequest.getUserAccount(),userRegisterRequest.getUserPassword(),userRegisterRequest.getCheckPassword());
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        if(userLoginRequest==null){
            return null;
        }
        return userService.userLogin(userLoginRequest.getUserAccount(),userLoginRequest.getUserPassword(),request);
    }
}
