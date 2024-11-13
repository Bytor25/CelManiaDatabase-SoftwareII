package co.com.cmdb.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

@Mapper
public interface ClienteDtoMapper {

    ClienteDtoMapper INSTANCE = Mappers.getMapper(ClienteDtoMapper.class);

    // Mapeo de ClienteDTO a ClienteDomain
    @Mapping(source = "tipoDocumento", target = "tipoDocumento", qualifiedByName = "mapTipoDocumentoDtoToDomain")
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")  // Generar un nuevo UUID
    @Mapping(source = "estado", target = "estado")
    ClienteDomain toDomain(ClienteDTO dto);

    // Mapeo de ClienteDomain a ClienteDTO
    @Mapping(source = "tipoDocumento", target = "tipoDocumento", qualifiedByName = "mapTipoDocumentoDomainToDto")
    @Mapping(source = "estado", target = "estado")
    ClienteDTO toDto(ClienteDomain domain);

    // Método personalizado para mapear TipoDocumentoDTO a TipoDocumentoDomain
    @Named("mapTipoDocumentoDtoToDomain")
    default TipoDocumentoDomain mapTipoDocumentoDtoToDomain(TipoDocumentoDTO tipoDocumentoDTO) {
        // Crear un TipoDocumentoDomain usando los valores del DTO
        return TipoDocumentoDomain.create(tipoDocumentoDTO.getIdentificador(), tipoDocumentoDTO.getNombre());
    }

    // Método personalizado para mapear TipoDocumentoDomain a TipoDocumentoDTO
    @Named("mapTipoDocumentoDomainToDto")
    default TipoDocumentoDTO mapTipoDocumentoDomainToDto(TipoDocumentoDomain tipoDocumentoDomain) {
        // Crear un TipoDocumentoDTO usando los valores del Domain
        return TipoDocumentoDTO.create(tipoDocumentoDomain.getIdentificador(), tipoDocumentoDomain.getNombre());
    }
    
    List<ClienteDTO> toDtoCollection(List<ClienteDomain> domains);
    
}
