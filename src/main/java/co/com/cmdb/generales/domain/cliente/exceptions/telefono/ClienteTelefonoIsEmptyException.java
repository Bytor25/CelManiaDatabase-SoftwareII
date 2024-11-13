package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteTelefonoIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoIsEmptyException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteTelefonoIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTelefonoIsEmptyException");
		return new ClienteTelefonoIsEmptyException(userMessage, userMessage, new Exception());
	}

}
