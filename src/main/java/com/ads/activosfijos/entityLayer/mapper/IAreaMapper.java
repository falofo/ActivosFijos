package com.ads.activosfijos.entityLayer.mapper;

import com.ads.activosfijos.entityLayer.Area;
import com.ads.activosfijos.entityLayer.dto.AreaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
@Mapper(componentModel = "spring")
public interface IAreaMapper {

    @InheritInverseConfiguration
    AreaDTO areaToAreaDTO(Area area);

    @Mappings({
            @Mapping(source = "area", target = "descripcion"),
            @Mapping(source = "ciudad", target = "idciudad.descripcion")
    })
    Area areaDTOToArea(AreaDTO  areaDTO);
}
