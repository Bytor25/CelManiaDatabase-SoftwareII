package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

public class ClienteEmailLengthIsNotValidException extends RuleCmdbException{

	
	private static final long serialVersionUID = 1L;

	public ClienteEmailLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailLengthIsNotValidException create(int typeUserMessage, MessageCatalogService messageCatalogService) {
		if(typeUserMessage == 1) {
			var userMessage = messageCatalogService.getMessage("ClienteEmailLengthIsNotValidExceptionCorto");
			return new ClienteEmailLengthIsNotValidException(userMessage, userMessage, new Exception());
		}
		if(typeUserMessage == 2){
			
			var userMessage2 = messageCatalogService.getMessage("ClienteEmailLengthIsNotValidExceptionLargo");
			return new ClienteEmailLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = messageCatalogService.getMessage("ClienteEmailLengthIsNotValidException");
		return new ClienteEmailLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
