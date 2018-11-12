package com.ads.activosfijos.dataAccessLayer.impl;

import com.ads.activosfijos.bussinesLayer.exception.ActivoException;
import com.ads.activosfijos.dataAccessLayer.IActivoService;
import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.Area;
import com.ads.activosfijos.entityLayer.Persona;
import com.ads.activosfijos.entityLayer.dto.*;
import com.ads.activosfijos.entityLayer.mapper.IActivoMapper;
import com.ads.activosfijos.entityLayer.mapper.IAreaMapper;
import com.ads.activosfijos.entityLayer.mapper.IPersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
@Service("activoService")
public class ActivoService extends AbstractService implements IActivoService {
    @Autowired
    private IActivoMapper activoMapper;
    @Autowired
    private IPersonaMapper personaMapper;
    @Autowired
    private IAreaMapper areaMapper;

    @Override
    @Transactional
    public Integer saveActivo(ActivoDTO activoDto) {
        Activo activo = activoMapper.activoDTOToActivo(activoDto);
        em.persist(activo);
        em.flush();
        return activo.getIdactivo();
    }

    @Override
    public List<ActivoConsultaDTO> getActivos() {
        String query = "SELECT activo.idactivo,activo.nombre, activo.descripcion, activo.serial, activo.numero_interno, activo.valor_compra,activo.fecha_compra, activo.fecha_baja, " +
                "caract.peso,caract.alto,caract.ancho,caract.largo,caract.color,estado.descripcion estado, tipo.descripcion tipo, " +
                "CASE " +
                "WHEN dueno.tipo = 'persona' THEN persona.descripcion " +
                "ELSE area.descripcion " +
                "END  as asignado " +
                "FROM activos_fijos.activo activo " +
                "LEFT JOIN activos_fijos.caracteristicas caract ON activo.idactivo=caract.idactivo " +
                "LEFT JOIN activos_fijos.estado estado ON activo.idestado=estado.idestado " +
                "LEFT JOIN activos_fijos.tipo tipo ON activo.idtipo=tipo.idtipo " +
                "LEFT JOIN activos_fijos.dueno dueno ON activo.iddueno=dueno.iddueno " +
                "LEFT JOIN activos_fijos.persona persona ON dueno.idpa=persona.idpersona " +
                "LEFT JOIN activos_fijos.area area ON dueno.idpa=area.idarea";
        Query q = em.createNativeQuery(query,ActivoConsultaDTO.class);
        List<ActivoConsultaDTO> lista = q.getResultList();
        return lista;
    }

    @Override
    @Transactional
    public void updateActivo(ActivoDTO activoDto, Integer id) {
        Activo activo = activoMapper.activoDTOToActivo(activoDto);
        activo.setIdactivo(id);
        em.merge(activo);
        em.flush();
    }

    @Override
    public List<ActivoConsultaDTO> getActivosByParameter(BusquedaDTO busqueda) {
        String query = "SELECT activo.idactivo,activo.nombre, activo.descripcion, activo.serial, activo.numero_interno, activo.valor_compra,activo.fecha_compra, activo.fecha_baja, " +
                "caract.peso,caract.alto,caract.ancho,caract.largo,caract.color,estado.descripcion estado, tipo.descripcion tipo, " +
                "CASE " +
                "WHEN dueno.tipo = 'persona' THEN persona.descripcion " +
                "ELSE area.descripcion " +
                "END  as asignado " +
                "FROM activos_fijos.activo activo " +
                "LEFT JOIN activos_fijos.caracteristicas caract ON activo.idactivo=caract.idactivo " +
                "LEFT JOIN activos_fijos.estado estado ON activo.idestado=estado.idestado " +
                "LEFT JOIN activos_fijos.tipo tipo ON activo.idtipo=tipo.idtipo " +
                "LEFT JOIN activos_fijos.dueno dueno ON activo.iddueno=dueno.iddueno " +
                "LEFT JOIN activos_fijos.persona persona ON dueno.idpa=persona.idpersona " +
                "LEFT JOIN activos_fijos.area area ON dueno.idpa=area.idarea " +
                "WHERE activo.idtipo = IFNULL(?,activo.idtipo) " +
                "AND DATE(activo.fecha_compra) = IFNULL(?,DATE(activo.fecha_compra)) " +
                "AND activo.serial = IFNULL(?,activo.serial)";
        Query q = em.createNativeQuery(query,ActivoConsultaDTO.class);
        q.setParameter(1,busqueda.getIdtipo());
        q.setParameter(2,busqueda.getFechaCompra());
        q.setParameter(3,busqueda.getSerial());
        List<ActivoConsultaDTO> lista = q.getResultList();
        return lista;
    }

    @Override
    public List<PersonaDTO> getPersonas() {
        TypedQuery<Persona> query = em.createNamedQuery("Persona.findAll",Persona.class);
        List<Persona> lista = query.getResultList();
        List<PersonaDTO> listaDto = new ArrayList<>();
        for (Persona persona:lista) {
            listaDto.add(personaMapper.personaToPersonaDTO(persona));
        }
        return listaDto;
    }

    @Override
    public List<AreaDTO> getAreas() {
        TypedQuery<Area> query = em.createNamedQuery("Area.findAll",Area.class);
        List<Area> lista = query.getResultList();
        List<AreaDTO> listaDto = new ArrayList<>();
        for (Area area:lista) {
            listaDto.add(areaMapper.areaToAreaDTO(area));
        }
        return listaDto;
    }

    @Override
    @Transactional
    public void updateSerialBaja(SerialDTO dto, Integer id) {
        TypedQuery<Activo> query = em.createNamedQuery("Activo.findByIdactivo",Activo.class);
        query.setParameter("idactivo",id);
        Activo activo = query.getSingleResult();
        if (activo.getFechaCompra().after(dto.getFechaBaja())){
            throw new ActivoException("La fecha de baja no puede ser antes que la fecha de compra");
        }
        activo.setFechaBaja(dto.getFechaBaja());
        activo.setSerial(dto.getSerial());
        em.merge(activo);
        em.flush();
    }
}
