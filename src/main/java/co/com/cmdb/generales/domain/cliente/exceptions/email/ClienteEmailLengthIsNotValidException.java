package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailLengthIsNotValidException extends RuleCmdbException{

	
	private static final long serialVersionUID = 1L;

	public ClienteEmailLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailLengthIsNotValidException create(int typeUserMessage) {
		if(typeUserMessage == 1) {
			var userMessage1 = "El correo electrónico ingresado es demasiado corto. Por favor, ingresa una dirección de correo electrónico válida.";
			return new ClienteEmailLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = "El correo electrónico ingresado es demasiado largo. Por favor, verifica e ingresa una dirección de correo electrónico válida con menos caracteres.";
			return new ClienteEmailLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage="Se ha producido un error a la hora de validar la longitud del correo, si el problema persiste, contacte al administrador";
		return new ClienteEmailLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
