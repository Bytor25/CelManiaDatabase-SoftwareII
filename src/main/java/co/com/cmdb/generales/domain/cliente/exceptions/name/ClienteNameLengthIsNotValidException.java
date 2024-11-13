package co.com.cmdb.generales.domain.cliente.exceptions.name;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;


public class ClienteNameLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNameLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	

	public static final ClienteNameLengthIsNotValidException create(int typeUserMessage, MessageCatalogService messageCatalogService) {
		if(typeUserMessage == 1) {
			var userMessage1 = messageCatalogService.getMessage("ClienteNameLengthIsNotValidExceptionCorto");
			return new ClienteNameLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = messageCatalogService.getMessage("ClienteNameLengthIsNotValidExceptionLargo");
			return new ClienteNameLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = messageCatalogService.getMessage("ClienteNameLengthIsNotValidException");
		return new ClienteNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
