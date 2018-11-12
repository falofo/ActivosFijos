package com.ads.activosfijos.entityLayer.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
public class UserDTO implements Serializable{
    @NotNull
    private String user;
    @NotNull
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
