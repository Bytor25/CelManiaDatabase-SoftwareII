package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTipoDocumentoDoesNotExistException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoDoesNotExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoDoesNotExistException create() {
		var userMessage = "El tipo de documento del cliente no existe. Verifique que el tipo de documento ingresado sea válido y esté registrado en el sistema.";
		return new ClienteTipoDocumentoDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
