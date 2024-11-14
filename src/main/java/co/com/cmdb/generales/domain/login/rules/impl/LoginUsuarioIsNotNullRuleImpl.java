package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioIsNullException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class LoginUsuarioIsNotNullRuleImpl implements LoginUsuarioIsNotEmptyRule{
	
	private MessageCatalogService messageCatalogService;
	
	public LoginUsuarioIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw LoginUsuarioIsNullException.create(messageCatalogService);
		}
	}

}
