package com.feilong.gulimall.member.dao;

import com.feilong.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Feilong
 * @email xiaomingwang5310feilong@aliyun.com
 * @date 2020-11-15 13:39:10
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
