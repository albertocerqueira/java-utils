package com.java.utils;

/**
 * Number Utils
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-27
 */
public class NumberUtils {

	/**
	 * Method responsible for rounded numerical values (double)
	 * 
	 * @param value (double) to rounded
     * @param places (int) number of decimal places
     * @param ceilOrFloor (int) Rounding up or down?
     * 
     * Remember: 
	 * <ul>
	 * 	 <li><code>ceilOrFloor == 0 then rounds up</code></li>
	 *   <li><code>ceilOrFloor == 1 then rounds down</code></li>
	 * </ul>
     * 
     * @return (double)
	 **/
	public static double rounded(double value, int places, int ceilOrFloor) {
		double arredondado = value;
		arredondado *= (Math.pow(10, places));
		if (ceilOrFloor == 0) {
			arredondado = Math.ceil(arredondado);
		} else {
			arredondado = Math.floor(arredondado);
		}
		arredondado /= (Math.pow(10, places));
		return arredondado;
	}
}