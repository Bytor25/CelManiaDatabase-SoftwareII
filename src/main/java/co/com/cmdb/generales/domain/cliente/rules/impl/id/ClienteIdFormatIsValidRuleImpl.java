package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdFormatIsValidRule;

public class ClienteIdFormatIsValidRuleImpl implements ClienteIdFormatIsValidRule{

	@Override
	public void execute(UUID data) {
		
		if(UUIDHelper.isDefault(data)) {
			throw ClienteIdFormatIsNotValidException.create();
		}
		
	}

}
