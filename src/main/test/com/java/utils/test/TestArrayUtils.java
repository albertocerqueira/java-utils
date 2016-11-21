package com.java.utils.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.utils.ArrayUtils;

public class TestArrayUtils {

	private ArrayUtils array = new ArrayUtils(3);
	
	@Before
	public void init() {
		array.putValue(0, 30);
		array.putValue(1, 20);
		array.putValue(2, 10);
	}
	
	@Test
	public void test_sort() {
		array.print();
		array.sort();
		array.print();
	}
	
	@Test
	public void test_getMaximum() {
		assertEquals(array.getMaximum() + "", "30.0");
	}
}