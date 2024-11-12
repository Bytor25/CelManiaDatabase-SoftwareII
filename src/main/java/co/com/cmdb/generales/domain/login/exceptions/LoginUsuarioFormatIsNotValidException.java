package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioFormatIsNotValidException create() {
		var userMessage = "El usuario ingresado no cumple con el formato predefinido. Por favor, ingrese un usuario válido.";
		return new LoginUsuarioFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
