package co.com.cmdb.generales.application.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;

@Repository
public interface ClienteRepositoryCustom {
	
		List<ClienteEntity> selectByFilter(ClienteEntity filter);

}
