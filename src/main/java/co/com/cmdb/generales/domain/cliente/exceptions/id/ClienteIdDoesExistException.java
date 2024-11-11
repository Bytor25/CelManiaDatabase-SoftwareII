package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteIdDoesExistException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteIdDoesExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteIdDoesExistException create() {
		var userMessage = "El id del cliente si existe...";
		return new ClienteIdDoesExistException(userMessage, userMessage, new Exception());
	}

}
