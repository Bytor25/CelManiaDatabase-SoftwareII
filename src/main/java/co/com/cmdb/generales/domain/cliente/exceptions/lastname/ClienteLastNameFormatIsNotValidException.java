package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteLastNameFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameFormatIsNotValidException create() {
		var userMessage = "El apellido ingresado contiene caracteres no permitidos. Por favor, ingresa solo letras.";
		return new ClienteLastNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}
}
