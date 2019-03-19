package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	/** 前台：查询某个用户的所有地址
	 * @param user_id
	 * @return
	 */
	public List<Address> selectAddresses();
	/** 前台：查询选中的地址
	 * @param id
	 * @return
	 */
	public Address selectAddressById(String id);
}
