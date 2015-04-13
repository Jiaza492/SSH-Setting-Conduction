package user.web;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{

	public String top(){
		String target = "top";
		return target;
	}
	
	public String right(){
		String target = "right";
		return target;
	}
	
	public String left(){
		String target ="left";
		return target;
	}
	
}
