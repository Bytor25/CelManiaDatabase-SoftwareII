package co.com.cmdb.generales.application.usecase.cliente.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.ClienteRepository;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarCliente;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarClienteRuleValidator;
import co.com.cmdb.generales.crosscutting.exceptions.UseCaseCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;

@Service
public class RegistrarClienteImpl implements RegistrarCliente {
	
	private ClienteRepository clienteRepository;
	private RegistrarClienteRuleValidator registrarClienteRuleValidator;
	
	public RegistrarClienteImpl(final ClienteRepository clienteRepository, final RegistrarClienteRuleValidator registrarClienteRuleValidator) {
		
		if (ObjectHelper.isNull(clienteRepository) || ObjectHelper.isNull(registrarClienteRuleValidator)) {
			var userMessage = "No se pudo completar el registro de la ciudad. Por favor, intente nuevamente más tarde.";
			var technicalMessage = "Los servicios requeridos para registrar una ciudad no fueron proporcionados correctamente. Verifique que los parámetros cityRepository y registerNewCityRulesValidator no sean null.";
			throw new UseCaseCmdbException(userMessage, technicalMessage, new Exception());
		}
		this.clienteRepository = clienteRepository;
		this.registrarClienteRuleValidator = registrarClienteRuleValidator;
		
	}
	
	@Override
	public void execute(final ClienteDomain cliente) {
		
		registrarClienteRuleValidator.validate(cliente);
	
		var id = generarIdentificadorCliente();

		var clienteEntity = ClienteEntity.create().setId(id).setTipoDocumento(TipoDocumentoEntityMapper.INSTANCE
				.toEntity(cliente.getTipoDocumento())).setNumeroDocumento(cliente.getNumeroDocumento())
				.setNombre(cliente.getNombre()).setApellidos(cliente.getApellidos())
				.setCorreo(cliente.getCorreo()).setTelefono(cliente.getTelefono());
		
		clienteRepository.save(clienteEntity);
				
	}
	
	private final UUID generarIdentificadorCliente() {
		
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			
			id = UUIDHelper.generate();
			var resultados = clienteRepository.findById(id);
			existeId = !resultados.isEmpty();
		}
		
		return id;
	}

}
