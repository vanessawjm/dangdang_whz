package com.baizhi.interceptor;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class UserInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception{
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    User user = (User)session.getAttribute("loginUser");
	    if (user == null) {
	      return "userLogin";
	    }
	    if ((user.getCode() == null) || ("".equals(user.getCode()))) {
	      return "userActive";
	    }
	    invocation.invoke(); 
	    return null;
	}
}