package com.baizhi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrder(Address address) {
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		Double total = (Double)session.getAttribute("total");
		Map<String, CartItem> cart = (Map)session.getAttribute("cart");
		
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
	    OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
	    ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    
	    try{
	    	//判断是否是新地址
	    	if(address.getId()==null || "".equals(address.getId())){
	    		//新地址——>存入数据库
	    		address.setId(UUID.randomUUID().toString());
	    		address.setUserId(loginUser.getId());
	    		addressDao.addAddress(address);
	    	}else{
	    		//旧地址——>判断是否发生改变
	    		Address checkAddress = addressDao.selectAddressById(address.getId());
	    		if(!checkAddress.equals(address)) {
	    	       addressDao.updateAddress(address);
	    	    }
	    	}
	    	//添加订单
	    	 Date date = new Date();
	         Order order = new Order();
	         order.setId(UUID.randomUUID().toString());
	         order.setOrderNo(String.valueOf(date.getTime()));
	         session.setAttribute("orderNo", order.getOrderNo());
	         
	         order.setUserId(loginUser.getId());
	         order.setTotal(total);
	         order.setCreateDate(date);
	         order.setAddressId(address.getId());
	         order.setStatus("未支付");
	         orderDao.addOrder(order);
	         //添加订单项
	         for (Map.Entry<String, CartItem> entry : cart.entrySet()){
	           Item item = new Item();
	           item.setId(UUID.randomUUID().toString());
	           item.setBookId(entry.getKey());
	           item.setCount((entry.getValue()).getCount());
	           item.setCreateDate(date);
	           item.setOrderId(order.getId());
	           itemDao.addItem(item);
	           //修改图书库存与销量
	           bookDao.updateBookSaleAndStock(entry.getKey(), (entry.getValue()).getCount());
	         }
	         //移除购物车
	         session.removeAttribute("cart");
	         MybatisUtils.commit();
	    }catch(Exception e){
	    	MybatisUtils.rollback();
	    	e.printStackTrace();
	    	throw new RuntimeException("添加订单失败");
	    }
	}

	@Override
	public List<Order> selectAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
	    List<Order> list = orderDao.selectAll();
	    MybatisUtils.close();
	    return list;
	}
	
	@Override
	public Order selectOrderDetail(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
	    BookDao bookDao = sqlSession.getMapper(BookDao.class);
	    Order order = orderDao.selectOrderDetail(id);
	    for (Item item : order.getItems()){
	      Book book = bookDao.selectBookById(item.getBookId());
	      item.setBook(book);
	    }
	    MybatisUtils.close();
	    return order;
	}
}
