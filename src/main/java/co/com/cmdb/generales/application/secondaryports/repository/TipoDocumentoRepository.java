package co.com.cmdb.generales.application.secondaryports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer>, TipoDocumentoRepositoryCustom {
	
	

}
