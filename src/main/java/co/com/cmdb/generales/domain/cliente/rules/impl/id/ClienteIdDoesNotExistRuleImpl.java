package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.repository.ClienteRepository;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdDoesNotExistException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdDoesNotExistRule;

@Service
public class ClienteIdDoesNotExistRuleImpl implements ClienteIdDoesNotExistRule{

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteIdDoesNotExistRuleImpl(final ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	@Override
	public void execute(UUID data) {
		if(clienteRepository.existsById(data)) {
			throw ClienteIdDoesNotExistException.create();
		
		}
		
	}

}
