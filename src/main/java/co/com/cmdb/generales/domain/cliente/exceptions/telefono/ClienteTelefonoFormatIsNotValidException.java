package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTelefonoFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTelefonoFormatIsNotValidException create() {
		var userMessage = "Formato de teléfono inválido. Ingrese un número de teléfono válido, usando solo dígitos.";
		return new ClienteTelefonoFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
