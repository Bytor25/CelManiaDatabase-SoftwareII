package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteIdDoesExistException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteIdDoesExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteIdDoesExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteIdDoesExistException");
		return new ClienteIdDoesExistException(userMessage, userMessage, new Exception());
	}

}