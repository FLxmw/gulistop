package com.feilong.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.feilong.common.valid.ListValue;
import com.feilong.gulimall.product.valid.AddGroup;
import com.feilong.gulimall.product.valid.UpdateGroup;
import com.feilong.gulimall.product.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author xiaomingwang
 * @email xiaomingwang@gmail.com
 * @date 2020-11-13 12:45:42
 */
@Data
@TableName("pms_brand")
@SuppressWarnings("ALL")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@NotNull(groups = UpdateGroup.class,message = "品牌id不能爲空！")
	@Null(groups = AddGroup.class)
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups ={UpdateGroup.class,AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(groups = AddGroup.class)
	@URL(message = "品牌的logo必须是一个正确的URL地址",groups ={UpdateGroup.class,AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
	//包装类
//	@Range(max = 1,message = "显示状态值必须是0或1",groups ={UpdateGroup.class,AddGroup.class})
	@ListValue(value = {0,1},groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups = AddGroup.class)
	@Pattern(regexp = "^[a-zA-Z]$",message = "首字母必须是a-z或A-Z之间",groups ={UpdateGroup.class,AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = AddGroup.class)
	@Min(value = 0,message = "排序字段必须大于等于0",groups ={UpdateGroup.class,AddGroup.class})
	private Integer sort;

}
