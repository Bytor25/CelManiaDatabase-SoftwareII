package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioFormatIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class LoginUsuarioFormatIsValidRuleImpl implements LoginUsuarioFormatIsValidRule{
	
	private MessageCatalogService messageCatalogService;
	
	public LoginUsuarioFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(!TextHelper.hasMinLength(data, 3) && !TextHelper.hasMaxLength(data, 20)) {
			throw LoginUsuarioFormatIsNotValidException.create(messageCatalogService);
		}
	}

}
