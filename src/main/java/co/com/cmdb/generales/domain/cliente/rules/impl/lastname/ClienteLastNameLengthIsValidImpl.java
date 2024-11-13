package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameLengthIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteLastNameLengthIsValidImpl implements ClienteLastNameLengthIsValidRule {

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteLastNameLengthIsValidImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.hasMinLength(data, 1)) {
			throw ClienteLastNameLengthIsNotValidException.create(1,messageCatalogService);
		}else {
			if(TextHelper.hasMaxLength(data, 100)) {
				throw ClienteLastNameLengthIsNotValidException.create(2,messageCatalogService);
			}
		}
		
	}

}
