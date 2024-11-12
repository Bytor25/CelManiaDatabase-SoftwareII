package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTipoDocumentoDoesNotExistExecption extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoDoesNotExistExecption(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoDoesNotExistExecption create() {
		var userMessage = "El tipo de documento especificado para el cliente no existe. Verifique que el tipo de documento proporcionado sea correcto e intente nuevamente.";
		return new ClienteTipoDocumentoDoesNotExistExecption(userMessage, userMessage, new Exception());
	}

}
