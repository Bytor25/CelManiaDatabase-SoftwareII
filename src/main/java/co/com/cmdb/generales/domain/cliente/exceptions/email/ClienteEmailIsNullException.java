package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteEmailIsNullException  extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteEmailIsNullException");
		return new ClienteEmailIsNullException(userMessage, userMessage, new Exception());
	}

}
