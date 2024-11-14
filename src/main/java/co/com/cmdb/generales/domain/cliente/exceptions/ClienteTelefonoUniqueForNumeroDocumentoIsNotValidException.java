package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException");
		return new ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException(userMessage, userMessage, new Exception());
	}

}
