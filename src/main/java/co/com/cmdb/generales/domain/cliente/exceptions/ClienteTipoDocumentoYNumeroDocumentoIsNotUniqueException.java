package co.com.cmdb.generales.domain.cliente.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	
	public static final ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException");
		return new ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException(userMessage, userMessage, new Exception());
	}

}
