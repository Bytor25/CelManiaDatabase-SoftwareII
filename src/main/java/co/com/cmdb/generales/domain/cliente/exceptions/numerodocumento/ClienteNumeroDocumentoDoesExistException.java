package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


public class ClienteNumeroDocumentoDoesExistException extends RuleCmdbException {

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoDoesExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoDoesExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNumeroDocumentoDoesExistException");
		return new ClienteNumeroDocumentoDoesExistException(userMessage, userMessage, new Exception());
	}

}
