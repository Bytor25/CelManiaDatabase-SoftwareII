package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoFormatIsValidRule;

@Service
public class ClienteNumeroDocumentoFormatIsValidImpl implements ClienteNumeroDocumentoFormatIsValidRule{

	@Override
	public void execute(String data) {
		if(!TextHelper.isOnlyNumbers(data)) {
			throw ClienteNumeroDocumentoFormatIsNotValidException.create();
		}
		
	}

}
