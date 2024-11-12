package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoRangeIsValidRule;

@Service
public class ClienteTelefonoRangeIsValidImpl implements ClienteTelefonoRangeIsValidRule{

	@Override
	public void execute(Long data) {
		if(NumericHelper.validarRangoTelefono(data));
		
	}

}
