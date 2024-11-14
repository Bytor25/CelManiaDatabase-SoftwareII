package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordIsNullException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordIsNotNullRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


@Service
public class LoginPasswordIsNotNullRuleImpl implements LoginPasswordIsNotNullRule{

	
	private MessageCatalogService messageCatalogService;
	
	public LoginPasswordIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Integer data) {
		if(NumericHelper.isNullOrEmpty(data)) {
			throw LoginPasswordIsNullException.create(messageCatalogService);
		}
		
	}

}
