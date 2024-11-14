package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginPasswordFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginPasswordFormatIsNotValidException");;
		return new LoginPasswordFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
