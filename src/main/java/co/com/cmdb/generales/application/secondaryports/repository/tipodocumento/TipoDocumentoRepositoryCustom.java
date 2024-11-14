package co.com.cmdb.generales.application.secondaryports.repository.tipodocumento;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;

@Repository
public interface TipoDocumentoRepositoryCustom {
	
	List<TipoDocumentoEntity> selectByFilter(TipoDocumentoEntity filter);

}
