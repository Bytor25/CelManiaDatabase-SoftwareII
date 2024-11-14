package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginPasswordIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginPasswordIsEmptyException");
		return new LoginPasswordIsEmptyException(userMessage, userMessage, new Exception());
	}

}
