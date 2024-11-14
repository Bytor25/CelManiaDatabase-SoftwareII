package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.telefono.ClienteTelefonoFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteTelefonoFormatIsValidRuleImpl implements ClienteTelefonoFormatIsValidRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteTelefonoFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Long data) {
		if(!TextHelper.isOnlyNumbers(data.toString())) {
			throw ClienteTelefonoFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
