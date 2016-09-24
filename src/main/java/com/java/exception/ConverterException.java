package com.java.exception;

import com.java.utils.LogUtils;

public class ConverterException extends UserException {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public ConverterException(Class origin, Throwable cause) {
		super(cause);
		LogUtils.error(origin, cause);
	}
	
	@SuppressWarnings("rawtypes")
	public ConverterException(Class origin, String message) {
		super(message);
		LogUtils.error(origin, message);
	}
}