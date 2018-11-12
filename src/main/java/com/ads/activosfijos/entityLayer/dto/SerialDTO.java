package com.ads.activosfijos.entityLayer.dto;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
public class SerialDTO implements Serializable{
    private String serial;
    @Past
    private Date fechaBaja;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
