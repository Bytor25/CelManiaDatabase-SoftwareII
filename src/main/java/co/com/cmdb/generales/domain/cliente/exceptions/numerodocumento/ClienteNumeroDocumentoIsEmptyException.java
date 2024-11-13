package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteNumeroDocumentoIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNumeroDocumentoIsEmptyException");
		return new ClienteNumeroDocumentoIsEmptyException(userMessage, userMessage, new Exception());
	}

}
