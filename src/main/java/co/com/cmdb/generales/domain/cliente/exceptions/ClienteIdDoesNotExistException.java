package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public final class ClienteIdDoesNotExistException extends RuleCmdbException  {

	private static final long serialVersionUID = 1L;

	public ClienteIdDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteIdDoesNotExistException create() {
		
		var userMessage = "No existe el cliente con el identificador dado...";
		return new ClienteIdDoesNotExistException(userMessage, userMessage, new Exception());
		
		
	}
	

}
