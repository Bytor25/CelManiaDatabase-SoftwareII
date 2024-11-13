package co.com.cmdb.generales.domain.cliente.exceptions.id;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public final class ClienteIdFormatIsNotValidException extends RuleCmdbException {
	
	private static final long serialVersionUID = 1L;

	public ClienteIdFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteIdFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteIdFormatIsNotValidException");
		return new ClienteIdFormatIsNotValidException(userMessage, userMessage, new Exception());
		
	}
	
	

}
