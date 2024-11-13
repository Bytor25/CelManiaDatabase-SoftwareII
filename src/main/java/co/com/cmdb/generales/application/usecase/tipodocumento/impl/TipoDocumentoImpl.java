package co.com.cmdb.generales.application.usecase.tipodocumento.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.tipodocumento.TipoDocumentoRepository;
import co.com.cmdb.generales.application.usecase.tipodocumento.TipoDocumento;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

@Service
public class TipoDocumentoImpl implements TipoDocumento{
	
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public TipoDocumentoImpl(TipoDocumentoRepository tipoDocumentoRepository) {
		
		
		this.tipoDocumentoRepository = tipoDocumentoRepository;
		
	}

	@Override
	public List<TipoDocumentoDomain> execute(TipoDocumentoDomain data) {
		
		var tipoDocumentoEntity = TipoDocumentoEntityMapper.INSTANCE.toEntity(data);
		
		var resultados = tipoDocumentoRepository.selectByFilter(tipoDocumentoEntity);
		
		
		return TipoDocumentoEntityMapper.INSTANCE.toDomainCollection(resultados);
	
	}

	
	
	
	
	
	
	
	
	

}
