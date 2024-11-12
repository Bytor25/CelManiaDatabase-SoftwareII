package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordLengthIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordLengthIsValidRule;

@Service
public class LoginPasswordLengthIsValidRuleImpl implements LoginPasswordLengthIsValidRule{

	@Override
	public void execute(Integer data) {
		if(!TextHelper.hasMinLength(data.toString(), 4)) {
			throw LoginPasswordLengthIsNotValidException.create(1);
		}else if(!TextHelper.hasMaxLength(data.toString(), 4)) {
			throw LoginPasswordLengthIsNotValidException.create(2);
		}
	}
}
