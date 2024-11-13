package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteNumeroDocumentoLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoLengthIsNotValidException create(int typeUserMessage, MessageCatalogService messageCatalogService) {
		if(typeUserMessage == 1) {
			
			var userMessage1 = messageCatalogService.getMessage("ClienteNumeroDocumentoLengthIsNotValidExceptionCorto");
			return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			
			var userMessage2 = messageCatalogService.getMessage("ClienteNumeroDocumentoLengthIsNotValidExceptionLargo");
			return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = messageCatalogService.getMessage("ClienteNumeroDocumentoLengthIsNotValidException");
		
		return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
