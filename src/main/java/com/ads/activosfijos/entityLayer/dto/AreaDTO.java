package com.ads.activosfijos.entityLayer.dto;

import java.io.Serializable;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
public class AreaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String area;
    private String ciudad;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
