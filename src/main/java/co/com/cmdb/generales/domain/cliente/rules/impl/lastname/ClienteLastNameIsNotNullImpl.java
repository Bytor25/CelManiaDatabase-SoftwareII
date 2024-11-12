package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotNullRule;

@Service
public class ClienteLastNameIsNotNullImpl implements ClienteLastNameIsNotNullRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw ClienteLastNameIsNullException.create();
		}
		
	}

}
