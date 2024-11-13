package co.com.cmdb.generales.domain.cliente.rules.impl.name;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameLengthIsNotValidException;

import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameLengthIsValidRule;

@Service
public class ClienteNameLengthIsValidImpl implements ClienteNameLengthIsValidRule {

	@Override
	public void execute(String data) {
		if(!TextHelper.hasMinLength(data, 1)) {
			throw ClienteNameLengthIsNotValidException.create(1);
		}else {
			if(!TextHelper.hasMaxLength(data, 60)) {
				throw ClienteNameLengthIsNotValidException.create(2);
			}
			}
		}
		
	}
