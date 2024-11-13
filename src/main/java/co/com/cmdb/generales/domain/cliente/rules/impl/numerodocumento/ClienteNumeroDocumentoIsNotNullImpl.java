package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoIsNullException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoIsNotNullRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoIsNotNullImpl implements ClienteNumeroDocumentoIsNotNullRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoIsNotNullImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw ClienteNumeroDocumentoIsNullException.create(messageCatalogService);
		}
		
	}

}
