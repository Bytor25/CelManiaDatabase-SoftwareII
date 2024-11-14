package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.application.secondaryports.repository.login.LoginRepository;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioDoesNotExistException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioDoesExistRule;

@Service
public class LoginUsuarioDoesExistRuleImpl implements LoginUsuarioDoesExistRule{
	private LoginRepository loginRepository;
	
	public LoginUsuarioDoesExistRuleImpl (LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@Override
	public void execute(String data) {
		
		var loginEntity = LoginEntity.create().setUsuario(data);
		
		if(loginRepository.selectByFilter(loginEntity).isEmpty()) {
			throw LoginUsuarioDoesNotExistException.create();
		}
		
		
		
	}

}
