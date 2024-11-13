package co.com.cmdb.generales.domain.cliente.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.rules.ClienteTelefonoUniqueForNumeroDocumentoIsValidRule;

@Service
public class ClienteTelefonoUniqueForNumeroDocumentoIsValidRuleImpl implements ClienteTelefonoUniqueForNumeroDocumentoIsValidRule {

	@Override
	public void execute(ClienteDomain data) {
		
	}

}
