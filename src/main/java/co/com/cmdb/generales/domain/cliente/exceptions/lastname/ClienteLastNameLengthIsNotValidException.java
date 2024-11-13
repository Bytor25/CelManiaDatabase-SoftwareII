package co.com.cmdb.generales.domain.cliente.exceptions.lastname;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;


public class ClienteLastNameLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteLastNameLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteLastNameLengthIsNotValidException create(int typeUserMessage,MessageCatalogService messageCatalogService) {
		if(typeUserMessage == 1) {
			
			var userMessage1 = messageCatalogService.getMessage("ClienteLastNameLengthIsNotValidExceptionCorto");
			return new ClienteLastNameLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = messageCatalogService.getMessage("ClienteLastNameLengthIsNotValidExceptionLargo");
			return new ClienteLastNameLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = messageCatalogService.getMessage("ClienteLastNameLengthIsNotValidException");
		return new ClienteLastNameLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
