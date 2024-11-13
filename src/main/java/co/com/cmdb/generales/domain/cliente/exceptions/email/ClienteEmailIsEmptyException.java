package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteEmailIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteEmailIsEmptyException");
		return new ClienteEmailIsEmptyException(userMessage, userMessage, new Exception());
	}

}
