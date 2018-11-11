package com.ads.activosfijos.entityLayer.mapper;

import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
@Mapper(componentModel = "spring")
public interface IActivoMapper {
    @InheritInverseConfiguration
    ActivoDTO activoToActivoDTO(Activo activo);

    @Mappings({
            @Mapping(source = "tipoDueno", target = "iddueno.tipo"),
            @Mapping(source = "idDueno", target = "iddueno.iddueno"),
            @Mapping(source = "idestado", target = "idestado.idestado"),
            @Mapping(source = "idtipo", target = "idtipo.idtipo"),
            @Mapping(source = "peso", target = "caracteristicas.peso"),
            @Mapping(source = "alto", target = "caracteristicas.alto"),
            @Mapping(source = "ancho", target = "caracteristicas.ancho"),
            @Mapping(source = "largo", target = "caracteristicas.largo"),
            @Mapping(source = "color", target = "caracteristicas.color")
    })
    Activo activoDTOToActivo(ActivoDTO activo);
}
