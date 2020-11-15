package com.feilong.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 库存工作单
 * 
 * @author Feilong
 * @email xiaomingwang5310feilong@aliyun.com
 * @date 2020-11-15 13:49:17
 */
@Data
@TableName("wms_ware_order_task")
@Accessors(chain = true)
public class WareOrderTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * order_id
	 */
	private Long orderId;
	/**
	 * order_sn
	 */
	private String orderSn;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 收货人电话
	 */
	private String consigneeTel;
	/**
	 * 配送地址
	 */
	private String deliveryAddress;
	/**
	 * 订单备注
	 */
	private String orderComment;
	/**
	 * 付款方式【 1:在线付款 2:货到付款】
	 */
	private Integer paymentWay;
	/**
	 * 任务状态
	 */
	private Integer taskStatus;
	/**
	 * 订单描述
	 */
	private String orderBody;
	/**
	 * 物流单号
	 */
	private String trackingNo;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 仓库id
	 */
	private Long wareId;
	/**
	 * 工作单备注
	 */
	private String taskComment;

}
