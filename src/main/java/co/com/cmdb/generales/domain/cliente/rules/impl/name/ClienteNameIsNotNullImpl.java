package co.com.cmdb.generales.domain.cliente.rules.impl.name;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameIsNotNullRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNameIsNotNullImpl implements ClienteNameIsNotNullRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteNameIsNotNullImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw ClienteNameIsNullException.create(messageCatalogService);		}
		
	}
	
	

}
