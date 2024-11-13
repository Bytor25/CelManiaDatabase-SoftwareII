package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTipoDocumentoIdIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoIdIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoIdIsEmptyException create() {
		var userMessage = "El tipo de documento está vacío. Por favor, seleccione uno.";
		return new ClienteTipoDocumentoIdIsEmptyException(userMessage, userMessage, new Exception());
	}

}
