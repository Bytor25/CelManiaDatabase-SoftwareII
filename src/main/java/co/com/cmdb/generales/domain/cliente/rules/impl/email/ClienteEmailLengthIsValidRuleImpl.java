package co.com.cmdb.generales.domain.cliente.rules.impl.email;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.email.ClienteEmailLengthIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.email.ClienteEmailLengthIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteEmailLengthIsValidRuleImpl implements ClienteEmailLengthIsValidRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteEmailLengthIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {
		if(TextHelper.hasMinLength(data,6)) {
			var typeUserMessage = 1;
			throw ClienteEmailLengthIsNotValidException.create(typeUserMessage,messageCatalogService);
		}
		
		if(TextHelper.hasMaxLength(data, 255)) {
			var typeUserMessage = 2;
			throw ClienteEmailLengthIsNotValidException.create(typeUserMessage,messageCatalogService);
		}
		
	}

}
