/**
 * 
 */
package com.pm.service.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.mapper.UserMapper;
import com.pm.util.PageData;



/**
 * @author xlonglong
 * @since:2015年12月24日下午3:32:19		
 * @version V1.0
 */
@Service
public class UserService {
	@Autowired
	private UserMapper usermapper;
	/*
	* 登录判断
	*/
	public PageData getUserByNameAndPwd(PageData pd)throws Exception{
		pd=usermapper.findByUId(pd);
		return pd;
	}
	/**更新用户最后一次登录时间*/
	public void updateLastlogin(PageData pd) throws Exception {
		usermapper.updateLastlogin(pd);
	}
}
