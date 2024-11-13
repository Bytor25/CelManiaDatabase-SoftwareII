package co.com.cmdb.generales.domain.cliente.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.application.secondaryports.repository.ClienteRepository;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.exceptions.ClienteEmailUniqueForNumeroDocumentoIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.ClienteEmailUniqueForNumeroDocumentoIsValidRule;

@Service
public class ClienteEmailUniqueForNumeroDocumentoIsValidRuleImpl implements ClienteEmailUniqueForNumeroDocumentoIsValidRule {
	
	private ClienteRepository clienteRepository;
	
	public ClienteEmailUniqueForNumeroDocumentoIsValidRuleImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public void execute(ClienteDomain data) {

		var clienteEntity = ClienteEntity.create().setCorreo(data.getCorreo());
		

		var resultado = clienteRepository.selectByFilter(clienteEntity);
		

		boolean correoAsociadoAlMismoDocumento = resultado.stream()
				.anyMatch(cliente -> 
					cliente.getCorreo().equals(data.getCorreo()) &&
					cliente.getNumeroDocumento() == data.getNumeroDocumento() &&
					cliente.getTipoDocumento().getId() == data.getTipoDocumento().getId()
				);
		

		if (!correoAsociadoAlMismoDocumento && !resultado.isEmpty()) {
			throw ClienteEmailUniqueForNumeroDocumentoIsNotValidException.create();
		}
	}

}
