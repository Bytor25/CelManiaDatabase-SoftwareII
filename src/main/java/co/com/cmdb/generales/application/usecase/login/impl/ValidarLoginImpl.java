package co.com.cmdb.generales.application.usecase.login.impl;

import java.util.List;

import co.com.cmdb.generales.application.secondaryports.mapper.LoginEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.login.LoginRepository;
import co.com.cmdb.generales.application.usecase.login.ValidarLogin;
import co.com.cmdb.generales.domain.login.LoginDomain;

public class ValidarLoginImpl implements ValidarLogin{

	private LoginRepository loginRepository;
	
	public ValidarLoginImpl(LoginRepository loginRepository) {
		
		this.loginRepository = loginRepository;
	}
	@Override
	public List<LoginDomain> execute(LoginDomain data) {
		
		var loginEntity = LoginEntityMapper.INSTANCE.toEntity(data);
		
		var resultadoEntity = loginRepository.selectByFilter(loginEntity);
		
		return LoginEntityMapper.INSTANCE.toDomainCollection(resultadoEntity);
	}

}
