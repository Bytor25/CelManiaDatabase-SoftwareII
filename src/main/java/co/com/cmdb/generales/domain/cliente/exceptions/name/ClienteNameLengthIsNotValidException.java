package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;


public class ClienteNameLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNameLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	

	public static final ClienteNameLengthIsNotValidException create(int typeUserMessage) {
		if(typeUserMessage == 1) {
			var userMessage1 = "El nombre ingresado es demasiado corto. Por favor, ingresa un nombre válido.";
			return new ClienteNameLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = "El nombre ingresado es demasiado largo. Por favor, verifica e ingresa un nombre con menos caracteres.";
			return new ClienteNameLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage="Se ha producido un error a la hora de validar la longitud del nombre, si el problema persiste, contacte al administrador";
		return new ClienteNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
