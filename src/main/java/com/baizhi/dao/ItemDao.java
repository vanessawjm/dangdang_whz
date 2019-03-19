package com.baizhi.dao;

import com.baizhi.entity.Item;

public interface ItemDao {
	/** 前台：添加订单项
	 * @param item
	 */
	public void addItem(Item item);
}
