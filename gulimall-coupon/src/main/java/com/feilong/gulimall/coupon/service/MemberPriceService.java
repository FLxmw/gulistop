package com.feilong.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feilong.common.utils.PageUtils;
import com.feilong.gulimall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author Feilong
 * @email xiaomingwang5310feilong@aliyun.com
 * @date 2020-11-15 13:24:07
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

