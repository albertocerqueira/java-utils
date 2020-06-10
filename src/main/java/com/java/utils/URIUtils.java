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
		
		String[] partes = uri.split("[?]");
		if (partes == null || partes.length <= 1) {
			return new HashMap<String, String>();
		}
		
		String[] parametros = partes[1].split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : parametros) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
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