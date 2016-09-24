package com.java.exception;

public class UserLinkException extends UserException {
	
	private static final long serialVersionUID = 1L;
	
	private String campo;
	
	public UserLinkException(String campo, String message) {
		super(message);
		this.campo = campo;
	}

	public UserLinkException(String campo, String message, Throwable cause) {
		super(message, cause);
		this.campo = campo;
	}

	public UserLinkException(String campo, Throwable cause) {
		super(cause);
		this.campo = campo;
	}
	
	public String getCampo() {
		return campo;
	}
}