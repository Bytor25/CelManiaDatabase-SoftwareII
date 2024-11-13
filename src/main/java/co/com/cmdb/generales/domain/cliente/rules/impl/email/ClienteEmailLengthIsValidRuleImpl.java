package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailLengthIsValidRule;

@Service
public class ClienteEmailLengthIsValidRuleImpl implements ClienteEmailLengthIsValidRule{

	@Override
	public void execute(String data) {
		if(!TextHelper.hasMinLength(data,6)) {
			var typeUserMessage = 1;
			throw ClienteEmailLengthIsNotValidException.create(typeUserMessage);
		}
		
		if(!TextHelper.hasMaxLength(data, 255)) {
			var typeUserMessage = 2;
			throw ClienteEmailLengthIsNotValidException.create(typeUserMessage);
		}
		
	}

}
