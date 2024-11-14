package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteNameIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNameIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final ClienteNameIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNameIsEmptyException");
		return new ClienteNameIsEmptyException(userMessage, userMessage, new Exception());
	}
}
