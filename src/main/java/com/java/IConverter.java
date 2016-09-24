package com.java;

import com.java.exception.ConverterException;

public interface IConverter<T> {

	public T convert(String valor) throws ConverterException;
}