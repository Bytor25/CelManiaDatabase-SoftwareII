package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoDoesExistException extends RuleCmdbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoDoesExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoDoesExistException create() {
		var userMessage = "El número de documento ingresado ya está registrado para otro cliente. Por favor, verifique los datos e intente nuevamente.";
		return new ClienteNumeroDocumentoDoesExistException(userMessage, userMessage, new Exception());
	}

}
