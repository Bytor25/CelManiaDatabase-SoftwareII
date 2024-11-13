package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;


@Service
public class ClienteIdIsNotEmptyImpl implements ClienteIdIsNotEmptyRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteIdIsNotEmptyImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw ClienteIdIsEmptyException.create(messageCatalogService);
		}
		
	}

}
