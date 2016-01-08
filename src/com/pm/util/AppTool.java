/**
 * 
 */
package com.pm.util;

import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;



/**
 * @author xlonglong
 * @since:2015年12月25日下午2:36:35		
 * @version V1.0
 */
public class AppTool {

	public static Object returnObject(PageData pd, Map map){
		if(pd.containsKey("callback")){
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		}else{
			return map;
		}
	}
}
