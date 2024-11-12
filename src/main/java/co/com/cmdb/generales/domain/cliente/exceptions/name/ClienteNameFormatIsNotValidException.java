package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNameFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNameFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNameFormatIsNotValidException create() {
		var userMessage = "El nombre ingresado contiene caracteres no permitidos. Por favor, ingresa solo letras.";
		return new ClienteNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
