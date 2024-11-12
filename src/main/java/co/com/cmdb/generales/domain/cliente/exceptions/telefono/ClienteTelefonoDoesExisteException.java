package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteTelefonoDoesExisteException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTelefonoDoesExisteException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTelefonoDoesExisteException create() {
		var userMessage = "El número de teléfono proporcionado para el cliente ya existe en el sistema.";
		return new ClienteTelefonoDoesExisteException(userMessage, userMessage, new Exception());
	}


}
