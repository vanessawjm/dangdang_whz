package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao {
	/** 前台 ：用户注册
	 * @param user
	 */
	public void regist(User user);
	/** 前台：用户登录（根据email查找用户是否存在）
	 * @param email
	 * @return
	 */
	public User selectUserByEamil(String email);
	/** 前台：激活用户
	 * @param id
	 * @param code
	 */
	public void activeUser(@Param("id") String id, @Param("code") String code);
	/** 后台：查询所有用户
	 * @return
	 */
	public List<User> selectAllUser();
	/** 后台：修改用户权限
	 * @param email
	 * @param status
	 */
	public void updateUserStatus(@Param("email") String email, @Param("status") String status);
}
