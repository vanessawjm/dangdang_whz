package com.baizhi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> selectAddresses() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("loginUser");
		List<Address> list = addressDao.selectAddress(user.getId());
		MybatisUtils.close();
		return list;
	}

	@Override
	public Address selectAddressById(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
	    Address address = addressDao.selectAddressById(id);
	    MybatisUtils.close();
	    return address;
	}

}
