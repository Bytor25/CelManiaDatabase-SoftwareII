package co.com.cmdb.generales.application.usecase.tipodocumento.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.tipodocumento.TipoDocumentoRepository;
import co.com.cmdb.generales.application.usecase.tipodocumento.TipoDocumento;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


@Service
public class TipoDocumentoImpl implements TipoDocumento{
	
	private TipoDocumentoRepository tipoDocumentoRepository;
	private MessageCatalogService messageCatalogService;
	
	public TipoDocumentoImpl(TipoDocumentoRepository tipoDocumentoRepository, final MessageCatalogService messageCatalogService) {
		
		if(ObjectHelper.isNull(tipoDocumentoRepository)) {
			
			var userMessage = messageCatalogService.getMessage("errorConsultaTD");
			throw DataCmdbException.create(userMessage);
		
		}


		
		this.tipoDocumentoRepository = tipoDocumentoRepository;
		this.messageCatalogService = messageCatalogService;
		
	}

	@Override
	public List<TipoDocumentoDomain> execute(TipoDocumentoDomain data) {
		
		var tipoDocumentoEntity = TipoDocumentoEntityMapper.INSTANCE.toEntity(data);
		
		var resultados = tipoDocumentoRepository.selectByFilter(tipoDocumentoEntity);
		
		
		return TipoDocumentoEntityMapper.INSTANCE.toDomainCollection(resultados);
	
	}

	
	
	
	
	
	
	
	
	

}
