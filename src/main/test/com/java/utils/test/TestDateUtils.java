package com.java.utils.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.java.utils.DateUtils;
import com.java.utils.LocaleUtils;

public class TestDateUtils {
	
	@Test
	public void test_convertPattern() {
		try {
			Assert.assertEquals(DateUtils.convertPattern("1990-06-23", "yyyy-MM-dd", "dd/MM/yyyy"), "23/06/1990");
		} catch (ParseException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test_today() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
        String today = format.format(new Date());
        Assert.assertEquals(DateUtils.today("dd/MM/yyyy"), today);
	}
	
	@Test
	public void test_tomorrow() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
        String tomorrow = format.format(c.getTime());
        Assert.assertEquals(DateUtils.tomorrow("dd/MM/yyyy"), tomorrow);
	}
	
	@Test
	public void test_daysAndMonths() {
		Assert.assertEquals(DateUtils.catchFirstDayOfMonth(Calendar.JANUARY, "dd/MM"), "01/01");
		Assert.assertEquals(DateUtils.catchLastDayOfMonth(Calendar.JANUARY, "dd/MM"), "31/01");
		
		SimpleDateFormat format = new SimpleDateFormat("MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
		String mes = format.format(new Date());
		Assert.assertEquals(DateUtils.catchFirstDayOfCurrentMonth("MM/yyyy"), mes);
		Assert.assertEquals(DateUtils.catchLastDayOfCurrentMonth("MM/yyyy"), mes);
		Assert.assertEquals(DateUtils.catchFirstDayOfCurrentMonth(), ("01/" + mes));
		String expectedTitles[] = {("28/" + mes), ("29/" + mes), ("30/" + mes), ("31/" + mes)};
		List<String> expectedTitlesList = Arrays.asList(expectedTitles);
		Assert.assertTrue(expectedTitlesList.contains((DateUtils.catchLastDayOfCurrentMonth())));
	}
	
	@Test
	public void test_differenceOfDays() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
        
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DAY_OF_MONTH, -1);
		
		String today = format.format(c1.getTime());
        String tomorrow = format.format(c2.getTime());
        
        try {
			Assert.assertEquals(DateUtils.differenceOfDays(today, tomorrow), 1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
        
        try {
			Assert.assertEquals(DateUtils.differenceOfDays(c1, c2), 1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
        
        try {
			Assert.assertEquals(DateUtils.differenceOfDays(c1.getTime(), c2.getTime()), 1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}