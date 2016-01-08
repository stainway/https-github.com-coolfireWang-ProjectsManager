/**
 * 
 */
package com.pm.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pm.domain.system.User;
import com.pm.util.Const;

/**
 * @author xlonglong
 * @since:2016年1月7日下午4:29:32		
 * @version V1.0
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("过滤用户");
		String path=request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}else{
			//shiro管理的session
			Subject currentUser=SecurityUtils.getSubject();
			Session session=currentUser.getSession();
			User user=(User) session.getAttribute(Const.SESSION_USER);
			if(user!=null)
			{
				return true;
			}else{
				response.sendRedirect(request.getContextPath() + Const.LOGIN);
				return false;
			}
			
		}
	}
}
