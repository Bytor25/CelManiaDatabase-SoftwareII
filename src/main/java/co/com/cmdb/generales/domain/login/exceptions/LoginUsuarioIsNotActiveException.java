package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioIsNotActiveException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioIsNotActiveException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioIsNotActiveException create() {
		var userMessage = "El usuario ingresado no está activo en el sistema. Por favor, contacte al administrador para más información.";
		return new LoginUsuarioIsNotActiveException(userMessage, userMessage, new Exception());
	}

}
