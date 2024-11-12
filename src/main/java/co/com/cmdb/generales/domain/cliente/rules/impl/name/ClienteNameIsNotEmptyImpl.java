package co.com.cmdb.generales.domain.cliente.rules.impl.name;


import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotEmptyRule;

@Service
public class ClienteNameIsNotEmptyImpl implements ClienteNameIsNotEmptyRule {

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)){
			throw ClienteNameIsEmptyException.create();
		}
		
	}

}
