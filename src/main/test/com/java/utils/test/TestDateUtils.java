package com.java.utils.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.java.utils.DateUtils;
import com.java.utils.LocaleUtils;

public class TestDateUtils {
	
	@Test
	public void test_convertPattern() {
		try {
			assertEquals(DateUtils.convertPattern("1990-06-23", "yyyy-MM-dd", "dd/MM/yyyy"), "23/06/1990");
		} catch (ParseException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test_today() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
        String today = format.format(new Date());
		assertEquals(DateUtils.today("dd/MM/yyyy"), today);
	}
}