package co.com.cmdb.generales.domain.cliente.rules.impl.name;


import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNameIsNotEmptyImpl implements ClienteNameIsNotEmptyRule {

	private MessageCatalogService messageCatalogService;
	
	public ClienteNameIsNotEmptyImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)){
			throw ClienteNameIsEmptyException.create(messageCatalogService);
		}
		
	}

}
