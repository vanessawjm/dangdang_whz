package com.baizhi.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;

public class CartAction {
	private String id;
	private Integer count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	//添加购物车
	@SuppressWarnings("unchecked")
	public String addCart(){
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String, CartItem> cart = (Map<String, CartItem>)session.getAttribute("cart");
		if (cart == null) {
		      cart = new HashMap<String, CartItem>();
		    }
		    if (cart.containsKey(id))
		    {
		      CartItem item = cart.get(id);
		      item.setCount(item.getCount()+1);
		    }
		    else
		    {
		      CartItem item = new CartItem();
		      BookService bookService = new BookServiceImpl();
		      Book book = bookService.selectBookById(id);
		      item.setBook(book);
		      item.setCount(Integer.valueOf(1));
		      cart.put(id, item);
		      session.setAttribute("cart", cart);
		    }
		    //调用计算的方法
		    calc();
		    return "success";
	}
	//删除购物车
	@SuppressWarnings("unchecked")
	public String deleteCart(){
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    Map<String, CartItem> cart = (Map<String, CartItem>)session.getAttribute("cart");
	    cart.remove(id);
	    if (cart.isEmpty()) {
	      session.removeAttribute("cart");
	    }
	    calc();
	    return "success";
	  }
	//更新购物车
	@SuppressWarnings("unchecked")
	public String updateCart(){
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    Map<String, CartItem> cart = (Map<String, CartItem>)session.getAttribute("cart");
	    CartItem item = cart.get(id);
	    item.setCount(count);//count
	    calc();
	    return "success";
	  }
	
	//计算总金额与节省金额
	@SuppressWarnings("unchecked")
	public void calc(){
		HttpSession session = ServletActionContext.getRequest().getSession();
	    Map<String, CartItem> cart = (Map<String, CartItem>)session.getAttribute("cart");
	    Double total = 0d;
	    Double save = 0d;
	    if (cart != null) {
	      for (Map.Entry<String, CartItem> entry : cart.entrySet()){
	    	CartItem cartItem = entry.getValue();//取出map中的值——CartItem对象
	    	total += cartItem.getBook().getDprice() * cartItem.getCount();
	    	save += (cartItem.getBook().getPrice()-cartItem.getBook().getDprice()) * cartItem.getCount();
	      }
	    }
	    session.setAttribute("total", total);
	    session.setAttribute("save", save);
	}
}
