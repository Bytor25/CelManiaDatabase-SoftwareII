package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNameIsNullException extends RuleCmdbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ClienteNameIsNullException create() {
		var userMessage = "El campo de nombre es obligatorio. Por favor, ingresa un nombre válido.";
		return new ClienteNameIsNullException(userMessage, userMessage, new Exception());
	}

}
