package co.com.cmdb.generales.domain.cliente.rules.impl.tipodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoDoesNotExistRule;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteTipoDocumentoDoesNotExistImpl implements  ClienteTipoDocumentoDoesNotExistRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteTipoDocumentoDoesNotExistImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(TipoDocumentoDomain data) {
		
	}

}
