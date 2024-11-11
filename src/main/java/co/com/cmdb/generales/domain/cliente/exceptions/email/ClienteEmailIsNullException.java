package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailIsNullException  extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailIsNullException create() {
		var userMessage = "El campo de correo electrónico es obligatorio. Por favor, ingresa una dirección de correo electrónico.";
		return new ClienteEmailIsNullException(userMessage, userMessage, new Exception());
	}

}
