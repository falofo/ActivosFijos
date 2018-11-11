package com.ads.activosfijos.bussinesLayer;

import com.ads.activosfijos.dataAccessLayer.IActivoService;
import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.ActivoConsultaDTO;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
@RestController
@RequestMapping("/api/v1/activo")
public class ActivoController {
    final static Logger LOG = Logger.getLogger(ActivoController.class);
    @Autowired
    IActivoService serviceActivo;
    /**
     * Método para guardar activos
     *
     * @param activo {@link Activo} a activo
     * @return id activo guardada
     */
    @RequestMapping(value = "/guardarActivo",method = RequestMethod.POST)
    public ResponseEntity<?> saveActivo(@Valid @RequestBody ActivoDTO activo) {

        Integer idOrder = serviceActivo.saveActivo(activo);
        LOG.info("Se ha creado el activo " + idOrder);
        return new ResponseEntity<>(idOrder, HttpStatus.OK);
    }

    /**
     * Método para consultar Activos
     *
     * @return List {@link Activo} listado de todos los activos
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getActivos() {

        List<ActivoConsultaDTO> listaActivos = serviceActivo.getActivos();
        if (listaActivos.size()==0){
            LOG.warn("No se encontraron activos  getActivos");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        LOG.info("Se encontraron "+listaActivos.size()+" activos");
        return new ResponseEntity<>(listaActivos,HttpStatus.OK);
    }

    /**
     * Método para actualizar activos
     *
     * @param activo {@link Activo} a guardar
     * @return id activo guardada
     */
    @RequestMapping(value = "/actualizarActivo/{activoId}",method = RequestMethod.POST)
    public ResponseEntity<?> updateActivo(@PathVariable("activoId") Integer activoId,@Valid @RequestBody ActivoDTO activo) {
        if (activoId == null){
            return new ResponseEntity("El id del activo no puede ser nulo", HttpStatus.BAD_REQUEST);
        }
        serviceActivo.updateActivo(activo,activoId);
        LOG.info("Se ha actualizado el activo " + activoId);
        return new ResponseEntity<>("Activo actualizado correctamente", HttpStatus.OK);
    }
}
