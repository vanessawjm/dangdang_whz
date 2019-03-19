package com.baizhi.service;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MybatisUtils;

public class AdminServiceImpl implements AdminService {

@Override
public void login(Admin admin,String userCode) {
	SqlSession sqlSession = MybatisUtils.getSqlSession();
    AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
    HttpSession session = ServletActionContext.getRequest().getSession();
    String sessionCode = (String)session.getAttribute("code");
    if (sessionCode.equalsIgnoreCase(userCode)){
    	Admin loginAdmin = adminDao.login(admin);
    	if (loginAdmin != null){
		    session.setAttribute("loginAdmin", loginAdmin);
		    MybatisUtils.close();
    	}else{
    		throw new RuntimeException("账号或密码错误");
    	}
    }else{
      throw new RuntimeException("验证码错误");
    }
  }
}
