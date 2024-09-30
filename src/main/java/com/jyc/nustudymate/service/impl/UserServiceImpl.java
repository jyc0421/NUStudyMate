package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.User;
import com.jyc.nustudymate.service.UserService;
import com.jyc.nustudymate.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* @author jyc
* @description 针对表【user(用户)】的数据库操作Service实现
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        if(StringUtils.isAnyEmpty(userAccount,userPassword,checkPassword)){
            return -1;
        }
        // 校验账号长度不小于4位，密码长度不小于8位
        if(userAccount.length()<4||userPassword.length()<8||checkPassword.length()<8){
            return -1;
        }
        // 校验用户名不含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        boolean match = userAccount.matches(validPattern);
        if(match){
            return -1;
        }
        if(!userPassword.equals(checkPassword)){
            return -1;
        }
        // 账号不重复
        QueryWrapper<User> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        long count = this.count(queryWrapper);
        if(count>0){
            return -1;
        }
        // Long count = userMapper.selectCount(queryWrapper);
        // if(count>0){
        //     return -1;
        // }

        // 对密码进行加密 bcrypt
        String encryptPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        System.out.println(encryptPassword);
        // 插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean save = this.save(user);
        if(!save){
            return -1;
        }
        return user.getId();

    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1.校验
        if(StringUtils.isAnyEmpty(userAccount,userPassword)){
            return null;
        }
        if(userAccount.length()<4||userPassword.length()<8){
            return null;
        }
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        boolean match = userAccount.matches(validPattern);
        if(match){
            return null;
        }
        // 2.校验密码是否正确
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            log.info("user login failed,userAccount do not exist");
            return null;
        }
        String encryptPassword = user.getUserPassword();
        boolean isPasswordValid = BCrypt.checkpw(userPassword,encryptPassword);
        if(!isPasswordValid){
            log.info("user login failed,userAccount password error");
            return null;
        }
        // 3.用户脱敏
        User safetUser = new User();
        safetUser.setId(user.getId());
        safetUser.setUsername(user.getUsername());
        safetUser.setUserAccount(user.getUserAccount());
        safetUser.setAvatarUrl(user.getAvatarUrl());
        safetUser.setGender(user.getGender());
        safetUser.setUserRole(user.getUserRole());
        safetUser.setUserStatus(user.getUserStatus());
        safetUser.setPhone(user.getPhone());
        safetUser.setEmail(user.getEmail());
        safetUser.setPlanetCode(user.getPlanetCode());
        safetUser.setCreateTime(user.getCreateTime());

        // 4.记录用户登录态
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        log.info("user login success,userId:{}",user.getId());
        return safetUser;
    }
}




