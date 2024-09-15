package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.Team;
import com.jyc.nustudymate.service.TeamService;
import com.jyc.nustudymate.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author jyc
* @description 针对表【team(队伍)】的数据库操作Service实现
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




