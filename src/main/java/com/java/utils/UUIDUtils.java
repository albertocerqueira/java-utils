package com.java.utils;

import java.util.UUID;

/**
 * UUID Utils
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 */
public class UUIDUtils {

	private UUIDUtils() {
        throw new AssertionError();
    }
	
	/**
	 * Gerador de UUID randômico
	 * @return (String) string UUID randômica
	 */
	public static String generateUUID() {
		return UUID.randomUUID().getLeastSignificantBits() + "";
	}
}