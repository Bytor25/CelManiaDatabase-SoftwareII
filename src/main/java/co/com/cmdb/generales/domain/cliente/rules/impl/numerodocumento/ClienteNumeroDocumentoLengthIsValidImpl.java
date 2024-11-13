package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoLengthIsValidRule;

@Service
public class ClienteNumeroDocumentoLengthIsValidImpl implements ClienteNumeroDocumentoLengthIsValidRule{

	@Override
	public void execute(String data) {
		if(!TextHelper.hasMinLength(data, 10)) {
			throw ClienteNumeroDocumentoLengthIsNotValidException.create(1);
		}else if(!TextHelper.hasMaxLength(data, 10)) {
			throw ClienteNameLengthIsNotValidException.create(2);
		}		
	}

}
