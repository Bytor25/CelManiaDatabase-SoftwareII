package co.com.cmdb.generales.application.secondaryports.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;
import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;

@Mapper(componentModel = "spring")
public interface TipoDocumentoEntityMapper {

    TipoDocumentoEntityMapper INSTANCE = Mappers.getMapper(TipoDocumentoEntityMapper.class);

    // Mapeo de TipoDocumentoEntity a TipoDocumentoDomain
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoDomain toDomain(TipoDocumentoEntity entity);

    // Mapeo de TipoDocumentoDomain a TipoDocumentoEntity
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    TipoDocumentoEntity toEntity(TipoDocumentoDomain domain);

    // Mapeo de lista de entidades a lista de dominios
    List<TipoDocumentoDomain> toDomainCollection(List<TipoDocumentoEntity> entities);

    // Mapeo de lista de dominios a lista de entidades
    List<TipoDocumentoEntity> toEntityCollection(List<TipoDocumentoDomain> domains);
}

