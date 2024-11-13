package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteNumeroDocumentoIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteNumeroDocumentoIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNumeroDocumentoIsNullException");
		return new ClienteNumeroDocumentoIsNullException(userMessage, userMessage, new Exception());
	}

}
