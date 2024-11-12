package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioFormatIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioFormatIsValidRule;

@Service
public class LoginUsuarioFormatIsValidRuleImpl implements LoginUsuarioFormatIsValidRule{
	@Override
	public void execute(String data) {
		if(!TextHelper.hasMinLength(data, 3) && !TextHelper.hasMaxLength(data, 20)) {
			throw LoginUsuarioFormatIsNotValidException.create();
		}
	}

}
