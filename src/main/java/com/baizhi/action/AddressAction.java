package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.AddressServiceImpl;

public class AddressAction {
	//地址的id
	private String addressId;
	private List<Address> list;
	private Address address;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	//查询该用户的所有地址信息
	public String selectAddresses(){
		AddressService addressService = new AddressServiceImpl();
		this.list = addressService.selectAddresses();
	    return "success";
	}
	//查询某一条地址（地址回显）——前提条件：addressId存在
	public String selectAddressById(){
		AddressService addressService = new AddressServiceImpl();
		this.list = addressService.selectAddresses();
		this.address = addressService.selectAddressById(this.addressId);
		return "success";
	}
}
