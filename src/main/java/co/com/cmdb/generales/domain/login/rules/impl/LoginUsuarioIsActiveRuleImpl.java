package co.com.cmdb.generales.domain.login.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.application.secondaryports.repository.login.LoginRepository;
import co.com.cmdb.generales.domain.login.LoginDomain;
import co.com.cmdb.generales.domain.login.exceptions.LoginUsuarioIsNotActiveException;
import co.com.cmdb.generales.domain.login.rules.LoginUsuarioIsActiveRule;

@Service
public class LoginUsuarioIsActiveRuleImpl implements LoginUsuarioIsActiveRule {
	
	private LoginRepository loginRepository;
	
	public LoginUsuarioIsActiveRuleImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public void execute(LoginDomain data) {
		var loginEntity = LoginEntity.create().setUsuario(data.getUsuario()).setPassword(data.getPassword());
		
		var resultado = loginRepository.selectByFilter(loginEntity);
		
        boolean isUserActive = resultado.stream()
                .anyMatch(login -> 
                        login.getUsuario().equals(data.getUsuario()) &&
                        login.getPassword() == data.getPassword() &&
                        login.isEstado()
                );

        if (!isUserActive) {
            throw LoginUsuarioIsNotActiveException.create();
        }
	}

}
