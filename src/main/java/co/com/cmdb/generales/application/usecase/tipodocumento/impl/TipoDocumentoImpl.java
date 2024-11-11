package co.com.cmdb.generales.application.usecase.tipodocumento.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.TipoDocumentoRepository;
import co.com.cmdb.generales.application.usecase.tipodocumento.TipoDocumento;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

@Service
public class TipoDocumentoImpl implements TipoDocumento{
	
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public TipoDocumentoImpl(TipoDocumentoRepository tipoDocumentoRepository) {
		
		if(ObjectHelper.isNull(tipoDocumentoRepository)) {
			
			var userMessage = "Hubo un error a la hora de consultar los tipos de documento";
			throw DataCmdbException.create(userMessage);
		
		}
		
		this.tipoDocumentoRepository = tipoDocumentoRepository;
		
	}

	@Override
	public List<TipoDocumentoDomain> execute(TipoDocumentoDomain data) {
		
		var tipoDocumentoEntity = TipoDocumentoEntityMapper.INSTANCE.toEntity(data);
		var resultados = tipoDocumentoRepository.selectByFilter(tipoDocumentoEntity);
		return TipoDocumentoEntityMapper.INSTANCE.toDomainCollection(resultados);
	
	}

	
	
	
	
	
	
	
	
	

}
