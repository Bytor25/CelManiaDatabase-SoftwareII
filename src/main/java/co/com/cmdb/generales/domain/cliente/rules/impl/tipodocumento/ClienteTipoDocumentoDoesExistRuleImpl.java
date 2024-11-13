package co.com.cmdb.generales.domain.cliente.rules.impl.tipodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoDoesExistRule;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;
import co.com.cmdb.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ClienteTipoDocumentoDoesExistRuleImpl implements ClienteTipoDocumentoDoesExistRule{

	
	private MessageCatalogService messageCatalogService;
	
	public ClienteTipoDocumentoDoesExistRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;

	}
	
	@Override
	public void execute(TipoDocumentoDomain data) {

	}
}
