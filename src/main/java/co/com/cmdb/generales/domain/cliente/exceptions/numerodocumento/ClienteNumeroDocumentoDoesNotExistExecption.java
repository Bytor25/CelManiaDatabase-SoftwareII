package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoDoesNotExistExecption extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoDoesNotExistExecption(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoDoesNotExistExecption create() {
		var userMessage = "ClienteNumeroDocumentoDoesNotExistExecption";
		return new ClienteNumeroDocumentoDoesNotExistExecption(userMessage, userMessage, new Exception());
	}

}
