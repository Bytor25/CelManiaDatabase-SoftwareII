package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteEmailFormatIsValidRuleImpl implements ClienteEmailFormatIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteEmailFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(!TextHelper.isValidEmailFormat(data)) {
			throw ClienteEmailFormatIsNotValidException.create(messageCatalogService);
		}
	}

}
