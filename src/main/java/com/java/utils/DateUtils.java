package com.java.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.java.IConverter;
import com.java.exception.ConverterException;

/**
 * Date Utils
 * 
 * Class date utilitaria. And strongly recommended that this class be used when 
 * a Calendar object must be created for this class forces the locale pt_BR to 
 * this standard being used by the application.
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 */
public class DateUtils implements IConverter<Calendar> {
	
	private static DateUtils instance = new DateUtils();
	public static final String BRAZILIAN_PATTERN = "dd/MM/yyyy";
	public static final SimpleDateFormat completeTimer = new SimpleDateFormat("ss.SSSSSSZ");
	
	private DateUtils() {}
	public static DateUtils getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * Convert the string informed on a date (the string must have the format dd/mm/yyyy)
	 * 
	 * @param date (String) represents the date
	 * @return (Calendar) date that was represented in the string
	 * @throws 
	 * 		(ConverterException) if the format is not compatible with the format of the String
	 * 
	 * @author albertocerqueira
	 * 
	 */
	public Calendar convert(String date) throws ConverterException {
		Calendar data = null;
		if (date != null && !date.equals("")) {
			try {
				data = stringToCalendar(date, BRAZILIAN_PATTERN);
			} catch (ParseException e) {
				throw new ConverterException(this.getClass(), e);
			}
		}
		return data;
	}
	
	/**
	 * 
	 * Returns a Calendar object.
	 * @return (Calendar) calendar with the locale pt_BR
	 * 
	 * @author albertocerqueira
	 * 
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance(LocaleUtils.DEFAULT_LOCALE);
	}
	
	/**
	 * Data atual (hoje)
	 * @param pattern (String) padrão desejado
	 * @return (String) data no formato string com padrão do parametro
	 */
	public static String today(String pattern) {
		return calendarToString(Calendar.getInstance(), pattern);
	}
	
