package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginPasswordLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordLengthIsNotValidException create(int typeUserMessage, MessageCatalogService messageCatalogService) {
		
		if(typeUserMessage == 1) {
			var userMessage1 = messageCatalogService.getMessage("LoginPasswordLengthIsNotValidExceptionLargo"); ;
			return new LoginPasswordLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}else if(typeUserMessage == 2) {
			var userMessage2 = messageCatalogService.getMessage("LoginPasswordLengthIsNotValidException");
			return new LoginPasswordLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage = messageCatalogService.getMessage("LoginPasswordLengthIsNotValidException");
		return new LoginPasswordLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
