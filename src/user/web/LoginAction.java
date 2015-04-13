package user.web;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.Tbuser;

/**
 * 1.ҳ����ֵ����servlet�� 2.servlet��ֵ����ҳ���� ����Щֵ��������������� 3.��κ�biz��������----���彲
 * 
 * 4.�����תһ��ҳ��----map key value main.jsp left.jsp 5.���������������:��Ҫ����struts.xml
 * <constant name="struts.i18n.encoding" value="UTF-8"></constant> 6.Ȩ�޹�����
 * Ҫ����struts2������httpSession���� ��Ҫ������� ʵ��һ���ӿ�.sessionAware
 * ��httpsession�����װ��һ��map<String,Object>��, ���map�Ķ���������Ҫ��session
 * Ҫ����struts2������httpServletRequest���� ��Ҫ������� ʵ��һ���ӿ�.requestAware
 * ��httpServletRequest�����װ��һ��map<String,Object>��, ���map�Ķ���������Ҫ��request
 * Ҫ����struts2������httpServletResponse���� ��Ҫ������� ʵ��һ���ӿڡ�responseAware
 * ��httpServletResponse�����װ��һ��map<String,Object>��, ���map�Ķ���������Ҫ��response
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
