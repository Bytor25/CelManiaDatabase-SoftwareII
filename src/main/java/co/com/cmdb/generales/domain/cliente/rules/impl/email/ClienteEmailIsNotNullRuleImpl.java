package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailIsNotNullRule;

@Service
public class ClienteEmailIsNotNullRuleImpl implements ClienteEmailIsNotNullRule{

	@Override
	public void execute(String data) {
		if(ObjectHelper.isNull(data)) {
			throw ClienteEmailIsNullException.create();
		}
		
	}

}
