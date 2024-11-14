package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginUsuarioIsEmptyException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioIsEmptyException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioIsEmptyException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginUsuarioIsEmptyException");
		return new LoginUsuarioIsEmptyException(userMessage, userMessage, new Exception());
	}

}
