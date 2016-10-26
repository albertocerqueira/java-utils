package com.java.utils.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.java.utils.DateUtils;
import com.java.utils.IntegerUtils;

public class TestIntegerUtils {
	
	@Test
	public void test_isBlank() {
		assertEquals(IntegerUtils.isBlank(""), true);
		assertEquals(IntegerUtils.isBlank("albertocerqueira"), false);
		assertEquals(IntegerUtils.isBlank("1990"), false);
		assertEquals(IntegerUtils.isBlank(null), true);
	}
	
	@Test
	public void test_isOnlyNumber() {
		assertEquals(IntegerUtils.isOnlyNumber("albertocerqueira"), false);
		assertEquals(IntegerUtils.isOnlyNumber("albertocerqueira1990"), false);
		assertEquals(IntegerUtils.isOnlyNumber("1990"), true);
		assertEquals(IntegerUtils.isOnlyNumber(null), false);
	}
	
	@Test
	public void test_parseInt() {
		// parseInt for Number
		Number number1 = null;
		assertEquals(IntegerUtils.parseInt(number1), 0);
		Number number2 = 1;
		assertEquals(IntegerUtils.parseInt(number2), 1);
		
		// parseInt for String
		String string = null;
		assertEquals(IntegerUtils.parseInt(string), 0);
		assertEquals(IntegerUtils.parseInt(""), 0);
		assertEquals(IntegerUtils.parseInt(" "), 0);
		assertEquals(IntegerUtils.parseInt("albertocerqueira"), 0);
		assertEquals(IntegerUtils.parseInt("1990"), 1990);
		
		// parseInt for Date and Pattern
		assertEquals(IntegerUtils.parseInt(new Date(), "yyyyMMdd"), Integer.parseInt(DateUtils.today("yyyyMMdd")));
		assertEquals(IntegerUtils.parseInt(new Date(), "HHmm"), Integer.parseInt(DateUtils.today("HHmm")));
		assertEquals(IntegerUtils.parseInt(new Date(), "hhmm"), Integer.parseInt(DateUtils.today("hhmm")));
		assertEquals(IntegerUtils.parseInt(new Date(), "dd/MM/yyyy"), 0);
		assertEquals(IntegerUtils.parseInt(new Date(), "dd/MM/yyyy hh:mm:ss"), 0);
		
		// parseInt for Date
		assertEquals(IntegerUtils.parseInt(new Date()), Integer.parseInt(DateUtils.today("yyyyMMdd")));
		Date date = null;
		assertEquals(IntegerUtils.parseInt(date), 0);
	}
}