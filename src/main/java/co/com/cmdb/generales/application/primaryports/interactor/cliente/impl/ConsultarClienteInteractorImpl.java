package co.com.cmdb.generales.application.primaryports.interactor.cliente.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.ConsultarClienteInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.ClienteDtoMapper;
import co.com.cmdb.generales.application.usecase.cliente.ConsultarCliente;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultarClienteInteractorImpl implements ConsultarClienteInteractor{
	
	private ConsultarCliente consultarClienteUseCase;
	
	public ConsultarClienteInteractorImpl (ConsultarCliente consultarClienteUseCase) {
		this.consultarClienteUseCase = consultarClienteUseCase;
	}
	
	@Override
	public List<ClienteDTO> execute(ClienteDTO data) {
		
		try {
			var clienteDomain = ClienteDtoMapper.INSTANCE.toDomain(data);
			
			var resultado = consultarClienteUseCase.execute(clienteDomain);
			
			return ClienteDtoMapper.INSTANCE.toDtoCollection(resultado);
			
		}catch(CmdbException exception) {
			
			var userMessage = "Se ha presentado un problema al consultar la informacion de los clientes";
			throw DataCmdbException.create(userMessage);
		}
	}

}
