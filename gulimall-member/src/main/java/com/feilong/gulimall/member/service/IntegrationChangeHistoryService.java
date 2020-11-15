package com.feilong.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feilong.common.utils.PageUtils;
import com.feilong.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author Feilong
 * @email xiaomingwang5310feilong@aliyun.com
 * @date 2020-11-15 13:39:11
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

