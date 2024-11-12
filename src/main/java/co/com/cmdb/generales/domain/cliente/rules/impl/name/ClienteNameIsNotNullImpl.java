package co.com.cmdb.generales.domain.cliente.rules.impl.name;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotNullRule;

@Service
public class ClienteNameIsNotNullImpl implements ClienteNameIsNotNullRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw ClienteNameIsNullException.create();		}
		
	}
	
	

}
