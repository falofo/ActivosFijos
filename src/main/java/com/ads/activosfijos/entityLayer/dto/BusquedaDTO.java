package com.ads.activosfijos.entityLayer.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
public class BusquedaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Date fechaCompra;
    private Integer idtipo;
    private String serial;

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
