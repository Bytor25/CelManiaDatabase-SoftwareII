package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteTipoDocumentoDoesNotExistException extends RuleCmdbException{


	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoDoesNotExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoDoesNotExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTipoDocumentoDoesNotExistException");
		return new ClienteTipoDocumentoDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
