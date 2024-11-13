package co.com.cmdb.generales.domain.cliente.rules.impl.id;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.id.ClienteIdFormatIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.id.ClienteIdFormatIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


@Service
public class ClienteIdFormatIsValidRuleImpl implements ClienteIdFormatIsValidRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteIdFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(UUID data) {
		
		if(UUIDHelper.isDefault(data)) {
			throw ClienteIdFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
