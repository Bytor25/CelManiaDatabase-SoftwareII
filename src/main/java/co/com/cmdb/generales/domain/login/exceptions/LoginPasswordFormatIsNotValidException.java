package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginPasswordFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordFormatIsNotValidException create() {
		var userMessage = "La contraseña no puede estar vacía. Por favor, ingrese una contraseña válida.";
		return new LoginPasswordFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
