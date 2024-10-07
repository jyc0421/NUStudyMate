package com.jyc.nustudymate.controller;

import com.jyc.nustudymate.common.BaseResponse;
import com.jyc.nustudymate.common.ErrorCode;
import com.jyc.nustudymate.common.ResponseUtils;
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
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest==null){
            return ResponseUtils.error(ErrorCode.PARAMS_ERROR);
        }
        long result = userService.userRegister(userRegisterRequest.getUserAccount(), userRegisterRequest.getUserPassword(), userRegisterRequest.getCheckPassword());
        //return new BaseResponse<>(200,result,"ok");
        return ResponseUtils.success(result);
    }

    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        if(userLoginRequest==null){
            return ResponseUtils.error(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.userLogin(userLoginRequest.getUserAccount(), userLoginRequest.getUserPassword(), request);
        //return new BaseResponse<>(200,user,"ok");
        return ResponseUtils.success(user);
    }

    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout(HttpServletRequest request){
        boolean b = userService.userLogout(request);
        // return new BaseResponse<>(200,b,"ok");
        return ResponseUtils.success(b);
    }
}
