/**
 * 
 */
package com.fh.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pm.util.PageData;

/**
 * @author xlonglong
 * @since:2015年12月23日下午10:51:14		
 * @version V1.0
 */
public class BaseController {
	//protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

}
