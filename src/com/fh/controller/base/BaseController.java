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
 * @since:2015��12��23������10:51:14		
 * @version V1.0
 */
public class BaseController {
	//protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	/**
	 * �õ�ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	/**
	 * �õ�PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	/**
	 * �õ�request����
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

}
