package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordFormatIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


@Service
public class LoginPasswordFormatIsValidRuleImpl implements LoginPasswordFormatIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	public LoginPasswordFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Integer data) {

		if(!TextHelper.isOnlyNumbers(data.toString())) {
			throw LoginPasswordFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
