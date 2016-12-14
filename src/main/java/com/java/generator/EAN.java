package com.java.generator;

import java.util.Random;

import com.java.utils.ValidationUtils;

public class EAN {

	public static String get() {
		Random random = new Random();
		boolean eanValid = false;
		String ean = null;
		
		while (!eanValid) {
			String eanRandom = random.nextInt(999999) + "1" + random.nextInt(999999);
			eanValid = ValidationUtils.eanValid(eanRandom);
			
			if (eanValid) {
				ean = eanRandom;
			}
		}
		
		return ean;
	}
}