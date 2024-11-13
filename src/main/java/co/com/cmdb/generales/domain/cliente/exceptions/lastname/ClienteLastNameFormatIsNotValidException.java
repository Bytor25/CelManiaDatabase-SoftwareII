package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteLastNameFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteLastNameFormatIsNotValidException");
		return new ClienteLastNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}
}
