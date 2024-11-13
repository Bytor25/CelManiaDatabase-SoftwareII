package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteEmailFormatIsNotValidException  extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteEmailFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteEmailFormatIsNotValidException");
		return new ClienteEmailFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
