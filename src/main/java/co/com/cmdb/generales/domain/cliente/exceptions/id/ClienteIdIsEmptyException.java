package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final class ClienteIdIsEmptyException extends RuleCmdbException  {

	private static final long serialVersionUID = 1L;

	public ClienteIdIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ClienteIdIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteIdIsEmptyException");
		return new ClienteIdIsEmptyException(userMessage, userMessage, new Exception());
		
	}

}
