package command.filtter;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserSessionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String forward ="" ;
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		if(session.get("loginUser")!=null){
			forward = arg0.invoke();
		}else{
			forward = "againIndex";
		}
		return forward;
	}

	

}
