package com.feilong.gulimall.product.dao;

import com.feilong.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xiaomingwang
 * @email xiaomingwang@gmail.com
 * @date 2020-11-13 12:45:43
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
