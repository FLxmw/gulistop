package com.feilong.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feilong.common.utils.PageUtils;
import com.feilong.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author xiaomingwang
 * @email xiaomingwang@gmail.com
 * @date 2020-11-13 12:45:43
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

