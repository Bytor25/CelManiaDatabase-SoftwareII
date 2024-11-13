package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteLastNameIsNotEmptyImpl implements ClienteLastNameIsNotEmptyRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteLastNameIsNotEmptyImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteLastNameIsEmptyException.create(messageCatalogService);
		}
		
	}

}
