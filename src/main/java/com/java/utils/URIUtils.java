package com.java.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class URIUtils {

	public static Map<String, String> getParamsURI(String uri) {
		if (StringUtils.isBlank(uri)) {
			return new HashMap<String, String>();
		}
		
		String[] parts = uri.split("[?]");
		if (parts == null || parts.length <= 1) {
			return new HashMap<String, String>();
		}
		
		String[] params = parts[1].split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String p : params) {
			String[] param = p.split("=");
			String name = param[0];
			
			if (param.length > 1) {
				String value = param[1];
				map.put(name, value);
			} else {
				map.put(name, null);
			}
		}
		
		return map;
	}
	
	public static String context(String url, int position) {
		if (!StringUtils.isBlank(url)) {
			String[] path = url.split("/");
			return path[position];
		} else {
			return "";
		}
	}
	
	public static Map<String, String> getParamsQuery(String query) {
		if (StringUtils.isBlank(query)) {
			return new HashMap<String, String>();
		}
		
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		
		return map;
	}
	
	public static boolean dnsValid(String dns) {
		try {
			InetAddress inetAddress = InetAddress.getByName(dns);
			inetAddress.getHostName();
		    inetAddress.getHostAddress();
		    return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}
}