package co.com.cmdb.generales.application.primaryports.interactor.cliente.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.RegistrarClienteInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.ClienteDtoMapper;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarCliente;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.exceptions.InteractorCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrarClienteInteractorImpl implements RegistrarClienteInteractor {
	
	private RegistrarCliente registrarNuevoClienteUseCase;
	private MessageCatalogService messageCatalogService;
	
	public RegistrarClienteInteractorImpl(final RegistrarCliente regregistrarNuevoClienteUseCase, final MessageCatalogService messageCatalogService) {
		
		this.registrarNuevoClienteUseCase = regregistrarNuevoClienteUseCase;
		this.messageCatalogService = messageCatalogService;
		
	}
	
	@Override
	public void execute(ClienteDTO data) {
		
		try {
			var clienteDomain = ClienteDtoMapper.INSTANCE.toDomain(data);
			
			registrarNuevoClienteUseCase.execute(clienteDomain);
			
		}catch (CmdbException exception) {
			throw exception;
		}catch (Exception exception) {
			var userMessage = messageCatalogService.getMessage("ProblemaRegistro");
			var technicalMessage = messageCatalogService.getMessage("errorRegistroClienteInteractor");
			throw new InteractorCmdbException(userMessage, technicalMessage, exception);
		}
		
	}

}
