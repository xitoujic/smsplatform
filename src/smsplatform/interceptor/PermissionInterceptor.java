/**
 *@time 2011-3-11
 *@author soledad pisces
 *@fileName PermissionInterceptor.java
 *@contract jiangguojian1990@qq.com
 */
package smsplatform.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author soledad pisces
 * 
 */
@SuppressWarnings("serial")
public class PermissionInterceptor implements Interceptor {
	public void destroy() {
		// To change body of implemented methods use File | Settings | File
		// Templates.
	}

	public void init() {
		// To change body of implemented methods use File | Settings | File
		// Templates.
	}

	/**
	 * @author soledad pisces
	 * @param actionInvocation
	 * @throws Exception
	 * 
	 *             "isLogin" with key "yes" in the session object all dispather
	 *             invoke() else alert the wrong message then redirect to index
	 *             page
	 * 
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if ("yes"
				.equals(ActionContext.getContext().getSession().get("isLogin"))) {

			return actionInvocation.invoke();
		} else {
			ActionContext.getContext().put("messageWarnning",
					"<script language='javascript'>" +
					"alert('you do not have the permission to enter the page')</script>");
			
			System.out.println("Permission of the operation intercepted!");

			return "interception";
		}
	}

}
