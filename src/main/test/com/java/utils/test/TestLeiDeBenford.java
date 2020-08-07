package com.java.utils.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestLeiDeBenford {
	
	public static void main(String[] args) {
		Random r = new Random();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0;i<1000;i++) {
			String a = new String(r.nextInt() + "");
			String aa = a.replace("-", "").substring(0, 1);
			
			Integer contador = map.get(aa);
			if (contador == null) {
				contador = 0;
			}
			contador++;
			map.put(aa, contador);
		}
		
		for (String aa : map.keySet()) {
			Integer contador = map.get(aa);
			System.out.println(aa + ": " + contador);
		}
	}
}