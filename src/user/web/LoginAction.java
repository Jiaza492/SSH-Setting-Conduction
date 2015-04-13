package user.web;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.Tbuser;

/**
 * 1.页面有值传给servlet吗 2.servlet有值传给页面吗 把这些值变成我这个类的属性 3.如何和biz发生交互----周五讲
 * 
 * 4.如何跳转一个页面----map key value main.jsp left.jsp 5.解决中文乱码问题:需要配置struts.xml
 * <constant name="struts.i18n.encoding" value="UTF-8"></constant> 6.权限过滤器
 * 要想让struts2的类获得httpSession对象 需要让你的类 实现一个接口.sessionAware
 * 把httpsession对象封装在一个map<String,Object>里, 这个map的对象名必须要叫session
 * 要想让struts2的类获得httpServletRequest对象 需要让你的类 实现一个接口.requestAware
 * 把httpServletRequest对象封装在一个map<String,Object>里, 这个map的对象名必须要叫request
 * 要想让struts2的类获得httpServletResponse对象 需要让你的类 实现一个接口。responseAware
 * 把httpServletResponse对象封装在一个map<String,Object>里, 这个map的对象名必须要叫response
 **/

public class LoginAction extends ActionSupport implements SessionAware {

	private Tbuser user;
	private String msg;
	private Map<String, Object> session;

	public String login() {
		String forward = "";
		if (this.user != null) {
			
			session.put("loginUser", user);
			forward = "main";
		}else{
			forward = "index";
		}
		return forward;
	}

	public Tbuser getUser() {
		return user;
	}

	public void setUser(Tbuser user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
