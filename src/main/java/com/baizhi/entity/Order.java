package com.baizhi.entity;

import java.util.Date;
import java.util.List;


public class Order {
	private String id;
	private String orderNo;
	private String userId;
	private Double total;
	private Date createDate;
	private String status;
	private String addressId;
	//关系对象
	private Address addre;
	private List<Item> items;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public Address getAddre() {
		return addre;
	}
	public void setAddre(Address addre) {
		this.addre = addre;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", userId="
				+ userId + ", total=" + total + ", createDate=" + createDate
				+ ", status=" + status + ", addressId=" + addressId + ", addre="
				+ addre + ", items=" + items + "]";
	}
	
	public Order(String id, String orderNo, String userId, Double total,
			Date createDate, String status, String addressId) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userId = userId;
		this.total = total;
		this.createDate = createDate;
		this.status = status;
		this.addressId = addressId;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
