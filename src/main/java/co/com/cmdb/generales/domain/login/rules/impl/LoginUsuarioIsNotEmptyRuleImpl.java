package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioIsNullException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotNullRule;

@Service
public class LoginUsuarioIsNotEmptyRuleImpl implements LoginUsuarioIsNotNullRule{
	@Override
	public void execute(String data) {
		if(ObjectHelper.isNull(data)) {
			throw LoginUsuarioIsNullException.create();
		}
	}

}
