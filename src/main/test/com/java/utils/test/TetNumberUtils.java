package com.java.utils.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.utils.NumberUtils;

public class TetNumberUtils {

	@Test
	public void test_rounded() {
		assertEquals((NumberUtils.rounded(1.7599, 2, 0) + ""), "1.76");
		assertEquals((NumberUtils.rounded(1.7599, 2, 1) + ""), "1.75");
	}
}