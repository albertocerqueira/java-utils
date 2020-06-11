package com.java.utils;

import com.java.IConverter;
import com.java.exception.ConverterException;
import com.java.regex.RegexValidation;

public class DoubleUtils implements IConverter<Double> {
	
	private static DoubleUtils instance = new DoubleUtils();
	
	private DoubleUtils() {}
	public static DoubleUtils getInstance() {
		return instance;
	}
	
	/**
	 * Method responsible for converting the String value reported in Integer
	 * 
	 * <br /><br />
	 * 
	 * @param Value (String) value to be converted into Integer
	 * @return (Double) Double value transformed into
	 * @throws ConverterException If an error occurs in the conversion.
	 */
	public Double convert(String value) throws ConverterException {
		Double newDouble = null;
		if (value != null && !value.equals("") && !value.equalsIgnoreCase("null")) {
			try {
				newDouble = new Double(value);
			} catch(Exception e) {
				try {
					newDouble = new Double(value.replace(".", "").replace(",", "."));
				} catch(Exception f) {
					throw new ConverterException(this.getClass(), f);
				}
			}
		}
		return newDouble;
	}
	
	/**
	 * Checks if the String contains only numbers
	 * 
	 * <br /><br />
	 * 
     * Remember: 
	 * <ul>
	 * 	 <li><code>The string must contain only numbers</code></li>
	 * </ul>
	 * 
	 * @param value (String) string to check
	 * @return (boolean) true if the string has only number, and false otherwise
	 * @see com.java.regex.RegexValidation.OnlyNumbers()
	 */
	public static boolean isOnlyNumber(String value) {
		boolean ret = false;
		if (!StringUtils.isBlank(value)) {
			ret = value.matches(RegexValidation.OnlyNumbersFloats.expression());
		}
		return ret;
	}
	
	/**
	 * Check if the string is empty
	 * 
	 * <br /><br />
	 * 
	 * Examples: 
	 * <ul>
	 * 	 <li><code>" " == false</code></li>
	 * 	 <li><code>"" == true</code></li>
	 *   <li><code>"0" == true</code></li>
	 *   <li><code>"0.1" == false</code></li>
	 *   <li><code>"0.01" == false</code></li>
	 *   <li><code>"0.001" == false</code></li>
	 *   <li><code>"1" == false</code></li>
	 * </ul>
	 * 
	 * @param value (String) string to check
	 * @return (boolean) true to empty string and false otherwise
	 * @see com.java.utils.StringUtils.isBlank(String)
	 */
	public static boolean isBlank(String value) {
		boolean isBlank = StringUtils.isBlank(value);
		if (!isBlank) {
			if (isOnlyNumber(value)) {
				isBlank = isZero(value);
			}
		}
		return isBlank;
	}
	
	public static boolean isZero(String value) {
		Double d = DoubleUtils.getInstance().convert(value);
		return Double.compare(d, Double.valueOf(0.0)) <= 0;
	}
	
	public static boolean isZero(double value) {
		return Double.compare(value, Double.valueOf(0.0)) <= 0;
	}
	
	public static double round(double round, int decimal, int ceilOrFloor) {
		round *= (Math.pow(10, decimal));
		if (ceilOrFloor == 0) {
			round = Math.ceil(round);
		} else {
			round = Math.floor(round);
		}
		round /= (Math.pow(10, decimal));
		return round;
	}
}