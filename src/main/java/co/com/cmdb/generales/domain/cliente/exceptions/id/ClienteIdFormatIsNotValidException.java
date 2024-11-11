package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public final class ClienteIdFormatIsNotValidException extends RuleCmdbException {
	
	private static final long serialVersionUID = 1L;

	public ClienteIdFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteIdFormatIsNotValidException create() {
		
		var userMessage = "El cliente tiene un identificador con un formato no válido al correspodiente al valor por defecto";
		return new ClienteIdFormatIsNotValidException(userMessage, userMessage, new Exception());
		
	}
	
	

}
