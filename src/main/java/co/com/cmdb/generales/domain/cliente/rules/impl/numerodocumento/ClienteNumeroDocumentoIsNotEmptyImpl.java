package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoIsNotEmptyImpl implements ClienteNumeroDocumentoIsNotEmptyRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoIsNotEmptyImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	
	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw ClienteNumeroDocumentoIsEmptyException.create(messageCatalogService);
		}
		
	}

}
