package com.java.utils;

import com.java.regex.RegexValidation;

/**
 * Validation Utils
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 */
public class ValidationUtils {
	
	/**
	 * Validation codes Renavam
	 * @param renavam (String) Renavam code for validation
	 * @return (Boolean) true for valid code and false for invalid code
	 */
	public static boolean renavamValid(String renavam) {
		// Pegando como exemplo o renavam = 639884962

		// Completa com zeros a esquerda se for no padrao antigo de 9 digitos
		// renavam = 00639884962
		if (renavam.matches(RegexValidation.Renavam9digitos.expression())) {
			renavam = "00" + renavam;
		}

		// Valida se possui 11 digitos pos formatacao
		if (!renavam.matches(RegexValidation.Renavam11digitos.expression())) {
			return false;
		}

		// Remove o digito (11 posicao)
		// renavamSemDigito = 0063988496
		String renavamSemDigito = renavam.substring(0, 10);

		// Inverte os caracteres (reverso)
		// renavamReversoSemDigito = 69488936
		String renavamReversoSemDigito = new StringBuffer(renavamSemDigito).reverse().toString();

		int soma = 0;

		// Multiplica as strings reversas do renavam pelos numeros
		// multiplicadores
		// para apenas os primeiros 8 digitos de um total de 10
		// Exemplo: renavam reverso sem digito = 69488936
		// 6, 9, 4, 8, 8, 9, 3, 6
		// * * * * * * * *
		// 2, 3, 4, 5, 6, 7, 8, 9 (numeros multiplicadores - sempre os mesmos
		// [fixo])
		// 12 + 27 + 16 + 40 + 48 + 63 + 24 + 54
		// soma = 284
		for (int i = 0; i < 8; i++) {
			Integer algarismo = Integer.parseInt(renavamReversoSemDigito.substring(i, i + 1));
			Integer multiplicador = i + 2;
			soma += algarismo * multiplicador;
		}

		// Multiplica os dois ultimos digitos e soma
		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(8)) * 2;
		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(9)) * 3;

		// mod11 = 284 % 11 = 9 (resto da divisao por 11)
		int mod11 = soma % 11;

		// Faz-se a conta 11 (valor fixo) - mod11 = 11 - 9 = 2
		int ultimoDigitoCalculado = 11 - mod11;

		// ultimoDigito = Caso o valor calculado anteriormente seja 10 ou 11,
		// transformo ele em 0
		// caso contrario, eh o proprio numero
		ultimoDigitoCalculado = (ultimoDigitoCalculado >= 10 ? 0 : ultimoDigitoCalculado);

		// Pego o ultimo digito do renavam original (para confrontar com o
		// calculado)
		int digitoRealInformado = Integer.valueOf(renavam.substring(renavam.length() - 1, renavam.length()));

		// Comparo os digitos calculado e informado
		if (ultimoDigitoCalculado == digitoRealInformado) {
			return true;
		}
		return false;
	}

	/**
	 * Validation E-mail
	 * @param email (String) for validation E-mail
	 * @return (Boolean) true for valid E-mail address and false for invalid email
	 */
	public static boolean emailValid(String email) {
		if (StringUtils.isBlank(email)) {
			return false;
		}
		// Validates that is in the correct format
		if (!email.matches(RegexValidation.EMAIL.expression())) {
			return false;
		}
		if (email.indexOf(" ") != -1 || email.indexOf("..") != -1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Validation number of Placa
	 * @param plate (String) Placa number for validation
	 * @return (Boolean) true for valid Placa number and false for invalid
	 */
	public static boolean placaValid(String placa) {
		if (StringUtils.isBlank(placa)) {
			return false;
		}
		// Validates that is in the correct format
		if (!placa.matches(RegexValidation.PLACA.expression())) {
			return false;
		}
		return true;
	}
	
	/**
	 * Validation CPF
	 * @param cpf (String) CPF number for validation
	 * @return (Boolean) true for valid CPF number and false for invalid
	 * @see com.java.utils.IdentificationValidation.validaCPF (String)
	 */
	public static boolean cpfValid(String cpf) {
		return IdentificationValidation.cpfInstance.validaCPF(cpf);
	}
	
	/**
	 * Validation CNPJ
	 * @param cnpj (String) CNPJ number for validation
	 * @return (Boolean) true for valid CNPJ number and false for invalid
	 * @see com.java.utils.IdentificationValidation.validaCNPJ (String)
	 */
	public static boolean cnpjValid(String cnpj) {
		return IdentificationValidation.cnpjInstance.validaCNPJ(cnpj);
	}
	
	/**
	 * Zip Code Number Validation
	 * @param zipCode (String) Zip Code number for validation
	 * @return (Boolean) true for valid Zip Code number and false for invalid
	 */
	public static boolean zipCodeValid(String zipCode) {
		// TODO: add i18n
		
		if (StringUtils.isBlank(zipCode)) {
			return false;
		}
		// Validates that is in the correct format
		if (!zipCode.matches(RegexValidation.CEP.expression())) {
			return false;
		}
		return true;
	}
	
	public static boolean eanValid(String ean) {
		int digit;
		int calculated;
		String checkSum = "131313131313";
		int sum = 0;
		if (ean.length() == 8 || ean.length() == 13) {
			digit = Integer.parseInt("" + ean.charAt(ean.length() - 1));
			String _ean = ean.substring(0, ean.length() - 1);
			for (int i = 0; i <= _ean.length() - 1; i++) {
				sum += (Integer.parseInt("" + _ean.charAt(i))) * (Integer.parseInt("" + checkSum.charAt(i)));
			}
			calculated = 10 - (sum % 10);
			return (digit == calculated);
		} else {
			return false;
		}
	}
	
	// TODO: Inserir validador de Outros
}