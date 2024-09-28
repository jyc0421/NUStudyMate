package com.jyc.nustudymate.service;

import com.jyc.nustudymate.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author jyc
* @description 针对表【user(用户)】的数据库操作Service
*/
public interface UserService extends IService<User> {
    /**
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

}
