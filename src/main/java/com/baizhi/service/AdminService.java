package com.baizhi.service;


import com.baizhi.entity.Admin;

public interface AdminService {
	
	
	/** 后台：管理员登陆（出错时打印错误信息）
	 * @param admin
	 * @param code
	 */
	void login(Admin admin, String userCode); 
}
