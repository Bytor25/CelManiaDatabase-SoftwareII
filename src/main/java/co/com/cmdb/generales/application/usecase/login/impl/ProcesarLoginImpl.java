package co.com.cmdb.generales.application.usecase.login.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.application.secondaryports.repository.login.LoginRepository;
import co.com.cmdb.generales.application.usecase.login.ProcesarLogin;
import co.com.cmdb.generales.application.usecase.login.ProcesarLoginRuleValidator;
import co.com.cmdb.generales.crosscutting.exceptions.ApplicationCmdbException;
import co.com.cmdb.generales.domain.login.LoginDomain;
		
@Service
public class ProcesarLoginImpl implements ProcesarLogin{
	
	private LoginRepository loginRepository;
	private ProcesarLoginRuleValidator procesarLoginRuleValidator;
	
	public ProcesarLoginImpl(final LoginRepository loginRepository, final ProcesarLoginRuleValidator procesarLoginRuleValidator) {
		this.loginRepository = loginRepository;
		this.procesarLoginRuleValidator = procesarLoginRuleValidator;
	}

	@Override
	public Boolean execute(final LoginDomain data) {
		
		procesarLoginRuleValidator.validate(data);
		
		var loginEntity = LoginEntity.create().setUsuario(data.getUsuario()).setPassword(data.getPassword());
		
		var resultados = loginRepository.selectByFilter(loginEntity);
		
		if(resultados.isEmpty()) {
			var userMessage = "Ocurrio un error a la hora de validar y consultar las credenciales";
			throw ApplicationCmdbException.create((userMessage));
		}
		
		return true;
	}
	
	
}
