package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTipoDocumentoDoesExistException extends RuleCmdbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoDoesExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoDoesExistException create() {
		var userMessage = "El tipo de documento especificado para el cliente ya existe. Por favor, verifique e intente nuevamente.";
		return new ClienteTipoDocumentoDoesExistException(userMessage, userMessage, new Exception());
	}

}
