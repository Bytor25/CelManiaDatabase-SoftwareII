package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException create() {
		var userMessage = "Ya existe un cliente registrado con este número de teléfono. Verifique los datos ingresados.";
		return new ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException(userMessage, userMessage, new Exception());
	}

}
