package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao {
	

	/** 后台：管理员登陆
	 * @param admin
	 * @return
	 */
	Admin login(Admin admin);
}
