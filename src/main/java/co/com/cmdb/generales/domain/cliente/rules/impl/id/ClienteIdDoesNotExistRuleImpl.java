package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.repository.cliente.ClienteRepository;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdDoesNotExistException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdDoesNotExistRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteIdDoesNotExistRuleImpl implements ClienteIdDoesNotExistRule{

	@Autowired
	private ClienteRepository clienteRepository;
	
	private MessageCatalogService messageCatalogService;
	
	public ClienteIdDoesNotExistRuleImpl(final ClienteRepository clienteRepository, MessageCatalogService messageCatalogService) {
		this.clienteRepository = clienteRepository;
		this.messageCatalogService = messageCatalogService;
	}
	@Override
	public void execute(UUID data) {
		if(clienteRepository.existsById(data)) {
			throw ClienteIdDoesNotExistException.create(messageCatalogService);
		
		}
		
	}

}
