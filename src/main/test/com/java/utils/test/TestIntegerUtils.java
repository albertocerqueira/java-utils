package com.java.utils.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.java.utils.DateUtils;
import com.java.utils.IntegerUtils;

public class TestIntegerUtils {
	
	@Test
	public void test_isBlank() {
		Assert.assertEquals(IntegerUtils.isBlank(""), true);
		Assert.assertEquals(IntegerUtils.isBlank("albertocerqueira"), false);
		Assert.assertEquals(IntegerUtils.isBlank("1990"), false);
		Assert.assertEquals(IntegerUtils.isBlank(null), true);
	}
	
	@Test
	public void test_isOnlyNumber() {
		Assert.assertEquals(IntegerUtils.isOnlyNumber("albertocerqueira"), false);
		Assert.assertEquals(IntegerUtils.isOnlyNumber("albertocerqueira1990"), false);
		Assert.assertEquals(IntegerUtils.isOnlyNumber("1990"), true);
		Assert.assertEquals(IntegerUtils.isOnlyNumber(null), false);
	}
	
	@Test
	public void test_parseInt() {
		// parseInt for Number
		Number number1 = null;
		Assert.assertEquals(IntegerUtils.parseInt(number1), 0);
		Number number2 = 1;
		Assert.assertEquals(IntegerUtils.parseInt(number2), 1);
		
		// parseInt for String
		String string = null;
		Assert.assertEquals(IntegerUtils.parseInt(string), 0);
		Assert.assertEquals(IntegerUtils.parseInt(""), 0);
		Assert.assertEquals(IntegerUtils.parseInt(" "), 0);
		Assert.assertEquals(IntegerUtils.parseInt("albertocerqueira"), 0);
		Assert.assertEquals(IntegerUtils.parseInt("1990"), 1990);
		
		// parseInt for Date and Pattern
		Assert.assertEquals(IntegerUtils.parseInt(new Date(), "yyyyMMdd"), Integer.parseInt(DateUtils.today("yyyyMMdd")));
		Assert.assertEquals(IntegerUtils.parseInt(new Date(), "HHmm"), Integer.parseInt(DateUtils.today("HHmm")));
		Assert.assertEquals(IntegerUtils.parseInt(new Date(), "hhmm"), Integer.parseInt(DateUtils.today("hhmm")));
		Assert.assertEquals(IntegerUtils.parseInt(new Date(), "dd/MM/yyyy"), 0);
		Assert.assertEquals(IntegerUtils.parseInt(new Date(), "dd/MM/yyyy hh:mm:ss"), 0);
		
		// parseInt for Date
		Assert.assertEquals(IntegerUtils.parseInt(new Date()), Integer.parseInt(DateUtils.today("yyyyMMdd")));
		Date date = null;
		Assert.assertEquals(IntegerUtils.parseInt(date), 0);
	}
}