package co.com.cmdb.generales.domain.cliente.rules.impl.name;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameFormatIsValidRule;

@Service
public class ClienteNameFormatIsValidRuleImpl implements ClienteNameFormatIsValidRule{

	@Override
	public void execute(String data) {
		if(!TextHelper.isOnlyLetters(data)) {
			throw ClienteNameFormatIsNotValidException.create();
		}
		
	}

}
