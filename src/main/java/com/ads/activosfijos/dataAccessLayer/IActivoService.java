package com.ads.activosfijos.dataAccessLayer;

import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.*;

import java.util.List;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
public interface IActivoService {

    /**
     * Método para guardar activos
     * @param activo {@link Activo}
     * @return id activo guardado
     */
    Integer saveActivo(ActivoDTO activo);

    /**
     * Método para obtener lista de activos
     * @return @return List {@link ActivoConsultaDTO} listado de todos los Activos
     */
    List<ActivoConsultaDTO> getActivos();

    /**
     * Método para actualizar activos
     * @param activo {@link Activo}
     */
    void updateActivo(ActivoDTO activo, Integer id);

    /**
     * Método para obtener lista de activos
     * @param busqueda {@link BusquedaDTO}
     * @return @return List {@link ActivoConsultaDTO} listado de todos los Activos
     */
    List<ActivoConsultaDTO> getActivosByParameter(BusquedaDTO busqueda);

    /**
     * Método para obtener lista de personas
     * @return @return List {@link PersonaDTO} listado de todas las personas
     */
    List<PersonaDTO> getPersonas();

    /**
     * Método para obtener lista de areas
     * @return @return List {@link AreaDTO} listado de todas las areas
     */
    List<AreaDTO> getAreas();

    /**
     * Método para dar de baja activos
     * @param dto {@link SerialDTO}
     * @param id {@link Integer}
     */
    void updateSerialBaja(SerialDTO dto, Integer id);
}
