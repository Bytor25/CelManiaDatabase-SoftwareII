package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioIsEmptyException create() {
		var userMessage = "El campo de usuario está vacío. Por favor, ingrese un usuario válido.";
		return new LoginUsuarioIsEmptyException(userMessage, userMessage, new Exception());
	}

}
