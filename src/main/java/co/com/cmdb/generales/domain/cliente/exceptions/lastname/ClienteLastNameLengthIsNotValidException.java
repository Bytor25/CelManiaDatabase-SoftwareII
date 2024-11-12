package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;


public class ClienteLastNameLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameLengthIsNotValidException create(int typeUserMessage) {
		if(typeUserMessage == 1) {
			var userMessage1 = "El apellido ingresado es demasiado corto. Por favor, ingresa un apellido válido.";
			return new ClienteLastNameLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = "El apellido ingresado es demasiado largo. Por favor, verifica e ingresa un apellido con menos caracteres.";
			return new ClienteLastNameLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage="Se ha producido un error a la hora de validar la longitud del apellido, si el problema persiste, contacte al administrador";
		return new ClienteLastNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
