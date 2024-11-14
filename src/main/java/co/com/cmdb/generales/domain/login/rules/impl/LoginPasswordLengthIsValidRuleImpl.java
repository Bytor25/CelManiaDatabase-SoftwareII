package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordLengthIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordLengthIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class LoginPasswordLengthIsValidRuleImpl implements LoginPasswordLengthIsValidRule{

	
	private MessageCatalogService messageCatalogService;
	
	public LoginPasswordLengthIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Integer data) {
		if(!TextHelper.hasMinLength(data.toString(), 4)) {
			throw LoginPasswordLengthIsNotValidException.create(1,messageCatalogService);
		}else if(!TextHelper.hasMaxLength(data.toString(), 4)) {
			throw LoginPasswordLengthIsNotValidException.create(2,messageCatalogService);
		}
	}
}
