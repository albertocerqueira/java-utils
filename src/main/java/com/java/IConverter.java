package com.java;

public interface IConverter<T> {

	public T convert(String valor) throws ConverterException;
}