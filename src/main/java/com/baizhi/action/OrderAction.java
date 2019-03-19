package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;

public class OrderAction {
	private Address address;
	private String id;
	private Order order;
	private String orderNo;
	private List<Order> list;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	//添加订单
	public String addOrder(){
	    OrderService orderService = new OrderServiceImpl();
	    try{
	    	orderService.addOrder(address);
	    }catch (Exception e){
	    	e.printStackTrace();;
	    }
	    return "success";
	 }
	//后台查询所有订单
	public String selectAll(){
	    OrderService orderService = new OrderServiceImpl();
	    this.list = orderService.selectAll();
	    return "success";
	}
	//后台查询订单详情
	public String selectOrderDetail(){
	    OrderService orderService = new OrderServiceImpl();
	    this.order = orderService.selectOrderDetail(id);
	    return "success";
	}
}
