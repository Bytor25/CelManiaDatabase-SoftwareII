package co.com.cmdb.generales.application.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;

@Service
public interface TipoDocumentoRepositoryCustom {
	
	List<TipoDocumentoEntity> selectByFilter(TipoDocumentoEntity filter);

}
