package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.telefono.ClienteTelefonoIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteTelefonoIsNotEmptyImpl implements ClienteTelefonoIsNotEmptyRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteTelefonoIsNotEmptyImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Long data) {

		if(TextHelper.isEmpty(data.toString())) {
			throw ClienteTelefonoIsEmptyException.create(messageCatalogService);

		}
		
	}

}
