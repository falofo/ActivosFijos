package com.ads.activosfijos.entityLayer.dto;

import java.io.Serializable;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
public class PersonaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String persona;

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
}
