package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	/** 前台：查询某个用户的所有地址
	 * @param user_id
	 * @return
	 */
	public List<Address> selectAddress(String user_id);
	/** 前台：查询选中的地址
	 * @param id
	 * @return
	 */
	public Address selectAddressById(String id);
	/** 前台：添加地址
	 * @param address
	 */
	public void addAddress(Address address);
	/** 前台：更新地址
	 * @param address
	 */
	public void updateAddress(Address address);
}
