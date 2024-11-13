package co.com.cmdb.generales.application.usecase.cliente.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.usecase.cliente.RegistrarClienteRuleValidator;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.rules.ClienteEmailUniqueForNumeroDocumentoIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.ClienteTelefonoUniqueForNumeroDocumentoIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.ClienteTipoDocumentoYNumeroDocumentoIsUniqueRule;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailIsNotNullRule;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailLengthIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdDoesNotExistRule;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotNullRule;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameLengthIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotNullRule;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameLengthIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoIsNotNullRule;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoLengthIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoFormatIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoIsNotEmptyRule;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoRangeIsValidRule;
import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoDoesExistRule;
import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoDoesNotExistRule;
import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoIdIsNotEmptyRule;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

@Service
public final class RegistrarClienteValidatorImpl implements RegistrarClienteRuleValidator {
	
	@Autowired
	private ClienteIdDoesNotExistRule clienteIdDoesNotExist;
	@Autowired
	private ClienteIdFormatIsValidRule clienteIdFormatIsValid;
	@Autowired
	private ClienteIdIsNotEmptyRule clienteIdIsNotEmpty;
	
	@Autowired
	private ClienteNumeroDocumentoFormatIsValidRule clienteNumeroDocumentoFormatIsValid;
	@Autowired
	private ClienteNumeroDocumentoIsNotEmptyRule clienteNumeroDocumentoIsNotEmpty;
	@Autowired
	private ClienteNumeroDocumentoIsNotNullRule clienteNumeroDocumentoIsNotNull;
	@Autowired
	private ClienteNumeroDocumentoLengthIsValidRule clienteNumeroDocumentoLengthIsValid;
	
	
	@Autowired 
	private ClienteNameFormatIsValidRule clienteNameFormatIsValid;
	@Autowired
	private ClienteNameIsNotEmptyRule clienteNameIsNotEmpty;
	@Autowired
	private ClienteNameIsNotNullRule clienteNameIsNotNull;
	@Autowired
	private ClienteNameLengthIsValidRule clienteNameLengthIsValid;
	
	@Autowired
	private ClienteLastNameFormatIsValidRule clienteLastNameFormatIsValid;
	@Autowired
	private ClienteLastNameIsNotEmptyRule clienteLastNameIsNotEmpty;
	@Autowired
	private ClienteLastNameIsNotNullRule clienteLastNameIsNotNull;
	@Autowired
	private ClienteLastNameLengthIsValidRule clienteLastNameLengthIsValid;
	
	@Autowired
	private ClienteEmailFormatIsValidRule clienteEmailFormatIsValid;
	@Autowired
	private ClienteEmailIsNotEmptyRule clienteEmailIsNotEmpty;
	@Autowired
	private ClienteEmailIsNotNullRule clienteEmailIsNotNull;
	@Autowired
	private ClienteEmailLengthIsValidRule clienteEmailLengthIsValid;
	
	@Autowired
	private ClienteTelefonoFormatIsValidRule clienteTelefonoFormatIsValid;
	@Autowired
	private ClienteTelefonoIsNotEmptyRule clienteTelefonoIsNotEmpty;
	@Autowired
	private ClienteTelefonoRangeIsValidRule clienteTelefonoRangeIsValid;
	
	@Autowired
	private ClienteTipoDocumentoDoesExistRule clienteTipoDocumentoDoesExist;
	@Autowired
	private ClienteTipoDocumentoDoesNotExistRule clienteTipoDocumentoDoesNotExist;
	@Autowired
	private ClienteTipoDocumentoIdIsNotEmptyRule clienteTipoDocumentoIdIsNotEmpty;
	
	@Autowired
	private ClienteEmailUniqueForNumeroDocumentoIsValidRule clienteEmailUniqueForNumeroDocumento;
	@Autowired
	private ClienteTipoDocumentoYNumeroDocumentoIsUniqueRule clienteTipoDocumentoYNumeroDocumentoIsUnique;
	@Autowired
	private ClienteTelefonoUniqueForNumeroDocumentoIsValidRule clienteTelefonoUniqueForNumeroDocumento;
	
	

	@Override
	public void validate(ClienteDomain data) {
		
		validateRulesRelatedWithId(data.getId());
		
		validateRulesRelatedWithNumeroDocumento(data.getNumeroDocumento());
		
		clienteTipoDocumentoYNumeroDocumentoIsUnique.execute(data);
		
		validateRulesRelatedWithTipoDocumento(data.getTipoDocumento());
		validateRulesRelatedWithName(data.getNombre());
		validateRulesRelatedWithLastName(data.getApellidos());
		validateRulesRelatedWithCorreo(data.getCorreo());
		
		clienteEmailUniqueForNumeroDocumento.execute(data);
		
		validateRulesRelatedWithTelefono(data.getTelefono());	
		
		clienteTelefonoUniqueForNumeroDocumento.execute(data);
	}
	
	private void validateRulesRelatedWithId(final UUID id) {
		clienteIdIsNotEmpty.execute(id);
		clienteIdFormatIsValid.execute(id);
		clienteIdDoesNotExist.execute(id);
	}
	
	private void validateRulesRelatedWithNumeroDocumento(final String numeroDocumento) {
		clienteNumeroDocumentoFormatIsValid.execute(numeroDocumento);;
		clienteNumeroDocumentoIsNotEmpty.execute(numeroDocumento);;
		clienteNumeroDocumentoIsNotNull.execute(numeroDocumento);;
		clienteNumeroDocumentoLengthIsValid.execute(numeroDocumento);;
	}
	private void validateRulesRelatedWithName(final String name) {
		clienteNameIsNotNull.execute(name);
		clienteNameIsNotEmpty.execute(name);
		clienteNameFormatIsValid.execute(name);
		clienteNameLengthIsValid.execute(name);
	}
	private void validateRulesRelatedWithLastName(final String lastName) {
		clienteLastNameIsNotNull.execute(lastName);
		clienteLastNameIsNotEmpty.execute(lastName);
		clienteLastNameFormatIsValid.execute(lastName);
		clienteLastNameLengthIsValid.execute(lastName);
	}
	private void validateRulesRelatedWithCorreo(final String correo) {
		clienteEmailFormatIsValid.execute(correo);
		clienteEmailIsNotEmpty.execute(correo);
		clienteEmailIsNotNull.execute(correo);
		clienteEmailLengthIsValid.execute(correo);
	}
	
	private void validateRulesRelatedWithTelefono(final long telefono) {
		clienteTelefonoIsNotEmpty.execute(telefono);
		clienteTelefonoFormatIsValid.execute(telefono);
		clienteTelefonoRangeIsValid.execute(telefono);
	}
	
	private void validateRulesRelatedWithTipoDocumento(final TipoDocumentoDomain tipoDocumentoDomain) {
		clienteTipoDocumentoDoesExist.execute(tipoDocumentoDomain);
		clienteTipoDocumentoDoesNotExist.execute(tipoDocumentoDomain);
		clienteTipoDocumentoIdIsNotEmpty.execute(tipoDocumentoDomain.getId());
	}

}
