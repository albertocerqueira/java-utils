package com.java.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Log Utils
 * 
 * @author <a href="https://github.com/albertocerqueira/" target="_blank">Alberto Cerqueira</a> 2016-10-26
 */
public class LogUtils {

	private static Map<String, Boolean> loggerInfo = new HashMap<String, Boolean>();
	private static Map<String, Boolean> loggerDebug = new HashMap<String, Boolean>();
	private static Map<String, Boolean> loggerError = new HashMap<String, Boolean>();
	private static Map<String, Boolean> loggerWarning = new HashMap<String, Boolean>();
	private static Map<String, Boolean> loggerTracer = new HashMap<String, Boolean>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	public static void addLoggerInfo(Class<?> clazz, Boolean logInfo) {
		loggerInfo.put(clazz.getSimpleName(), logInfo);
	}

	public static void addLoggerDebug(Class<?> clazz, Boolean logInfo) {
		loggerDebug.put(clazz.getSimpleName(), logInfo);
	}

	public static void addLoggerError(Class<?> clazz, Boolean logInfo) {
		loggerError.put(clazz.getSimpleName(), logInfo);
	}

	public static void addLoggerWarning(Class<?> clazz, Boolean logInfo) {
		loggerWarning.put(clazz.getSimpleName(), logInfo);
	}

	public static void addLoggerTracer(Class<?> clazz, Boolean logInfo) {
		loggerTracer.put(clazz.getSimpleName(), logInfo);
	}

	@SuppressWarnings("rawtypes")
	public static void critical(Class clazz, String mensagem) {
		error(clazz, mensagem);
	}

	@SuppressWarnings("rawtypes")
	public static void critical(Class clazz, Throwable error, String mensagem) {
		String completeMessage = completeMessage(error, mensagem);
		error(clazz, completeMessage);
	}

	@SuppressWarnings("rawtypes")
	public static void debug(Class clazz, Throwable error, String mensagem) {
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - DEBUG:[").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(mensagem).append("]");
		System.out.println(sb.toString());
		error(clazz, error);
	}

	@SuppressWarnings("rawtypes")
	public static void debug(Class clazz, String debug) {
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - DEBUG:[").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(debug).append("]");
		System.out.println(sb.toString());
	}

	@SuppressWarnings("rawtypes")
	public static void error(Class clazz, String error) {
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - ERROR:[").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(error).append("]");
		System.out.println(sb.toString());
	}

	@SuppressWarnings("rawtypes")
	public static void error(Class clazz, Throwable error, String mensagem) {
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - ERROR:[").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(mensagem).append("]");
		System.out.println(sb.toString());
		error(clazz, error);
	}

	@SuppressWarnings("rawtypes")
	public static void error(Class clazz, Throwable error) {
		boolean applyError = !clazz.getSimpleName().matches("(Class1|Class2|Class3)");
		if (applyError) {
			error.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void warn(Class clazz, String warn) {
		System.out.println(sdf.format(Calendar.getInstance().getTime()) + " - WARN [ " + clazz.getSimpleName() + "] Mensagem:[" + warn + "]");
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - WARN [").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(warn).append("]");
		System.out.println(sb.toString());
	}

	@SuppressWarnings("rawtypes")
	public static void trace(Class clazz, String trace) {
		System.out.println(sdf.format(Calendar.getInstance().getTime()) + " - TRACER [ " + clazz.getSimpleName() + "] Mensagem:[" + trace + "]");
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - TRACER [").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(trace).append("]");
		System.out.println(sb.toString());
	}

	@SuppressWarnings("rawtypes")
	public static void info(Class clazz, String info) {
		System.out.println(sdf.format(Calendar.getInstance().getTime()) + " - INFO [ " + clazz.getSimpleName() + "] Mensagem:[" + info + "]");
		StringBuffer sb = new StringBuffer(sdf.format(Calendar.getInstance().getTime())).append(" - ")
				.append("java-utils").append(" - INFO [").append(clazz.getSimpleName()).append("] Mensagem:[")
				.append(info).append("]");
		System.out.println(sb.toString());
	}

	@SuppressWarnings("rawtypes")
	public static boolean isDebug(Class clazz) {
		Boolean isEnabled = loggerDebug.get(clazz.getSimpleName());
		return isEnabled(isEnabled);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isInfo(Class clazz) {
		Boolean isEnabled = loggerInfo.get(clazz.getSimpleName());
		return isEnabled(isEnabled);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isError(Class clazz) {
		Boolean isEnabled = loggerError.get(clazz.getSimpleName());
		return isEnabled(isEnabled);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isWarning(Class clazz) {
		Boolean isEnabled = loggerWarning.get(clazz.getSimpleName());
		return isEnabled(isEnabled);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isTrace(Class clazz) {
		Boolean isEnabled = loggerTracer.get(clazz.getSimpleName());
		return isEnabled(isEnabled);
	}

	private static Boolean isEnabled(Boolean isEnabled) {
		return (isEnabled == null) || isEnabled.booleanValue() ? Boolean.TRUE : Boolean.FALSE;
	}

	private static String completeMessage(Throwable error, String mensagem) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		error.printStackTrace(printStream);
		String stackTrace = baos.toString();
		StringBuilder b = new StringBuilder();
		b.append(mensagem);
		b.append("\n");
		b.append(stackTrace);
		return b.toString();
	}
}