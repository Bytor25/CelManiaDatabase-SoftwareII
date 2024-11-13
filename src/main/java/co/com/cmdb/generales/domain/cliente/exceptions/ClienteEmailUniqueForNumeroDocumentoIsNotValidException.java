package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailUniqueForNumeroDocumentoIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailUniqueForNumeroDocumentoIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	public static final ClienteEmailUniqueForNumeroDocumentoIsNotValidException create() {
		var userMessage = "Ya existe un cliente registrado con este correo. Verifique los datos ingresados.";
		return new ClienteEmailUniqueForNumeroDocumentoIsNotValidException(userMessage, userMessage, new Exception());
	}

}
