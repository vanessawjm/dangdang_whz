package com.baizhi.interceptor;

import com.baizhi.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class AdminInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception{
	HttpSession session = ServletActionContext.getRequest().getSession();
	Admin admin = (Admin)session.getAttribute("loginAdmin");
		if (admin == null) {
			return "adminLogin";
		}
		invocation.invoke();
		return null;	
	}
}
