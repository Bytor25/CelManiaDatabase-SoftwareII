package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.telefono.ClienteTelefonoIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoIsNotEmptyRule;

@Service
public class ClienteTelefonoIsNotEmptyImpl implements ClienteTelefonoIsNotEmptyRule{

	@Override
	public void execute(Long data) {
		if(TextHelper.isEmpty(data.toString())) {
			throw ClienteTelefonoIsEmptyException.create();
		}
		
	}

}
