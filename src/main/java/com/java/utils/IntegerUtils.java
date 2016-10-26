package com.java.utils;

import java.util.Date;

import com.java.IConverter;
import com.java.exception.ConverterException;
import com.java.regex.RegexValidation;

/**
 * Integer Utils
 * 
 * Class with set of methods that perform common functions for handling Integers, validations or treatments, 
 * often re-used. Most utilities classes define these common methods under static scope.
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 */
public class IntegerUtils implements IConverter<Integer> {

	private static IntegerUtils instance = new IntegerUtils();
	
	private IntegerUtils() {}
	public static IntegerUtils getInstance() {
		return instance;
	}
	
	/**
	 * Method responsible for converting the String value reported in Integer
	 * 
	 * <br /><br />
	 * 
	 * @param Value (String) value to be converted into Integer
	 * @return (Integer) Integer value transformed into
	 * @throws ConverterException If an error occurs in the conversion.
	 */
	public Integer convert(String value) throws ConverterException {
		Integer newInt = null;
		if (value != null && !value.equals("")) {
			try {
				newInt = Integer.valueOf(value);
			} catch (NumberFormatException nfe) {
				throw new ConverterException(this.getClass(), nfe);
			}
		}
		return newInt;
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
			ret = value.matches(RegexValidation.OnlyNumbers.expression());
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
				isBlank = (Integer.valueOf(value).intValue() == 0);
			}
		}
		return isBlank;
	}
	
	/**
	 * Converte Number to int
	 * 
	 * <br /><br />
	 * 
	 * Remember: 
	 * <ul>
	 * 	 <li><code>Number = null then return 0</code></li>
	 * </ul>
	 * 
	 * @param value (Number) to convert
	 * @return (int) Number of value in int format
	 */
    public static int parseInt(Number value) {
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    /**
     * Convert String to int if the value contains only numbers
     * 
     * <br /><br />
     * 
     * Examples: 
	 * <ul>
	 *   <li><code>null == 0</code></li>
	 * 	 <li><code>" " == 0</code></li>
	 * 	 <li><code>"" == 0</code></li>
	 *   <li><code>"albertocerqueira" == 0</code></li>
	 * </ul>
	 * 
     * Remember: 
	 * <ul>
	 * 	 <li><code>String equals null then return 0</code></li>
	 *   <li><code>String equals " " then retrun 0</code></li>
	 * 	 <li><code>String equals "" then retrun 0</code></li>
	 *   <li><code>String equals "text" then retrun 0</code></li>
	 * </ul>
	 * 
     * @param value (String) to conversion
     * @return (Int) value of the String or int format 0 (zero) if isOnlyNumber () is equal to false
     */
    public static int parseInt(String value) {
        if (!StringUtils.isBlank(value) && isOnlyNumber(value)) {
            return Integer.parseInt(value.trim());
        }
        return 0;
    }

    /**
     * Transforma uma data (Date) em Integer no formato desejado
     * 
     * <br /><br />
     * 
     * Examples for pattern parameter: 
	 * <ul>
	 *   <li><code>"dd/MM/yyyy" == 0</code></li>
	 *   <li><code>"MM/yyyy" == 0</code></li>
	 *   <li><code>"MM/dd/yyyy" == 0</code></li>
	 *   <li><code>"dd/MM/yyyy hh:mm:ss" == 0</code></li>
	 * </ul>
	 * 
     * Remember: 
	 * <ul>
	 * 	 <li><code>If the pattern does not contain only numbers then return 0</code></li>
	 * </ul>
     * 
     * @param date (Date) to convert
     * @param pattern (String) desired pattern
     * @return (int) representing the date or 0 (zero) if the parameter is null
     * @see com.java.utils.DateUtils.dateToString(String)
     */
    public static int parseInt(Date date, String pattern) {
        int ret = 0;
        if (date != null) {
			String strData = DateUtils.dateToString(date, pattern);
			
			if (!isOnlyNumber(strData)) {
				return 0;
			}
			
            ret = parseInt(strData);
        }
        return ret;
    }
    
    /**
     * Transforming a date (Date) Integer in the yyyyMMdd format
     * 
     * <br /><br />
     * 
     * Remember: 
	 * <ul>
	 * 	 <li><code>If the date equal null then return 0</code></li>
	 * </ul>
     * 
     * @param date (Date) to convert
     * @return (int) representing the date or 0 (zero) if the parameter is null
     * @see com.java.utils.IntegerUtils.parseInt(Date, String)
     * @see com.java.utils.DateUtils.dateToString(String)
     */
    public static int parseInt(Date date) {
    	return parseInt(date, "yyyyMMdd");
    }
}