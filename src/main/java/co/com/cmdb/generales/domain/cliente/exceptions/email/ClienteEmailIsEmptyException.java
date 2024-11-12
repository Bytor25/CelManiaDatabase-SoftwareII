package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailIsEmptyException create() {
		var userMessage = "El campo de correo electrónico está vacío. Por favor, ingrese una dirección de correo electrónico.";
		return new ClienteEmailIsEmptyException(userMessage, userMessage, new Exception());
	}

}
