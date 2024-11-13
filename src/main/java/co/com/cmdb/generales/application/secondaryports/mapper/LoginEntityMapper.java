package co.com.cmdb.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.domain.login.LoginDomain;

@Mapper(componentModel = "spring")
public interface LoginEntityMapper {

    LoginEntityMapper INSTANCE = Mappers.getMapper(LoginEntityMapper.class);

    @Mapping(target = "id", source = "id") 
    LoginDomain toDomain(LoginEntity loginEntity);

    @Mapping(target = "id", source = "id") 
    LoginEntity toEntity(LoginDomain loginDomain);
    
    List<LoginDomain> toDomainCollection(List<LoginEntity> loginEntityList);
}
