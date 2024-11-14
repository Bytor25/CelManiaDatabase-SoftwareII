package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordIsEmptyException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class LoginPasswordIsNotEmptyRuleImpl implements LoginPasswordIsNotEmptyRule{

	private MessageCatalogService messageCatalogService;
	
	public LoginPasswordIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	
	@Override
	public void execute(Integer data) {
		if(NumericHelper.isNullOrEmpty(data)) {
			throw LoginPasswordIsEmptyException.create(messageCatalogService);
		}
		
	}

}
