package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteLastNameIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteLastNameIsEmptyException");
		return new ClienteLastNameIsEmptyException(userMessage, userMessage, new Exception());
	}

}
