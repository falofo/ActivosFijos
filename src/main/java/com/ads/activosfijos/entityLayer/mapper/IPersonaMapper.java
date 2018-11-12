package com.ads.activosfijos.entityLayer.mapper;

import com.ads.activosfijos.entityLayer.Persona;
import com.ads.activosfijos.entityLayer.dto.PersonaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
@Mapper(componentModel = "spring")
public interface IPersonaMapper {


    @InheritInverseConfiguration
    PersonaDTO personaToPersonaDTO(Persona persona);

    @Mappings({
            @Mapping(source = "persona", target = "descripcion")
    })
    Persona personaDTOToPersona(PersonaDTO  personaDTO);
}
