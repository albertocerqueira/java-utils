package com.java.utils.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.generator.Cnpj;
import com.java.generator.Cpf;
import com.java.generator.EAN;
import com.java.generator.Placa;
import com.java.generator.Renavam;
import com.java.utils.IdentificationValidation;
import com.java.utils.ValidationUtils;

/**
 * Validation and Generator
 * 
 * @author albertocerqueira
 */
public class TestValidationUtils {
	
	@Test
	public void test_validaCPF() {
		assertEquals(IdentificationValidation.cpfInstance.validaCPF(Cpf.getInstance().get(true)), true);
		assertEquals(IdentificationValidation.cpfInstance.validaCPF(Cpf.getInstance().get(false)), true);
		assertEquals(IdentificationValidation.cpfInstance.validaCPF("000.000.000-00"), false);
		
		assertEquals(ValidationUtils.cpfValid(Cpf.getInstance().get(true)), true);
		assertEquals(ValidationUtils.cpfValid(Cpf.getInstance().get(false)), true);
		assertEquals(ValidationUtils.cpfValid("000.000.000-00"), false);
	}
	
	@Test
	public void test_validaCNPJ() {
		assertEquals(IdentificationValidation.cnpjInstance.validaCNPJ(Cnpj.getInstance().get(true)), true);
		assertEquals(IdentificationValidation.cnpjInstance.validaCNPJ(Cnpj.getInstance().get(false)), true);
		assertEquals(IdentificationValidation.cnpjInstance.validaCNPJ("00.000.000/0000-00"), false);
		
		assertEquals(ValidationUtils.cnpjValid(Cnpj.getInstance().get(true)), true);
		assertEquals(ValidationUtils.cnpjValid(Cnpj.getInstance().get(false)), true);
		assertEquals(ValidationUtils.cnpjValid("00.000.000/0000-00"), false);
	}
	
	@Test
	public void test_renavamValid() {
		assertEquals(ValidationUtils.renavamValid(Renavam.get()), true);
		assertEquals(ValidationUtils.renavamValid("0123456789"), false);
	}
	
	@Test
	public void test_emailValid() {
		assertEquals(ValidationUtils.emailValid("alberto.cerqueira1990@gmail.com"), true);
		assertEquals(ValidationUtils.emailValid("alberto.cerqueira1990gmail.com"), false);
		assertEquals(ValidationUtils.emailValid("alberto.cerqueira1990@"), false);
		assertEquals(ValidationUtils.emailValid("alberto.cerqueira1990@gmail"), false);
	}
	
	@Test
	public void test_placaValid() {
		assertEquals(ValidationUtils.placaValid(Placa.get()), true);
		assertEquals(ValidationUtils.placaValid(Placa.get()), true);
		assertEquals(ValidationUtils.placaValid("ABCD-123"), false);
	}
	
	@Test
	public void test_eanValid() {
		assertEquals(ValidationUtils.eanValid(EAN.get()), true);
		assertEquals(ValidationUtils.eanValid(EAN.get()), true);
		assertEquals(ValidationUtils.eanValid("12345"), false);
	}
}