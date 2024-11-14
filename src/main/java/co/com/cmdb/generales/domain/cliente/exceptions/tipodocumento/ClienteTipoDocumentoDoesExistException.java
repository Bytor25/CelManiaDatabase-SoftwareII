package co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteTipoDocumentoDoesExistException extends RuleCmdbException {

	
	private static final long serialVersionUID = 1L;

	public ClienteTipoDocumentoDoesExistException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteTipoDocumentoDoesExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("ClienteTipoDocumentoDoesExistException");
		return new ClienteTipoDocumentoDoesExistException(userMessage, userMessage, new Exception());
	}

}
