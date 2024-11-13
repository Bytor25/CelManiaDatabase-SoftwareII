package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoFormatIsValidImpl implements ClienteNumeroDocumentoFormatIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoFormatIsValidImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}	
	
	
	@Override
	public void execute(String data) {
		if(!TextHelper.isOnlyNumbers(data)) {
			throw ClienteNumeroDocumentoFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
