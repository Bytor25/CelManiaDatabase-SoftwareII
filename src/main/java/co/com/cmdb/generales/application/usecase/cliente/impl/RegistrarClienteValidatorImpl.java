package co.com.cmdb.generales.application.usecase.cliente.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.usecase.cliente.RegistrarClienteRuleValidator;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdDoesNotExistRule;

@Service
public final class RegistrarClienteValidatorImpl implements RegistrarClienteRuleValidator {
	
	@Autowired
	private ClienteIdDoesNotExistRule clienteIdDoesNotExist;

	@Override
	public void validate(ClienteDomain data) {
		

		
	}

}
