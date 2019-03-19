package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;

public interface OrderService {
	public void addOrder(Address address);
	/** 后台：展示所有订单
	 * @return
	 */
	public List<Order> selectAll();
	/** 后台：查询某个订单详细信息
	 * @param id
	 * @return
	 */
	public Order selectOrderDetail(String id);
}
