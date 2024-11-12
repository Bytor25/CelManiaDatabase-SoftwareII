package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordFormatIsNotValidException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordFormatIsValidRule;


@Service
public class LoginPasswordFormatIsValidRuleImpl implements LoginPasswordFormatIsValidRule{

	@Override
	public void execute(Integer data) {

		if(!TextHelper.isOnlyNumbers(data.toString())) {
			throw LoginPasswordFormatIsNotValidException.create();
		}
		
	}

}
