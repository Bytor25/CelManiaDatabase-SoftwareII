package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteNameFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNameFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNameFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNameFormatIsNotValidException");
		return new ClienteNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
