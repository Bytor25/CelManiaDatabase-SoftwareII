package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


public class ClienteNameIsNullException extends RuleCmdbException {

	private static final long serialVersionUID = 1L;

	public ClienteNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ClienteNameIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNameIsNullException");
		return new ClienteNameIsNullException(userMessage, userMessage, new Exception());
	}

}
