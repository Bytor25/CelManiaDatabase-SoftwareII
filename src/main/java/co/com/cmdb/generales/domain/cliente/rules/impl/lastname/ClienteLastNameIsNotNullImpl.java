package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameIsNotNullRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteLastNameIsNotNullImpl implements ClienteLastNameIsNotNullRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteLastNameIsNotNullImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw ClienteLastNameIsNullException.create(messageCatalogService);
		}
		
	}

}
