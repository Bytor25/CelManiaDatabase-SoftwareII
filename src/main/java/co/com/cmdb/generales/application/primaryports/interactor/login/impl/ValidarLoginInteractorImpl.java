package co.com.cmdb.generales.application.primaryports.interactor.login.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.application.primaryports.interactor.login.ValidarLoginInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.LoginDtoMapper;
import co.com.cmdb.generales.application.usecase.login.ValidarLogin;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;

@Service
@Transactional
public class ValidarLoginInteractorImpl implements ValidarLoginInteractor{

	private ValidarLogin validarLoginUseCase;
	
	public ValidarLoginInteractorImpl (ValidarLogin validarLoginUseCase) {
		this.validarLoginUseCase = validarLoginUseCase;
	}
	@Override
	public List<LoginDTO> execute(LoginDTO data) {
		
		try {
			var loginCredentialsDomain = LoginDtoMapper.INSTANCE.toDomain(data);
			
			var resultado = validarLoginUseCase.execute(loginCredentialsDomain);
			
			return LoginDtoMapper.INSTANCE.toDtoCollection(resultado);
			
		}catch(CmdbException exception) {
			
			var userMessage = "Se ha presentado un problema al consultar los datos del usuario en la base de datos";
			throw DataCmdbException.create(userMessage);
		}
		
	}

}
