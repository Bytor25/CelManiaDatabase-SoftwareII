package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoLengthIsNotValid extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoLengthIsNotValid(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final ClienteNumeroDocumentoLengthIsNotValid create() {
		var userMessage = "El número de documento del cliente no es válido: debe cumplir con la longitud requerida.";
		return new ClienteNumeroDocumentoLengthIsNotValid(userMessage, userMessage, new Exception());
	}

}
