package co.com.cmdb.generales.domain.cliente.exceptions.telefono;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteTelefonoRangeIsNotValidException extends RuleCmdbException {

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoRangeIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteTelefonoRangeIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTelefonoRangeIsNotValidException");
		return new ClienteTelefonoRangeIsNotValidException(userMessage, userMessage, new Exception());
	}

}
