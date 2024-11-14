package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginPasswordIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginPasswordIsNullException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginPasswordIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginPasswordIsNullException");;
		return new LoginPasswordIsNullException(userMessage, userMessage, new Exception());
	}

}
