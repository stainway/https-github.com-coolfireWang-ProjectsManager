/**
 * 
 */
package com.pm.util;

/**
 * @author xlonglong
 * @since:2015��12��24������3:27:03		
 * @version V1.0
 */
public class Tools {

	/**
	 * ����ַ����Ƿ�Ϊ��(null,"","null")
	 * @param s
	 * @return ��Ϊ���򷵻�true�����򷵻�false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	/**
	 * ����ַ����Ƿ�Ϊ��(null,"","null")
	 * @param s
	 * @return Ϊ���򷵻�true�������򷵻�false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}
}
