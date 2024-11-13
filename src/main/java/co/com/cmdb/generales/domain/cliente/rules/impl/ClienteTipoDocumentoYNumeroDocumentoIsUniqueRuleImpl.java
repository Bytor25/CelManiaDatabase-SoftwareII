package co.com.cmdb.generales.domain.cliente.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.ClienteRepository;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.exceptions.ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException;
import co.com.cmdb.generales.domain.cliente.rules.ClienteTipoDocumentoYNumeroDocumentoIsUniqueRule;

@Service
public class ClienteTipoDocumentoYNumeroDocumentoIsUniqueRuleImpl implements ClienteTipoDocumentoYNumeroDocumentoIsUniqueRule{
	private ClienteRepository clienteRepository;
	
	public ClienteTipoDocumentoYNumeroDocumentoIsUniqueRuleImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public void execute(ClienteDomain data) {
	
		var clienteEntity = ClienteEntity.create()
				.setNumeroDocumento(data.getNumeroDocumento())
				.setTipoDocumento(TipoDocumentoEntityMapper.INSTANCE.toEntity(data.getTipoDocumento()));

		var resultado = clienteRepository.selectByFilter(clienteEntity);

		boolean existeClienteConMismaCombinacion = resultado.stream()
				.anyMatch(cliente -> 
					cliente.getNumeroDocumento() == data.getNumeroDocumento() && 
					cliente.getTipoDocumento().getId() == data.getTipoDocumento().getId()
				);

		if (existeClienteConMismaCombinacion) {
			throw ClienteTipoDocumentoYNumeroDocumentoIsNotUniqueException.create();
		}
	}

}
