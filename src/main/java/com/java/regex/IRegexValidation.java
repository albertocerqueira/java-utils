package com.java.regex;

public interface IRegexValidation {
	
	public String expression();
	public boolean evaluate(String value);
	public String name();
}