package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTelefonoRangeIsNotValidException extends RuleCmdbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTelefonoRangeIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteTelefonoRangeIsNotValidException create() {
		var userMessage = "El número de teléfono del cliente está fuera del rango permitido. Por favor, verifique e ingrese un número válido.";
		return new ClienteTelefonoRangeIsNotValidException(userMessage, userMessage, new Exception());
	}

}
