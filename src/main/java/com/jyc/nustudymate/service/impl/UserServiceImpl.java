package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.User;
import com.jyc.nustudymate.service.UserService;
import com.jyc.nustudymate.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author jyc
* @description 针对表【user(用户)】的数据库操作Service实现
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        if(StringUtils.isAnyEmpty(userAccount,userPassword,checkPassword)){
            return -1;
        }
        if(userAccount.length()<4||userPassword.length()<8||checkPassword.length()<8){
            return -1;
        }
        // 账号不重复
        QueryWrapper<User> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        long count = this.count(queryWrapper);
        if(count>0){
            return -1;
        }
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()){
            return -1;
        }
        return 0;
    }
}