	/**
	 * Data de amanha
	 * @param pattern (String) padrão desejado
	 * @return (String) data no formato string com padrão do parametro
	 */
	public static String tomorrow(String pattern) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		return calendarToString(c, pattern);
	}
	
	/**
	 * Transforma o objeto Date em string seguindo o formato definido no parametro pattern
	 * @param calendar (Calendar) data a ser transformada
	 * @param pattern (String) formato de saída da data
	 * @return (String) data no formato string com padrão do parametro
	 */
	public static String calendarToString(Calendar calendar, String pattern) {
		if (calendar == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
		return format.format(calendar.getTime());
	}
	
    /**
     * Transforma uma data (Date) em String
     * Exemplo de pattern: ddMMyyyy
     * @param date (Date) data para conversão
     * @param pattern (String) padrão desejado
     * @return (String) data no formato string com padrão do parametro
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
        	return "";        	
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
        return format.format(date);
    }
    
	/**
	 * Converte a string informada em data, a string deve ter o formado informado em pattern
	 * @param date (String) representa uma data
	 * @param pattern (String) padrão em que a data esta formatada
	 * @return (Calendar) data que estava representada na string
	 * @throws ParseException Caso o formato nao seja compativel com a formatacao da String
	 */
	public static Calendar stringToCalendar(String date, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
		Date d = format.parse(date);
		Calendar c = getCalendar();
		c.setTime(d);
		return c;
	}
	
	/**
     * Cria um objeto Date a partir de uma String e um padrão
     * Exemplo de pattern: ddMMyyyy
     * @param date (String) data a ser criada.
     * @param pattern (String) padrão em que a data esta formatada
     * @return (Date) data que estava representada na string
     * @throws ParseException Caso ocorra algum erro.
     */
    public static Date stringToDate(String date, String pattern) throws ParseException {
        if (date.length() == 7) {
            date = "0" + date;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
        return format.parse(date);
    }
	
	/**
	 * Retorna um Integer no formato yyyyMMdd do calendar informado como parametro
	 * @param date (Calendar) data que será transformada em Integer
	 * @return (Integer) representando a data, ou nulo caso o parametro seja nulo.
	 */
	public static Integer calendarToInteger(Calendar date) {
		if (date != null) {
			return Integer.valueOf(date.get(Calendar.YEAR) + "" + StringUtils.leftPad("" + (date.get(Calendar.MONTH) + 1), "0", 2) + "" + StringUtils.leftPad("" + date.get(Calendar.DAY_OF_MONTH), "0", 2));
		}
		return null;
	}
	
	/**
	 * Retorna um Integer no formato HHmmss do calendar informado como parametro
	 * @param date (Calendar) data que terá sua hora transformada em Integer
	 * @return (Integer) representando a hora, ou nulo caso o parametro seja nulo.
	 */
	public static Integer calendarToIntegerHora(Calendar data) {
		if (data != null) {
			SimpleDateFormat format = new SimpleDateFormat("HHmmss", LocaleUtils.DEFAULT_LOCALE);
			String hora =  format.format(data.getTime());
			return Integer.valueOf(hora);
		}
		return Integer.valueOf(0);
	}
	
	/**
	 * Retorna um Integer no formato yyyyMMdd da string informada como parametro
	 * @param date (Calendar) data que será transformada em Integer
	 * @param pattern (String) padrão em que a data esta formatada
	 * @return (Integer) representando a data, ou nulo caso o parametro seja nulo.
	 */
	public static Integer stringToInteger(String date, String pattern) throws ParseException {
		Calendar c = stringToCalendar(date, pattern);
		return calendarToInteger(c);
	}
	
	/**
	 * Retorna um Integer no formato HHmmss da string informada como parametro
	 * @param date (Calendar) data que será transformada em Integer
	 * @param pattern (String) padrão em que a data esta formatada
	 * @return (Integer) representando a hora, ou nulo caso o parametro seja nulo.
	 */
	public static Integer stringToIntegerHora(String date, String pattern) throws ParseException {
		Calendar c = stringToCalendar(date, pattern);
		return calendarToIntegerHora(c);
	}
	
	/**
	 * 
	 * Converts the standard formatting of dates.
	 * 
	 * @param date (Calendar) date to be converted
	 * @param oldPattern (String) pattern where the date is formatted
	 * @param newPattern (String) new pattern to be converted
	 * @return (Stirng) data converted to the new standard
	 * 
	 * @author albertocerqueira
	 * 
	 */
	public static String convertPattern(String date, String oldPattern, String newPattern) throws ParseException {
		Calendar c = stringToCalendar(date, oldPattern);
		return calendarToString(c, newPattern);
	}

	// Semanal
	public static String pegarPrimeiroDiaDaSemanaAtual() {
		return pegarPrimeiroDiaDaSemanaAtual(BRAZILIAN_PATTERN);
	}

	public static String pegarPrimeiroDiaDaSemanaAtual(String padrao) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

		return calendarToString(cal, padrao);
	}

	public static String pegarUltimoDiaDaSemanaAtual() {
		return pegarUltimoDiaDaSemanaAtual(BRAZILIAN_PATTERN);
	}

	public static String pegarUltimoDiaDaSemanaAtual(String padrao) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

		cal.add(Calendar.WEEK_OF_YEAR, 1);
		cal.add(Calendar.MILLISECOND, -1);

		return calendarToString(cal, padrao);
	}

	// Mensal
	public static String pegarPrimeiroDiaDoMesAtual() {
		Calendar cal = GregorianCalendar.getInstance();
		return pegarPrimeiroDiaDoMes(cal.get(Calendar.MONTH), BRAZILIAN_PATTERN);
	}

	public static String pegarPrimeiroDiaDoMes(Integer mes) {
		return pegarPrimeiroDiaDoMes(mes, BRAZILIAN_PATTERN);
	}

	public static String pegarPrimeiroDiaDoMesAtual(String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		return pegarPrimeiroDiaDoMes(cal.get(Calendar.MONTH), padrao);
	}

	public static String pegarPrimeiroDiaDoMes(Integer mes, String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return calendarToString(cal, padrao);
	}

	public static String pegarUltimoDiaDoMesAtual() {
		Calendar cal = GregorianCalendar.getInstance();
		return pegarUltimoDiaDoMes(cal.get(Calendar.MONTH), BRAZILIAN_PATTERN);
	}

	public static String pegarUltimoDiaDoMes(Integer mes) {
		return pegarUltimoDiaDoMes(mes, BRAZILIAN_PATTERN);
	}

	public static String pegarUltimoDiaDoMesAtual(String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		return pegarUltimoDiaDoMes(cal.get(Calendar.MONTH), padrao);
	}

	public static String pegarUltimoDiaDoMes(Integer mes, String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		cal.set(cal.get(Calendar.YEAR), mes, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		return calendarToString(cal, padrao);
	}

	// Anual
	public static String pegarPrimeiroDiaDoAnoAtual() {
		return pegarPrimeiroDiaDoAnoAtual(BRAZILIAN_PATTERN);
	}

	public static String pegarPrimeiroDiaDoAnoAtual(String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return calendarToString(cal, padrao);
	}

	public static String pegarUltimoDiaDoAnoAtual() {
		return pegarUltimoDiaDoAnoAtual(BRAZILIAN_PATTERN);
	}

	public static String pegarUltimoDiaDoAnoAtual(String padrao) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		cal.set(cal.get(Calendar.YEAR), 11, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		return calendarToString(cal, padrao);
	}

	public static String identificacao(String data) throws NumberFormatException, ParseException {
		String today = today("dd/MM/yyyy");

		if (today.equals(data)) {
			return "today";
		} else {
			Integer firstDayOfTheWeek = Integer.parseInt(pegarPrimeiroDiaDaSemanaAtual("yyyyMMdd"));
			Integer lastDayOfTheWeek = Integer.parseInt(pegarUltimoDiaDaSemanaAtual("yyyyMMdd"));
			Integer iData = Integer.parseInt(convertPattern(data, "dd/MM/yyyy", "yyyyMMdd"));
			String yesterday = tomorrow("dd/MM/yyyy");
			String month = today("MM/yyyy");
			String year = today("yyyy");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			String lastmonth = calendarToString(c, "MM/yyyy");

			if (firstDayOfTheWeek <= iData && iData <= lastDayOfTheWeek) {
				if (yesterday.equals(data)) {
					if (month.equals(data.substring(3))) {
						return "yesterday-thisweek-thismonth-thisyear";
					} else {
						if (year.equals(data.substring(6))) {
							return "yesterday-thisweek-thisyear";
						} else {
							return "yesterday-thisweek";
						}
					}
				} else {
					if (month.equals(data.substring(3))) {
						return "thisweek-thismonth-thisyear";
					} else {
						if (year.equals(data.substring(6))) {
							return "thisweek-thisyear";
						} else {
							return "thisweek";
						}
					}
				}
			} else {
				if (month.equals(data.substring(3))) {
					if (yesterday.equals(data)) {
						return "yesterday-thismonth-thisyear";
					} else {
						return "thismonth-thisyear";
					}
				} else {
					if (lastmonth.equals(data.substring(3))) {
						if (year.equals(data.substring(6))) {
							if (yesterday.equals(data)) {
								return "yesterday-lastmonth-thisyear";
							} else {
								return "lastmonth-thisyear";
							}
						} else {
							if (yesterday.equals(data)) {
								return "yesterday-lastmonth";
							} else {
								return "lastmonth";
							}
						}
					} else {
						if (year.equals(data.substring(6))) {
							return "thisyear";
						}
					}
				}
			}
		}

		return "unidentifieddate";
	}

	public static String identificacaoData(String identificacao) {
		if ("today".equals(identificacao)) {
			return "Today";
		} else if ("yesterday".equals(identificacao)) {
			return "Yesterday";
		} else if ("thisweek".equals(identificacao)) {
			return "This Week";
		} else if ("thismonth".equals(identificacao)) {
			return "This Month";
		} else if ("lastmonth".equals(identificacao)) {
			return "Last Month";
		} else if ("thisyear".equals(identificacao)) {
			return "This Year";
		} else if ("unidentifieddate".equals(identificacao)) {
			return "Unidentified Date";
		} else {
			return "Unidentified Date";
		}
	}

	public static String dataRandomica(String padrao, int initialYear, int finalYear) {
		if (initialYear > finalYear) {
			int ano = finalYear;
			finalYear = initialYear;
			initialYear = ano;
		}

		Calendar cInitialYear = Calendar.getInstance();
		cInitialYear.set(Calendar.YEAR, 2015);
		long offset = cInitialYear.getTimeInMillis();

		Calendar cFinalYear = Calendar.getInstance();
		cFinalYear.set(Calendar.YEAR, 2016);
		long end = cFinalYear.getTimeInMillis();

		long diff = end - offset + 1;
		Timestamp timestamp = new Timestamp(offset + (long) (Math.random() * diff));
		Date date = new Date(timestamp.getTime());

		return dateToString(date, padrao);
	}
	
	public static int differenceOfDays(String initialDay, String finalDay) throws ParseException {
		Date d1 = stringToDate(initialDay, "dd/MM/yyyy");
		Date d2 = stringToDate(finalDay, "dd/MM/yyyy");
		return differenceOfDays(d1, d2);
	}
	
	public static int differenceOfDays(Date initialDay, Date finalDay) {
		Calendar cInicial = Calendar.getInstance();
		cInicial.setTime(initialDay);
		Calendar cFinal = Calendar.getInstance();
		cFinal.setTime(finalDay);
		return differenceOfDays(cInicial, cFinal);
	}
	
	public static int differenceOfDays(Calendar initialDay, Calendar finalDay) {
		Calendar dayOne = (Calendar) initialDay.clone();
		Calendar dayTwo = (Calendar) finalDay.clone();

		if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
			return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
		} else {
			if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
				// swap them
				Calendar temp = dayOne;
				dayOne = dayTwo;
				dayTwo = temp;
			}
			
			int extraDays = 0;
			int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);
			while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
				dayOne.add(Calendar.YEAR, -1);
				// getActualMaximum() important for leap years
				extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
			}

			return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays;
		}
	}
}