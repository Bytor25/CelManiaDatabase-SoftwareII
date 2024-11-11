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

    // Mapeo de TipoDocumentoDTO a TipoDocumentoDomain
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoDomain toDomain(TipoDocumentoDTO dto);

    // Mapeo de TipoDocumentoDomain a TipoDocumentoDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoDTO toDto(TipoDocumentoDomain domain);

    // Mapeo de una lista de TipoDocumentoDomain a una lista de TipoDocumentoDTO
    List<TipoDocumentoDTO> toDtoCollection(List<TipoDocumentoDomain> domains);

    // Mapeo de una lista de TipoDocumentoDTO a una lista de TipoDocumentoDomain
    List<TipoDocumentoDomain> toDomainCollection(List<TipoDocumentoDTO> dtos);
}
