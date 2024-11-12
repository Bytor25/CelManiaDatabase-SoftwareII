package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioPasswordIsNotCorrectException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioPasswordIsNotCorrectException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioPasswordIsNotCorrectException create() {
		var userMessage = "La contraseña ingresada es incorrecta. Por favor, verifique e intente nuevamente.";
		return new LoginUsuarioPasswordIsNotCorrectException(userMessage, userMessage, new Exception());
	}

}
