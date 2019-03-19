package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDao {
	/** 前台：添加订单
	 * @param order
	 */
	public void addOrder(Order order);
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
