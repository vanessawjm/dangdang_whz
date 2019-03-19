package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user, String code) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		
	    String securityCode = (String)session.getAttribute("securityCode");
	    if (securityCode.equalsIgnoreCase(code)){
	      User checkUser = userDao.selectUserByEamil(user.getEmail());
	      if (checkUser == null){
	        user.setId(UUID.randomUUID().toString());
	        user.setSalt(MD5Utils.getSalt());
	        
	        user.setPassword(MD5Utils.getPassword(user.getPassword() + user.getSalt()));
	        user.setStatus("正常");
	        try{
	          userDao.regist(user);
	          MybatisUtils.commit();
	          session.setAttribute("loginUser", user);
	        }catch (Exception e){
	          e.printStackTrace();
	          MybatisUtils.rollback();
	          throw new RuntimeException("用户注册失败");
	        }
	      }
	      else{
	        throw new RuntimeException("该邮箱已被注册，请更换邮箱");
	      }
	    }
	    else{
	      throw new RuntimeException("验证码错误");
	    }
	  }

	@Override
	public void activeUser(String code) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取登陆的用户对象 和 该对象的 邮箱验证码
	    User loginUser = (User) session.getAttribute("loginUser");
	    String emailCode = (String)session.getAttribute("emailCode");
	    //如果邮箱验证码正确 则激活用户，将用户的激活码存放入数据库
	    if (emailCode.equals(code)) {
	        try{
	          userDao.activeUser(loginUser.getId(), code);
	          MybatisUtils.commit();
	          loginUser.setCode(code);
	          session.setAttribute("loginUser",loginUser);
	        }catch (Exception e){
	          MybatisUtils.rollback();
	          throw new RuntimeException("激活用户失败");
	        }
	        //邮箱验证码不正确则报错
	      }else{
	        throw new RuntimeException("邮箱验证码错误");
	      }
	}

	@Override
	public void login(String username, String password) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    UserDao userDao = (UserDao)sqlSession.getMapper(UserDao.class);
	    User user = userDao.selectUserByEamil(username);
	    //先判断用户名是否存在 再判断用户的权限状态 最后判断密码
	    if (user != null){
	      if ("正常".equals(user.getStatus())){
	        if (user.getPassword().equals(MD5Utils.getPassword(password + user.getSalt()))){
	          HttpSession session = ServletActionContext.getRequest().getSession();
	          session.setAttribute("loginUser", user);
	        }else{
	          throw new RuntimeException("密码错误");
	        }
	      }else{
	        throw new RuntimeException("用户因违规操作被冻结");
	      }
	    }else{
	      throw new RuntimeException("用户名不存在");
	    }
	  }

	@Override
	public List<User> selectAllUser() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
	    UserDao userDao = sqlSession.getMapper(UserDao.class);
	    List<User> list = userDao.selectAllUser();
	    MybatisUtils.close();
	    return list;
	}

	@Override
	public void updateUserStatus(String email) {
	    SqlSession sqlSession = MybatisUtils.getSqlSession();
	    UserDao userDao = sqlSession.getMapper(UserDao.class);
	    User user = userDao.selectUserByEamil(email);
	    try{
	    	if("正常".equals(user.getStatus())){
	    		userDao.updateUserStatus(email, "冻结");
	    	}else{
	    		userDao.updateUserStatus(email, "正常");
	    	}
	      MybatisUtils.commit();
	    }catch (Exception e){
	      MybatisUtils.rollback();
	      e.printStackTrace();
	    }
	}
}
