package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailFormatIsValidRule;
@Service
public class ClienteEmailFormatIsValidRuleImpl implements ClienteEmailFormatIsValidRule{

	@Override
	public void execute(String data) {
		if(!TextHelper.isValidEmailFormat(data)) {
			throw ClienteEmailFormatIsNotValidException.create();
		}
	}

}
