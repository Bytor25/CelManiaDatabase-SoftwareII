package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoDoesNotExistRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoDoesNotExistImpl implements ClienteNumeroDocumentoDoesNotExistRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoDoesNotExistImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		
	}

}
