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
 * @since:2015��12��24������3:32:19		
 * @version V1.0
 */
@Service
public class UserService {
	@Autowired
	private UserMapper usermapper;
	/*
	* ��¼�ж�
	*/
	public PageData getUserByNameAndPwd(PageData pd)throws Exception{
		pd=usermapper.findByUId(pd);
		return pd;
	}
	/**�����û����һ�ε�¼ʱ��*/
	public void updateLastlogin(PageData pd) throws Exception {
		usermapper.updateLastlogin(pd);
	}
}
