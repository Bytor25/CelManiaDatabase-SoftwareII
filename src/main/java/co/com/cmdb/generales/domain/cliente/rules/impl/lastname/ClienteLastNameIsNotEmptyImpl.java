package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotEmptyRule;

@Service
public class ClienteLastNameIsNotEmptyImpl implements ClienteLastNameIsNotEmptyRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteLastNameIsEmptyException.create();
		}
		
	}

}
