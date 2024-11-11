package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteLastNameIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameIsNullException create() {
		var userMessage = "El campo de apellido es obligatorio. Por favor, ingresa un apellido válido.";
		return new ClienteLastNameIsNullException(userMessage, userMessage, new Exception());
	}

}
