package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class LoginPasswordLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordLengthIsNotValidException create(int typeUserMessage) {
		
		if(typeUserMessage == 1) {
			var userMessage1 = "La contraseña ingresada tiene menos de 4 dígitos. Por favor, ingrese una contraseña válida.";
			return new LoginPasswordLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}else if(typeUserMessage == 2) {
			var userMessage2 = "La contraseña ingresada tiene más de 4 dígitos. Por favor, ingrese una contraseña válida.";
			return new LoginPasswordLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = "Ocurrió un error al validar la longitud de la contraseña. Si el problema persiste, por favor contacte al administrador.";
		return new LoginPasswordLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
