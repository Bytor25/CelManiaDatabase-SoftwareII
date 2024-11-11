package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdIsNotEmptyRule;

public class ClienteIdIsNotEmptyImpl implements ClienteIdIsNotEmptyRule{

	
	@Override
	public void execute(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw ClienteIdIsEmptyException.create();
		}
		
	}

}
