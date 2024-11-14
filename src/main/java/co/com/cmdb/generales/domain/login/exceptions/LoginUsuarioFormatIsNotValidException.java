package co.com.cmdb.generales.domain.login.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

public class LoginUsuarioFormatIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public LoginUsuarioFormatIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final LoginUsuarioFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("LoginUsuarioFormatIsNotValidException");
		return new LoginUsuarioFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
