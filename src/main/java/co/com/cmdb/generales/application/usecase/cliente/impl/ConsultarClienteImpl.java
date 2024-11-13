package co.com.cmdb.generales.application.usecase.cliente.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.mapper.ClienteEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.ClienteRepository;
import co.com.cmdb.generales.application.usecase.cliente.ConsultarCliente;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;

@Service
public class ConsultarClienteImpl implements ConsultarCliente{

	private ClienteRepository clienteRepository;
	
	public ConsultarClienteImpl(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public List<ClienteDomain> execute(ClienteDomain data) {
		var clienteEntity = ClienteEntityMapper.INSTACE.toEntity(data);
		
		var resultadoEntity = clienteRepository.selectByFilter(clienteEntity);
		
		return ClienteEntityMapper.INSTACE.toDomainCollection(resultadoEntity);
	}

}
