package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioIsEmptyException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotEmptyRule;

@Service
public class LoginUsuarioIsNotNullRuleImpl implements LoginUsuarioIsNotEmptyRule{
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw LoginUsuarioIsEmptyException.create();
		}
	}

}
