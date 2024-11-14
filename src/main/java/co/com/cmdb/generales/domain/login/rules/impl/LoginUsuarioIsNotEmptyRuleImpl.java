package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioIsEmptyException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotNullRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class LoginUsuarioIsNotEmptyRuleImpl implements LoginUsuarioIsNotNullRule{
	
	private MessageCatalogService messageCatalogService;
	
	public LoginUsuarioIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(ObjectHelper.isNull(data)) {
			throw LoginUsuarioIsEmptyException.create(messageCatalogService);
		}
	}

}
