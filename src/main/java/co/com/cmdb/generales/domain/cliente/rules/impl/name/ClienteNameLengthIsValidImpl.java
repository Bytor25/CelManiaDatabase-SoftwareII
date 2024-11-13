package co.com.cmdb.generales.domain.cliente.rules.impl.name;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.name.ClienteNameLengthIsNotValidException;

import co.com.cmdb.generales.domain.cliente.rules.name.ClienteNameLengthIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteNameLengthIsValidImpl implements ClienteNameLengthIsValidRule {

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteNameLengthIsValidImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(String data) {

		if(!TextHelper.hasMinLength(data, 1)) {
			throw ClienteNameLengthIsNotValidException.create(1,messageCatalogService);
		}else {
			if(!TextHelper.hasMaxLength(data, 60)) {
				throw ClienteNameLengthIsNotValidException.create(2,messageCatalogService);

			}
			}
		}
		
	}
