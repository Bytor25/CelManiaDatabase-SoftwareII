package co.com.cmdb.generales.application.primaryports.interactor.login.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.application.primaryports.interactor.login.ProcesarLoginInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.LoginDtoMapper;
import co.com.cmdb.generales.application.usecase.login.ProcesarLogin;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProcesarLoginInteractorImpl implements ProcesarLoginInteractor{
	
	private ProcesarLogin procesarLoginUseCase;
	
	public ProcesarLoginInteractorImpl(final ProcesarLogin procesarLoginUseCase){
		this.procesarLoginUseCase = procesarLoginUseCase;
	}
		
	
	
	@Override
	public Boolean execute(LoginDTO data) {

			
			var loginDomain = LoginDtoMapper.INSTANCE.toDomain(data);
			
			procesarLoginUseCase.execute(loginDomain);
			
			return true;
			
		
	}

}
