package com.pm.mapper;
import com.pm.util.PageData;

public interface UserMapper {
	//value 必须与Bean 属性一致！
	public PageData findByUId(PageData pageData);
	public void updateLastlogin(PageData pageData);
}
