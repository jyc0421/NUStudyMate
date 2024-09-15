package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.UserTeam;
import com.jyc.nustudymate.service.UserTeamService;
import com.jyc.nustudymate.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author jyc
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




