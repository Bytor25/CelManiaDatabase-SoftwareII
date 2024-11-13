package co.com.cmdb.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.domain.login.LoginDomain;

@Mapper(componentModel = "spring")
public interface LoginDtoMapper {
	

    LoginDtoMapper INSTANCE = Mappers.getMapper(LoginDtoMapper.class);

    LoginDomain toDomain(LoginDTO loginDTO);

    LoginDTO toDTO(LoginDomain loginDomain);

    List<LoginDTO> toDtoCollection(List<LoginDomain> loginDomainList);
}
