package com.java.exception;

import com.java.utils.LogUtils;

public class CriticalUserException extends UserException {

	private static final long serialVersionUID = -8280945186537174047L;

	public CriticalUserException(Class<?> origin, String messageSystem) {
		super("N\u00e3o esperavámos por isso mas houve um erro no sistema, por\u00e9m j\u00e1 enviamos um email notificando o pessoal t\u00e9cnico.");
		LogUtils.critical(origin, messageSystem);
	}

	public CriticalUserException(Class<?> origin, String messageSystem, Throwable error) {
		super("N\u00e3o esperavámos por isso mas houve um erro no sistema, por\u00e9m j\u00e1 enviamos um email notificando o pessoal t\u00e9cnico.", error);
		LogUtils.critical(origin, error, messageSystem);
	}
	
	public CriticalUserException(Class<?> origin, String messageSystem, String messageUser, Throwable error) {
		super(messageUser, error);
		LogUtils.critical(origin, error, messageSystem);
	}
}