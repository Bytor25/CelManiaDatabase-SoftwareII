package co.com.cmdb.generales.application.primaryports.interactor.cliente.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.RegistrarClienteInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.ClienteDtoMapper;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarCliente;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.exceptions.InteractorCmdbException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrarClienteInteractorImpl implements RegistrarClienteInteractor {
	
	private RegistrarCliente registrarNuevoClienteUseCase; 
	
	public RegistrarClienteInteractorImpl(final RegistrarCliente regregistrarNuevoClienteUseCase) {
		
		this.registrarNuevoClienteUseCase = regregistrarNuevoClienteUseCase;
		
	}
	
	@Override
	public void execute(ClienteDTO data) {
		
		try {
			var clienteDomain = ClienteDtoMapper.INSTANCE.toDomain(data);
			
			registrarNuevoClienteUseCase.execute(clienteDomain);
			
		}catch (CmdbException exception) {
			throw exception;
		}catch (Exception exception) {
			var userMessage = "Se ha presentado un problema al llevar a cabo el registro del cliente. Si el problema persiste, contacte al administrador";
			var technicalMessage = "Se ha presentado un error registrando el cliente en la capa del interactor, por favor revise la rama base del problema";
			throw new InteractorCmdbException(userMessage, technicalMessage, exception);
		}
		
	}

}
