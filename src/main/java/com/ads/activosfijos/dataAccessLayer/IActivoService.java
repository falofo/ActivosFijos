package com.ads.activosfijos.dataAccessLayer;

import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.ActivoConsultaDTO;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;

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
     * @return @return List {@link Activo} listado de todos los Activos
     */
    List<ActivoConsultaDTO> getActivos();

    /**
     * Método para actualizar activos
     * @param activo {@link Activo}
     */
    void updateActivo(ActivoDTO activo, Integer id);
}
