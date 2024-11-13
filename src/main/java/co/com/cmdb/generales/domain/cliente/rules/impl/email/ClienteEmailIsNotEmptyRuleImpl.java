package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteEmailIsNotEmptyRuleImpl implements ClienteEmailIsNotEmptyRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteEmailIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteEmailIsEmptyException.create(messageCatalogService);
		
		}
		
	}

}
