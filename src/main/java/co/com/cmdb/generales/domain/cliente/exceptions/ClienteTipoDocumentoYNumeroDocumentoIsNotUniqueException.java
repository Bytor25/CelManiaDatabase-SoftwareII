package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException create() {
		var userMessage = "El número de documento ingresado ya se encuentra registrado con el mismo tipo de documento.";
		return new ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException(userMessage, userMessage, new Exception());
	}

}
