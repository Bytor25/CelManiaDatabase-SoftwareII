package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;;

public class ClienteTelefonoDoesNotExistException extends RuleCmdbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteTelefonoDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteTelefonoDoesNotExistException create() {
		var userMessage = "El número de teléfono del cliente no existe en el sistema. Por favor, verifique los datos ingresados o contacte al administrador para obtener más información.";
		return new ClienteTelefonoDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
