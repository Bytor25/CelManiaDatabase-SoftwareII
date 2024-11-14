package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginUsuarioIsNullException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioIsNullException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginUsuarioIsNullException");
		return new LoginUsuarioIsNullException(userMessage, userMessage, new Exception());
	}

}
