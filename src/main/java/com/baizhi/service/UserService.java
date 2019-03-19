package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	/** 前台 ：用户注册
	 * @param user
	 * @param inputCode
	 */
	public void regist(User user, String code);
	/** 激活用户
	 * @param code
	 */
	public void activeUser(String code);
	/** 前台：用户登录
	 * @param username
	 * @param password
	 */
	public void login(String username, String password);
	/** 后台：查询所有用户
	 * @return
	 */
	public List<User> selectAllUser();
	/** 后台：修改用户权限
	 * @param email
	 * @param status
	 */
	public void updateUserStatus(String email);
}
