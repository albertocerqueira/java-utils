package com.java.utils.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.java.utils.StringUtils;

public class TestStringUtils {
	
	@Test
	public void test_isBlank() {
		assertEquals(StringUtils.isBlank(""), true);
		assertEquals(StringUtils.isBlank("albertocerqueira"), false);
		assertEquals(StringUtils.isBlank(null), true);
	}
	
	@Test
	public void test_isOnlyLetters() {
		assertEquals(StringUtils.isOnlyLetters("albertocerqueira"), true);
		assertEquals(StringUtils.isOnlyLetters("albertocerqueira1990"), false);
		assertEquals(StringUtils.isOnlyLetters(null), false);
	}
	
	@Test
	public void test_isOnlyLettersOrNumbers() {
		assertEquals(StringUtils.isOnlyLettersOrNumbers("albertocerqueira"), true);
		assertEquals(StringUtils.isOnlyLettersOrNumbers("albertocerqueira1990"), true);
		assertEquals(StringUtils.isOnlyLettersOrNumbers(null), false);
	}
	
	@Test
	public void test_normalizeOnlyLettersNumbers() {
		assertEquals(StringUtils.normalizeOnlyLettersNumbers("albertocerqueira"), "albertocerqueira");
		assertEquals(StringUtils.normalizeOnlyLettersNumbers("albertocerqueira1990"), "albertocerqueira1990");
		assertEquals(StringUtils.normalizeOnlyLettersNumbers("@lberto.cerqueira-1990"), "lbertocerqueira1990");
	}
}