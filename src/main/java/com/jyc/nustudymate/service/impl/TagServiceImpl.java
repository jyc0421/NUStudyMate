package com.jyc.nustudymate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyc.nustudymate.model.domain.Tag;
import com.jyc.nustudymate.service.TagService;
import com.jyc.nustudymate.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author jyc
* @description 针对表【tag(标签)】的数据库操作Service实现
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




