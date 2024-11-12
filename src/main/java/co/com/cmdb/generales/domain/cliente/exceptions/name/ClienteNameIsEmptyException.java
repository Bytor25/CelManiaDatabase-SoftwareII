package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNameIsEmptyException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNameIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}

	public static final ClienteNameIsEmptyException create() {
		var userMessage = "El campo de nombre es obligatorio. Por favor, ingresa un nombre válido.";
		return new ClienteNameIsEmptyException(userMessage, userMessage, new Exception());
	}
}
