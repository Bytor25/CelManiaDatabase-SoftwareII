package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class ClienteNumeroDocumentoFormatIsNotValidException extends RuleCmdbException {

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	
	public static final ClienteNumeroDocumentoFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteNumeroDocumentoFormatIsNotValidException");
		return new ClienteNumeroDocumentoFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
