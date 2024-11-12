package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioDoesNotExistException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioDoesNotExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioDoesNotExistException create() {
		var userMessage = "El usuario ingresado no está registrado. Por favor, ingrese un usuario válido. Si el problema persiste, contacte al administrador.";
		return new LoginUsuarioDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
