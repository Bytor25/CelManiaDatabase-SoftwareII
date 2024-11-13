package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTelefonoIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTelefonoIsEmptyException create() {
		var userMessage = "El número de teléfono del cliente no puede estar vacío. Por favor, proporcione un número válido.";
		return new ClienteTelefonoIsEmptyException(userMessage, userMessage, new Exception());
	}

}
