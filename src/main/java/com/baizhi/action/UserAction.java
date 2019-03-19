package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.VerifyCodeUtils;

public class UserAction {
	private User user;
	private String code;
	private String message;
	private String emailCode;
	private String email;
	private List<User> list;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
	//用户注册
	public String regist(){
    UserService userService = new UserServiceImpl();
	    try{
	      userService.regist(user,code);
	      System.out.println("注册信息："+user);
	      return "success";
	    }catch (Exception e){
	      this.message = e.getMessage();
	    }
	    return "error";
    }
	//验证码
	public void getImage() throws IOException{
		//1.生成字符
		String code = VerifyCodeUtils.generateVerifyCode(4);
		System.out.println("验证码："+code);
		//2.放入session
		ServletActionContext.getRequest().getSession().setAttribute("securityCode", code);
		//3.生成图片
		BufferedImage image = VerifyCodeUtils.getImage(100, 35, code);
		//4.响应图片  获取响应流
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/png;charset=UTF-8");
		ServletOutputStream os = response.getOutputStream();
		//5.输出图片
		ImageIO.write(image,"png", os);
		os.close();
	}
	//邮箱验证码
	 public String sendEmailCode(){
	     emailCode = MD5Utils.getSalt(); 
	     HttpSession session = ServletActionContext.getRequest().getSession();
	     session.setAttribute("emailCode", emailCode);
	     return "success";
	  }
	 //激活用户
	 public String active() {
	    UserService userService = new UserServiceImpl();
	    try{
	      userService.activeUser(code);
	      return "success";
	    }catch (Exception e){
	      this.message = e.getMessage();
	    }
	    return "error";
	 }
	 //用户登录
	 public String login(){
	    UserService userService = new UserServiceImpl();
	    try{
	      userService.login(user.getEmail(),user.getPassword());
	      return "success";
	    }catch (Exception e){
	      this.message = e.getMessage();
	    }
	    return "error";
	 }
	 //用户退出
	 public String exit(){
		 //移除登录信息、购物车、总价、节省金额
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginUser");
		session.removeAttribute("cart");
		session.removeAttribute("total");
		session.removeAttribute("save");
		return "success";
	 }
	 //后台：查询所有用户
	 public String selectAllUser(){
		 UserService userService = new UserServiceImpl();
		 list = userService.selectAllUser();
		 return "success";
	 }
	  
	 //后台：修改用户状态
	 public String updateUserStatus(){
	     UserService userService = new UserServiceImpl();
	     userService.updateUserStatus(email);
	     return "success";
	 }
}

