package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoIsEmptyException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final ClienteNumeroDocumentoIsEmptyException create() {
		var userMessage = "El número de documento del cliente no puede estar vacío. Por favor, ingrese un valor válido.";
		return new ClienteNumeroDocumentoIsEmptyException(userMessage, userMessage, new Exception());
	}

}
