package co.com.cmdb.generales.application.primaryports.interactor.tipodocumento.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;
import co.com.cmdb.generales.application.primaryports.interactor.tipodocumento.TipoDocumentoInteractor;
import co.com.cmdb.generales.application.primaryports.mapper.TipoDocumentoDtoMapper;
import co.com.cmdb.generales.application.usecase.tipodocumento.TipoDocumento;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
@Transactional
public class TipoDocumentoInteractorImpl implements TipoDocumentoInteractor{
	
	private TipoDocumento tipoDocumentoUseCase;
	private MessageCatalogService messageCatalogService;
	
	public TipoDocumentoInteractorImpl(final TipoDocumento tipoDocumentoUseCase, final MessageCatalogService messageCatalogService) {
		
		this.tipoDocumentoUseCase = tipoDocumentoUseCase;
		this.messageCatalogService = messageCatalogService;
		
	}

	@Override
	public List<TipoDocumentoDTO> execute(TipoDocumentoDTO data) {

		try {
			
			var tipoDocumentoDomain = TipoDocumentoDtoMapper.INSTANCE.toDomain(data);
			
			var resultado = tipoDocumentoUseCase.execute(tipoDocumentoDomain);
			
			
			return TipoDocumentoDtoMapper.INSTANCE.toDtoCollection(resultado);
			
		} catch (CmdbException exception) {
			
			var userMessage = messageCatalogService.getMessage("errorConsultTc");
			throw DataCmdbException.create(userMessage);
			
		}
		
	}

}
