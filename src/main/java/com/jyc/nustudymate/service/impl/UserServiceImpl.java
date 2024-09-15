package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.User;
import com.jyc.nustudymate.service.UserService;
import com.jyc.nustudymate.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author jyc
* @description 针对表【user(用户)】的数据库操作Service实现
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




