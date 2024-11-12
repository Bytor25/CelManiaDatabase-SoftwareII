package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginPasswordIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordIsEmptyException create() {
		var userMessage = "La contraseña está vacía. Por favor, ingrese una contraseña válida.";
		return new LoginPasswordIsEmptyException(userMessage, userMessage, new Exception());
	}

}
