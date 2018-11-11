package com.ads.activosfijos.dataAccessLayer;

import com.ads.activosfijos.entityLayer.Activo;
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

}
