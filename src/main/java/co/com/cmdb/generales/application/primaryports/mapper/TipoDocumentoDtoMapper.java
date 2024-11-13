package co.com.cmdb.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

@Mapper(componentModel = "spring")
public interface TipoDocumentoDtoMapper {

    TipoDocumentoDtoMapper INSTANCE = Mappers.getMapper(TipoDocumentoDtoMapper.class);

    @Mapping(source = "identificador", target = "identificador")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoDomain toDomain(TipoDocumentoDTO dto);

    @Mapping(source = "identificador", target = "identificador")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoDTO toDto(TipoDocumentoDomain domain);

    List<TipoDocumentoDTO> toDtoCollection(List<TipoDocumentoDomain> domains);

}
