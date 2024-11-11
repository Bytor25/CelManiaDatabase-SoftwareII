package co.com.cmdb.generales.application.primaryports.interactor.cliente.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.RegistrarClienteInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.ClienteDtoMapper;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarCliente;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrarClienteInteractorImpl implements RegistrarClienteInteractor {
	
	private RegistrarCliente registrarNuevoClienteUseCase; 
	
	public RegistrarClienteInteractorImpl(final RegistrarCliente regregistrarNuevoClienteUseCase) {
		
		this.registrarNuevoClienteUseCase = regregistrarNuevoClienteUseCase;
		
	}
	
	@Override
	public void execute(ClienteDTO cliente) {
		
		var clienteDomain = ClienteDtoMapper.INSTANCE.toDomain(cliente);
		
		registrarNuevoClienteUseCase.execute(clienteDomain);
		
	}

}
