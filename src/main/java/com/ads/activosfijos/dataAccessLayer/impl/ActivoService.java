package com.ads.activosfijos.dataAccessLayer.impl;

import com.ads.activosfijos.dataAccessLayer.IActivoService;
import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.ActivoConsultaDTO;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;
import com.ads.activosfijos.entityLayer.mapper.IActivoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
@Service("activoService")
public class ActivoService extends AbstractService implements IActivoService {
    @Autowired
    private IActivoMapper activoMapper;

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
}
