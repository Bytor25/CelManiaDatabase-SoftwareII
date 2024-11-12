package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginPasswordIsEmptyException;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordIsNotEmptyRule;

@Service
public class LoginPasswordIsNotEmptyRuleImpl implements LoginPasswordIsNotEmptyRule{

	@Override
	public void execute(Integer data) {
		if(NumericHelper.isNullOrEmpty(data)) {
			throw LoginPasswordIsEmptyException.create();
		}
		
	}

}
