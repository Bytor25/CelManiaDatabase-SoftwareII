package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoIsNotEmptyRule;

@Service
public class ClienteNumeroDocumentoIsNotEmptyImpl implements ClienteNumeroDocumentoIsNotEmptyRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteNumeroDocumentoIsEmptyException.create();
		}
		
	}

}
