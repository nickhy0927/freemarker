package com.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	public static Map<String, Object> getRequestToMap(HttpServletRequest request) {
		Map<String, Object> paramsMap = new HashMap<String,Object>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = (String) parameterNames.nextElement();
			String value = request.getParameter(key);
			paramsMap.put(key, value);
		}
		return paramsMap;
	}
}
