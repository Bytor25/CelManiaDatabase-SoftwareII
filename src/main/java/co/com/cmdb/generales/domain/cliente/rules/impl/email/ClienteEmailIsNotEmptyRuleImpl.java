package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailIsNotEmptyRule;

@Service
public class ClienteEmailIsNotEmptyRuleImpl implements ClienteEmailIsNotEmptyRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteEmailIsEmptyException.create();
		
		}
		
	}

}
