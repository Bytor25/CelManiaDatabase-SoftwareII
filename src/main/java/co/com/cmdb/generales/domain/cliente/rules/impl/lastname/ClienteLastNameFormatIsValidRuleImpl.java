package co.com.cmdb.generales.domain.cliente.rules.impl.lastname;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.lastname.ClienteLastNameFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.lastname.ClienteLastNameFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteLastNameFormatIsValidRuleImpl implements ClienteLastNameFormatIsValidRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteLastNameFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	
	@Override
	public void execute(String data) {
		if(!TextHelper.isOnlyLetters(data)) {
			throw ClienteLastNameFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
