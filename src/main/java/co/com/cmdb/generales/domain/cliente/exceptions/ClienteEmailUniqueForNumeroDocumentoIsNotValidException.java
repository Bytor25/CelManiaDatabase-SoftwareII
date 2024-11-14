package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteEmailUniqueForNumeroDocumentoIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailUniqueForNumeroDocumentoIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	public static final ClienteEmailUniqueForNumeroDocumentoIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteEmailUniqueForNumeroDocumentoIsNotValidException");
		return new ClienteEmailUniqueForNumeroDocumentoIsNotValidException(userMessage, userMessage, new Exception());
	}

}
