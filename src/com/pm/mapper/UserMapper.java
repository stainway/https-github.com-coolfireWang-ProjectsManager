package com.pm.mapper;
import com.pm.util.PageData;

public interface UserMapper {
	//value ������Bean ����һ�£�
	public PageData findByUId(PageData pageData);
	public void updateLastlogin(PageData pageData);
}
