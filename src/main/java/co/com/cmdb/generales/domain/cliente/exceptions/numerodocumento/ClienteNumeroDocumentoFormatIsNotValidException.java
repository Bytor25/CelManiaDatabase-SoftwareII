package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoFormatIsNotValidException extends RuleCmdbException {

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoFormatIsNotValidException create() {
		var userMessage = "El formato del número de documento del cliente no es válido. Por favor, verifique e ingrese un número correcto.";
		return new ClienteNumeroDocumentoFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
