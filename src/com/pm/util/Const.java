/**
 * 
 */
package com.pm.util;

/**
 * @author xlonglong
 * @since:2015��12��24������11:45:11		
 * @version V1.0
 */
public class Const {

	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER="sessionUser";
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）
	public static final String LOGIN="/index.jsp";
}
