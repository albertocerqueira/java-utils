package com.java.utils.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.icu.util.Calendar;
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
	public void test_daysAndMonths() {
		Assert.assertEquals(DateUtils.pegarPrimeiroDiaDoMesAtual(Calendar.JANUARY, "dd/MM"), "01/01");
		Assert.assertEquals(DateUtils.pegarUltimoDiaDoMesAtual(Calendar.JANUARY, "dd/MM"), "31/01");
		
		SimpleDateFormat format = new SimpleDateFormat("MM/yyyy", LocaleUtils.DEFAULT_LOCALE);
		String mes = format.format(new Date());
		Assert.assertEquals(DateUtils.pegarPrimeiroDiaDoMesAtual("MM/yyyy"), mes);
		Assert.assertEquals(DateUtils.pegarUltimoDiaDoMesAtual("MM/yyyy"), mes);
		Assert.assertEquals(DateUtils.pegarPrimeiroDiaDoMesAtual(), ("01/" + mes));
		String expectedTitles[] = {("28/" + mes), ("29/" + mes), ("30/" + mes), ("31/" + mes)};
		List<String> expectedTitlesList = Arrays.asList(expectedTitles);
		Assert.assertTrue(expectedTitlesList.contains((DateUtils.pegarUltimoDiaDoMesAtual())));
	}
}