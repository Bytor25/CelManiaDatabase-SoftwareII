package co.com.cmdb.generales.domain.cliente.rules.impl.numerodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento.ClienteNumeroDocumentoLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.numerodocumento.ClienteNumeroDocumentoLengthIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteNumeroDocumentoLengthIsValidImpl implements ClienteNumeroDocumentoLengthIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteNumeroDocumentoLengthIsValidImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {

		if(!TextHelper.hasMinLength(data, 1)) {
			throw ClienteNumeroDocumentoLengthIsNotValidException.create(2, messageCatalogService);
		}else {
			if(!TextHelper.hasMaxLength(data, 10)) {
				throw ClienteNumeroDocumentoLengthIsNotValidException.create(1,messageCatalogService);
			}

		}		
	}
}
