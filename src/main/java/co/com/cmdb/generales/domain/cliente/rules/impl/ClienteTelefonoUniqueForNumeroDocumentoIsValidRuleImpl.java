package co.com.cmdb.generales.domain.cliente.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.application.secondaryports.repository.cliente.ClienteRepository;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.exceptions.ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.ClienteTelefonoUniqueForNumeroDocumentoIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteTelefonoUniqueForNumeroDocumentoIsValidRuleImpl implements ClienteTelefonoUniqueForNumeroDocumentoIsValidRule {

	private ClienteRepository clienteRepository;
	private MessageCatalogService messageCatalogService;
	
	public ClienteTelefonoUniqueForNumeroDocumentoIsValidRuleImpl(ClienteRepository clienteRepository, MessageCatalogService messageCatalogService) {
		this.clienteRepository = clienteRepository;
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(ClienteDomain data) {
		var clienteEntity = ClienteEntity.create().setTelefono(data.getTelefono());
		var resultado = clienteRepository.selectByFilter(clienteEntity);
		
		boolean existeTelefonoRegistradoConOtroDocumento = resultado.stream()
				.anyMatch(cliente -> 
				cliente.getTelefono().equals(data.getTelefono()) &&
				(!cliente.getNumeroDocumento().equals(data.getNumeroDocumento()))
				);

		if (existeTelefonoRegistradoConOtroDocumento) {
			throw ClienteTelefonoUniqueForNumeroDocumentoIsNotValidException.create(messageCatalogService);
		}
	}

}
