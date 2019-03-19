package com.baizhi.entity;

import java.util.Date;

public class Item {
	private String id;
	private String bookId;
	private Integer count;
	private Date createDate;
	private String orderId;
	private Book book;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", bookId=" + bookId + ", count=" + count
				+ ", createDate=" + createDate + ", orderId=" + orderId
				+ ", book=" + book + "]";
	}
	public Item(String id, String bookId, Integer count, Date createDate,
			String orderId, Book book) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createDate = createDate;
		this.orderId = orderId;
		this.book = book;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
