package co.com.cmdb.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;

@Mapper(componentModel = "Spring" ) 
public interface ClienteEntityMapper {
	
	ClienteEntityMapper INSTACE = Mappers.getMapper(ClienteEntityMapper.class);
	
	ClienteEntity toEntity(ClienteDomain domain);
	
	List<ClienteEntity> toEntityCollection(List<ClienteDomain> domainCollection);

}
