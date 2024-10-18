package co.com.cmdb.generales.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID>, ClienteRepositoryCustom {
	
	

}
