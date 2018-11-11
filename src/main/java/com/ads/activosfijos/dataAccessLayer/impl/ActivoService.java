package com.ads.activosfijos.dataAccessLayer.impl;

import com.ads.activosfijos.dataAccessLayer.IActivoService;
import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;
import com.ads.activosfijos.entityLayer.mapper.IActivoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Activo> getActivos() {
        TypedQuery<Activo> query = em.createNamedQuery("Activo.findAll",Activo.class);
        List<Activo> lista = query.getResultList();
        return lista;
    }
}
