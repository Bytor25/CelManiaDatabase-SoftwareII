package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteLastNameIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteLastNameIsNullException");
		return new ClienteLastNameIsNullException(userMessage, userMessage, new Exception());
	}

}
