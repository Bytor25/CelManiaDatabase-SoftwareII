package co.com.cmdb.generales.application.primaryports.interactor.login.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.application.primaryports.interactor.login.SubmitLoginCredentialsInteractor;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubmitLoginCredentialsInteractorImpl implements SubmitLoginCredentialsInteractor{

	
	@Override
	public void execute(LoginDTO data) {
		// TODO Auto-generated method stub
		
	}

}
