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

@Service
@Transactional
public class TipoDocumentoInteractorImpl implements TipoDocumentoInteractor{
	
	private TipoDocumento tipoDocumentoUseCase;
	
	public TipoDocumentoInteractorImpl(TipoDocumento tipoDocumentoUseCase) {
		
		this.tipoDocumentoUseCase = tipoDocumentoUseCase;
		
	}

	@Override
	public List<TipoDocumentoDTO> execute(TipoDocumentoDTO data) {

		try {
			
			var tipoDocumentoDomain = TipoDocumentoDtoMapper.INSTANCE.toDomain(data);
			var resultado = tipoDocumentoUseCase.execute(tipoDocumentoDomain);
			return TipoDocumentoDtoMapper.INSTANCE.toDtoCollection(resultado);
			
		} catch (CmdbException exception) {
			
			var userMessage = "Error consultando los Tipos de documentos";
			throw DataCmdbException.create(userMessage);
			
		}
		
	}

}
