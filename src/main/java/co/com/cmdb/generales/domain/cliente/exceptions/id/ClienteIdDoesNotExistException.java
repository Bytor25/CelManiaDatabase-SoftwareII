package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public final class ClienteIdDoesNotExistException extends RuleCmdbException  {

	private static final long serialVersionUID = 1L;

	public ClienteIdDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteIdDoesNotExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteIdDoesNotExistException");
		return new ClienteIdDoesNotExistException(userMessage, userMessage, new Exception());
		
	}
	

}
