package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoDoesNotExisteRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteTelefonoDoesNotExisteImpl implements ClienteTelefonoDoesNotExisteRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteTelefonoDoesNotExisteImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Long data) {
		// TODO Auto-generated method stub
		
	}

}
