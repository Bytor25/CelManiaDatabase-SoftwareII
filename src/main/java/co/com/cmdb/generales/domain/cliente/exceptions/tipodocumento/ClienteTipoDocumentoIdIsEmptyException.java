package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


public class ClienteTipoDocumentoIdIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoIdIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoIdIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTipoDocumentoIdIsEmptyException");
		return new ClienteTipoDocumentoIdIsEmptyException(userMessage, userMessage, new Exception());
	}

}
