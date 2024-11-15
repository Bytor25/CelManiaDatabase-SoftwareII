package co.com.cmdb.generales.domain.cliente.rules.impl.tipodocumento;


import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento.ClienteTipoDocumentoIdIsEmptyException;
import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoIdIsNotEmptyRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteTipoDocumentoIdIsNotEmptyRuleImpl implements ClienteTipoDocumentoIdIsNotEmptyRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteTipoDocumentoIdIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Integer data) {
		if(NumericHelper.isNullOrEmpty(data) || ObjectHelper.isNull(data)) {
			throw ClienteTipoDocumentoIdIsEmptyException.create(messageCatalogService);
		}
		
	}

}
