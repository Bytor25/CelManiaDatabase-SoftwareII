package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteLastNameIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameIsEmptyException create() {
		var userMessage = "El campo de apellido es obligatorio. Por favor, ingresa un apellido válido.";
		return new ClienteLastNameIsEmptyException(userMessage, userMessage, new Exception());
	}

}
