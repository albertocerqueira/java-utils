package com.java.utils.test;

import org.junit.Assert;
import org.junit.Test;

import com.java.utils.DoubleUtils;

public class TestDoubleUtils {

	@Test
	public void test_isBlank() {
		Assert.assertEquals(DoubleUtils.isBlank(""), true);
		Assert.assertEquals(DoubleUtils.isBlank("albertocerqueira"), false);
		Assert.assertEquals(DoubleUtils.isBlank("1990"), false);
		Assert.assertEquals(DoubleUtils.isBlank("0.00001"), false);
		Assert.assertEquals(DoubleUtils.isBlank(null), true);
	}
	
	@Test
	public void test_isOnlyNumber() {
		Assert.assertEquals(DoubleUtils.isOnlyNumber("albertocerqueira"), false);
		Assert.assertEquals(DoubleUtils.isOnlyNumber("albertocerqueira1990"), false);
		Assert.assertEquals(DoubleUtils.isOnlyNumber("1990"), true);
		Assert.assertEquals(DoubleUtils.isOnlyNumber("0.00001"), true);
		Assert.assertEquals(DoubleUtils.isOnlyNumber(null), false);
	}
	
	@Test
	public void test_isZero() {
		Assert.assertEquals(DoubleUtils.isZero("0"), true);
		try {
			Assert.assertEquals(DoubleUtils.isZero("albertocerqueira1990"), false);
			Assert.fail();
		} catch (Exception e) {
			
		}
		Assert.assertEquals(DoubleUtils.isZero("1990"), false);
		Assert.assertEquals(DoubleUtils.isZero("0.00001"), false);
		try {
			Assert.assertEquals(DoubleUtils.isZero(null), false);
			Assert.fail();
		} catch (Exception e) {
			
		}
	}
}