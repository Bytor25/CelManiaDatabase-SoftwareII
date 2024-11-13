package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoDoesExistRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoDoesExistImpl implements ClienteNumeroDocumentoDoesExistRule {

	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoDoesExistImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		
	}

}
