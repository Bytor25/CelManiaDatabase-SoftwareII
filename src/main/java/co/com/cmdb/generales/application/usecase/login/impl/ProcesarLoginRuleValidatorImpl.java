package co.com.cmdb.generales.application.usecase.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.usecase.login.ProcesarLoginRuleValidator;
import co.com.cmdb.generales.domain.login.LoginDomain;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordFormatIsValidRule;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordIsNotEmptyRule;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordIsNotNullRule;
import co.com.cmdb.generales.domain.login.rules.LoginPasswordLengthIsValidRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioDoesExistRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioFormatIsValidRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsActiveRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotEmptyRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsNotNullRule;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioPasswordIsCorrectRule;

@Service
public class ProcesarLoginRuleValidatorImpl implements ProcesarLoginRuleValidator{

	@Autowired
	private LoginPasswordFormatIsValidRule loginPasswordFormatIsValidRule;
	
	@Autowired
	private LoginPasswordIsNotEmptyRule loginPasswordIsNotEmptyRule;
	
	@Autowired
	private LoginPasswordIsNotNullRule loginPasswordIsNotNullRule;
	
	@Autowired
	private LoginPasswordLengthIsValidRule loginPasswordLengthIsValidRule;
	
	@Autowired
	private LoginUsuarioDoesExistRule loginUsuarioDoesExistRule;
	
	@Autowired
	private LoginUsuarioFormatIsValidRule loginUsuarioFormatIsValidRule;
	
	@Autowired
	private LoginUsuarioIsNotEmptyRule loginUsuarioIsNotEmpty;
	
	@Autowired
	private LoginUsuarioIsNotNullRule loginUsuarioIsNotNullRule;
	
	@Autowired
	private LoginUsuarioIsActiveRule loginUsuarioIsActiveRule;
	
	@Autowired
	private LoginUsuarioPasswordIsCorrectRule loginUsuarioPasswordIsCorrectRule;
	
	@Override
	public void validate(LoginDomain data) {
		
			validateRulesRelatedWithUsuario(data.getUsuario());
			
			validateRulesRelatedWithPassword(data.getPassword());
			
			loginUsuarioPasswordIsCorrectRule.execute(data);
			
			loginUsuarioIsActiveRule.execute(data);
			
			

	}
	
	private void validateRulesRelatedWithPassword(final int password) {
		
		 loginPasswordIsNotEmptyRule.execute(password);
			
		 loginPasswordIsNotNullRule.execute(password);
		 
		 loginPasswordFormatIsValidRule.execute(password);
		
		 loginPasswordLengthIsValidRule.execute(password);
	}
	
	private void validateRulesRelatedWithUsuario(final String usuario) {
		loginUsuarioDoesExistRule.execute(usuario);
		
		loginUsuarioFormatIsValidRule.execute(usuario);;
		
		loginUsuarioIsNotEmpty.execute(usuario);
		
		loginUsuarioIsNotNullRule.execute(usuario);;
	}

}
