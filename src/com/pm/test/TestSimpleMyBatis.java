package com.pm.test;

import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pm.domain.system.User;
import com.pm.mapper.UserMapper;
import com.pm.util.DateTool;
import com.pm.util.PageData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:*.xml"})
public class TestSimpleMyBatis {
	@Autowired
	private UserMapper userMapper;

//	@Test
//	public void testfindByUId()
//	{
//		PageData pd=new PageData();
//		 String USERNAME="xlonglong";
//    	 String PASSWORD="123456";
//    	 String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();	//√‹¬Îº”√‹
//	   pd.put("USERNAME", USERNAME);
//	   pd.put("PASSWORD", passwd);
//	   
//	   pd=userMapper.findByUId(pd);
//	   System.out.println(pd.size());
//	   System.out.println(pd.get("USERNAME"));
//	
//	}
	
	@Test
	public void testupdateLastlogin()
	{
		PageData pd=new PageData();
		pd.put("USERID", "1");
		pd.put("LASTLOGIN", DateTool.getNow2());
		userMapper.updateLastlogin(pd);
	}
   
}