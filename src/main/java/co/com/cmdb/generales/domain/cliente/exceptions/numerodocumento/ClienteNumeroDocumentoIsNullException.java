package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoIsNullException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final ClienteNumeroDocumentoIsNullException create() {
		var userMessage = "El número de documento del cliente no puede ser nulo. Por favor, asegúrese de que el cliente tenga un número de documento válido antes de continuar";
		return new ClienteNumeroDocumentoIsNullException(userMessage, userMessage, new Exception());
	}

}
