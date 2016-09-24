package com.java.utils;

import com.java.IConverter;
import com.java.exception.ConverterException;

public class BooleanConverter implements IConverter<Boolean> {

	private static BooleanConverter instance = new BooleanConverter();

	private BooleanConverter() {}

	public static BooleanConverter getInstance() {
		return instance;
	}

	@Override
	public Boolean convert(String valor) throws ConverterException {
		if (valor == null || "".equals(valor) || "false".equalsIgnoreCase(valor) || "f".equalsIgnoreCase(valor) || "null".equalsIgnoreCase(valor) || "0".equals(valor) || "n".equalsIgnoreCase(valor)) {
			return Boolean.FALSE;
		} else if ("true".equalsIgnoreCase(valor) || "t".equalsIgnoreCase(valor) || "s".equalsIgnoreCase(valor) || "1".equals(valor)) {
			return Boolean.TRUE;
		}
		return null;
	}
}