package co.com.cmdb.generales.domain.cliente.rules.impl.tipodocumento;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;
import co.com.cmdb.generales.application.secondaryports.repository.tipodocumento.TipoDocumentoRepository;
import co.com.cmdb.generales.domain.cliente.exceptions.tipodocumento.ClienteTipoDocumentoDoesExistException;
import co.com.cmdb.generales.domain.cliente.rules.tipodocumento.ClienteTipoDocumentoDoesExistRule;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteTipoDocumentoDoesExistRuleImpl implements ClienteTipoDocumentoDoesExistRule{

	private TipoDocumentoRepository tipoDocumentoRepository;
	//private MessageCatalogService messageCatalogService;
	
	public ClienteTipoDocumentoDoesExistRuleImpl(MessageCatalogService messageCatalogService, TipoDocumentoRepository tipoDocumentoRepository) {
		//this.messageCatalogService = messageCatalogService;
		this.tipoDocumentoRepository = tipoDocumentoRepository;
	}
	
	@Override
	public void execute(TipoDocumentoDomain data) {
		var tipoDocumentoEntity = TipoDocumentoEntity.create().setIdentificador(data.getIdentificador());
		
		var resultado = tipoDocumentoRepository.selectByFilter(tipoDocumentoEntity);
		
		if(resultado.isEmpty()) {
			
			throw ClienteTipoDocumentoDoesExistException.create();
			
		}
		
	}
}
