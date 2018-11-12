package com.ads.activosfijos.bussinesLayer.exception;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 * Clase exception para manejar excepciones del API
 */
public class ActivoException extends RuntimeException{
    private static final long serialVersionUID = -7100172815005092057L;

    private final String message;

    public ActivoException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
