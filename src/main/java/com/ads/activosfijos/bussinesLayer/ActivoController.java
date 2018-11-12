package com.ads.activosfijos.bussinesLayer;

import com.ads.activosfijos.bussinesLayer.exception.ActivoException;
import com.ads.activosfijos.dataAccessLayer.IActivoService;
import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
            throw new ActivoException("El id del activo no puede ser nulo");
        }
        serviceActivo.updateActivo(activo,activoId);
        LOG.info("Se ha actualizado el activo " + activoId);
        return new ResponseEntity<>("Activo actualizado correctamente", HttpStatus.OK);
    }

    /**
     * Método para buscar archivos por fecha, tipo y serial
     *
     * @param busqueda {@link BusquedaDTO}
     * @return lista de activos
     */
    @RequestMapping(value = "/buscarPorParametros",method = RequestMethod.POST)
    public ResponseEntity<?> findByDate(@Valid @RequestBody BusquedaDTO busqueda) {
        if (busqueda == null || (busqueda.getFechaCompra()==null && busqueda.getIdtipo()==null && (busqueda.getSerial() == null || busqueda.getSerial().isEmpty()))){
            throw new ActivoException("Ingrese un parametro de busqueda");
        }
        List<ActivoConsultaDTO> listaActivos = serviceActivo.getActivosByParameter(busqueda);
        if (listaActivos.size()==0){
            LOG.warn("No se encontraron activos  getActivos");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        LOG.info("Se encontraron "+listaActivos.size()+" activos");
        return new ResponseEntity<>(listaActivos,HttpStatus.OK);
    }

    /**
     * Método para listar areas o personas
     *
     * @param param {@link String}
     * @return lista areas o personas
     */
    @RequestMapping(value = "/listar/{param}",method = RequestMethod.GET)
    public ResponseEntity<?> findAreaPerson(@PathVariable("param") String param) {
        if (param == null ||  param.isEmpty()){
            throw new ActivoException("Ingrese un parametro de busqueda (personas,areas)");
        }
        switch(param)
        {
            case "personas":
                List<PersonaDTO> listaPersonas = serviceActivo.getPersonas();
                if (listaPersonas.size()==0){
                    LOG.warn("No se encontraron personas getPersonas");
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
                LOG.info("Se encontraron "+listaPersonas.size()+" personas");
                return new ResponseEntity<>(listaPersonas,HttpStatus.OK);
            case "areas":
                List<AreaDTO> listaAreas = serviceActivo.getAreas();
                if (listaAreas.size()==0){
                    LOG.warn("No se encontraron areas getAreas");
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
                LOG.info("Se encontraron "+listaAreas.size()+" areas");
                return new ResponseEntity<>(listaAreas,HttpStatus.OK);
            default:
                LOG.warn("No se ingreso un parametro correcto");
                throw new ActivoException("Ingrese un parametro de busqueda correcto (personas,areas)");
        }
    }

    /**
     * Método para buscar archivos por fecha, tipo y serial
     *
     * @param busqueda {@link BusquedaDTO}
     * @return lista de activos
     */
    @RequestMapping(value = "/darDeBaja/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> updateSerial(@PathVariable("id") Integer id,@Valid @RequestBody SerialDTO busqueda) {
        if (busqueda == null || (busqueda.getFechaBaja()==null && busqueda.getSerial()==null)){
            throw new ActivoException("Ingrese un parametro de busqueda");
        }
        serviceActivo.updateSerialBaja(busqueda,id);
        LOG.info("Se actualizo el activo "+id+" correctamente");
        return new ResponseEntity<>("Activo actualizado correctamente",HttpStatus.OK);
    }
}
