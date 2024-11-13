package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.telefono.ClienteTelefonoFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoFormatIsValidRule;

@Service
public class ClienteTelefonoFormatIsValidRuleImpl implements ClienteTelefonoFormatIsValidRule{

	@Override
	public void execute(Long data) {
		if(!TextHelper.isOnlyNumbers(data.toString())) {
			throw ClienteTelefonoFormatIsNotValidException.create();
		}
		
	}

}
