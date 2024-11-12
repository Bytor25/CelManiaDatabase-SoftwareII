package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginUsuarioIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioIsNullException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioIsNullException create() {
		var userMessage = "El campo de usuario está vacío. Por favor, ingrese un usuario válido.";
		return new LoginUsuarioIsNullException(userMessage, userMessage, new Exception());
	}

}
