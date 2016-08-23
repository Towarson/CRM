package com.atguigu.crm.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CRMUtils {
	
	public static String encodeParameterMapToQueryString(Map<String, Object> parameters,String prefix) {
		
		StringBuilder queryString = new StringBuilder();
		
		if(parameters != null && parameters.size() > 0) {
			Set<Entry<String, Object>> entrySet = parameters.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				String key = entry.getKey();
				Object value = entry.getValue();
				
				if(value == null || value.toString().trim().equals("")) {
					continue;
				}
				queryString.append("&")
						   .append(prefix)
						   .append(key)
						   .append("=")
						   .append(value);
			}
		}
		if(queryString.length() > 0) {
			return queryString.toString();
		}
		return null;
	}
}
