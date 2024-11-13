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
		var userMessage = "El número de documento del cliente no existe. Por favor, verifique que ha ingresado un número de documento válido y vuelva a intentarlo.";
		return new ClienteNumeroDocumentoDoesNotExistExecption(userMessage, userMessage, new Exception());
	}

}
