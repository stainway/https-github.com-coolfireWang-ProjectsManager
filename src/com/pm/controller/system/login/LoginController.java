/**
 * 
 */
package com.pm.controller.system.login;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.pm.domain.system.User;
import com.pm.service.system.user.UserService;
import com.pm.util.AppTool;
import com.pm.util.Const;
import com.pm.util.DateTool;
import com.pm.util.PageData;
import com.pm.util.Tools;

/**
 * @author xlonglong
 *
 * @version V1.0
 */
/**
 * 主入口
 * */
@Controller
public class LoginController extends BaseController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/login_login")
	@ResponseBody
	public Object login()throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String errInfo = "";
		String KEYDATA[] = pd.getString("KEYDATA").replaceAll("qq313596790fh", "").replaceAll("QQ978336446fh", "").split(",fh,");
	    if(null!=KEYDATA &&KEYDATA.length==3)
	    {
	    	Subject currentUser=SecurityUtils.getSubject();
	    	Session session=currentUser.getSession();
	    	
	    	String sessionCode=(String) session.getAttribute(Const.SESSION_SECURITY_CODE);
	    	
	    	String code=KEYDATA[2];
	    	if(null == code || "".equals(code)){
				errInfo = "nullcode";
			}else{
				String USERNAME=KEYDATA[0];
				String PASSWORD=KEYDATA[1];
				pd.put("USERNAME", USERNAME);
				if(Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)){
					String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();	//�������
					pd.put("PASSWORD", passwd);
					pd=userService.getUserByNameAndPwd(pd);
					if(pd!=null) 
					{
						pd.put("LASTLOGIN", DateTool.getNow2());
						userService.updateLastlogin(pd);
						User user=new User(); 
						user.setUserid(pd.getString("USERID"));
						user.setUserName(pd.getString("USERNAME"));
						user.setPassword(pd.getString("PASSWORD"));
						user.setName(pd.getString("NAME"));
						user.setLastLogin(pd.getString("LASTLOGIN"));
						user.setStatus(pd.getString("STATUS"));
						user.setEmail(pd.getString("EMAIL"));
						user.setPhone(pd.getString("PHONE"));
						session.setAttribute(Const.SESSION_USER, user);
						session.removeAttribute(Const.SESSION_SECURITY_CODE);
	//֤
						Subject subject=SecurityUtils.getSubject();
						UsernamePasswordToken token=new UsernamePasswordToken(USERNAME,PASSWORD);
					try{
						subject.login(token);
					}catch(Exception e){
						errInfo="登录异常";
						logger.error(e);
					}
					}else{
						errInfo="username or password error!"; 
					}
				}else{
					errInfo="codeerror"; 
				}
				
			}
	    	if(Tools.isEmpty(errInfo))
	    	{
	    		errInfo="success";
	    	}
	    	
	    }else{
	    	errInfo="error";
	    }
	    map.put("result", errInfo);
		
		return AppTool.returnObject(new PageData(), map);
		
	}
	
	/**
	 * ����ϵͳ��ҳ
	 */
	@RequestMapping(value="/main/{changeMenu}")
	public ModelAndView login_main(@PathVariable("changeMenu") String changeMenu)
	{
		System.out.println("请求system/admin/Main 页面");
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("system/admin/Main");
		return mv;
	}
	
	
	
}
