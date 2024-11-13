package co.com.cmdb.generales.domain.cliente.rules.impl;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.cliente.rules.ClienteEmailUniqueForNumeroDocumentoIsValidRule;

@Service
public class ClienteEmailUniqueForNumeroDocumentoIsValidRuleImpl implements ClienteEmailUniqueForNumeroDocumentoIsValidRule {

	@Override
	public void execute(ClienteDomain data) {
		
	}

}
