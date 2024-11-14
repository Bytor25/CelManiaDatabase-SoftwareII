package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.application.secondaryports.repository.login.LoginRepository;
import co.com.cmdb.generales.domain.login.LoginDomain;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioPasswordIsNotCorrectException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioPasswordIsCorrectRule;

@Service
public class LoginUsuarioPasswordIsCorrectRuleImpl implements LoginUsuarioPasswordIsCorrectRule{

	private LoginRepository loginRepository;
	
	public LoginUsuarioPasswordIsCorrectRuleImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@Override
	public void execute(LoginDomain data) {
		
		var loginEntity = LoginEntity.create().setUsuario(data.getUsuario()).setPassword(data.getPassword());
		
		var resultado = loginRepository.selectByFilter(loginEntity);
		
        boolean isValidLogin = resultado.stream()
                .anyMatch(login -> 
                        login.getUsuario().equals(data.getUsuario()) &&
                        login.getPassword() == data.getPassword()
                );

        if (!isValidLogin) {
            throw LoginUsuarioPasswordIsNotCorrectException.create();
        }
		
	}

}
