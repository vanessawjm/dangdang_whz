package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.RuntimeErrorException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.baizhi.util.VerifyCodeUtils;
import com.opensymphony.xwork2.Action;

public class AdminAction {
	private Admin admin;
	private String message;
	private String code;
	

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/** 管理员登陆
	 * @return
	 */
	 public String login(){
		AdminService adminService = new AdminServiceImpl();
		try{
		  adminService.login(this.admin, this.code);
		  return "success";
		}catch (Exception e){
		  this.message = e.getMessage();
		  return "error";
		}	
	  }
	//验证码
	public void getImage() throws IOException{
		//1.生成字符
		String code = VerifyCodeUtils.generateVerifyCode(4);
		System.out.println(code);
		//2.放入session
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
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
	//安全退出
	public String safeOut(){
		//手动销毁管理员登陆信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginAdmin");
		return "success";
	}
}
