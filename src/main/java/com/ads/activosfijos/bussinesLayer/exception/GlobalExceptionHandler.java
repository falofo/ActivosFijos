package com.ads.activosfijos.bussinesLayer.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * Global Exception handler for all exceptions.
     */
    @ExceptionHandler
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
        // general exception
        LOG.error("Exception: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response =
                new AbstractMap.SimpleEntry<>("message", "Unable to process this request.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Global Exception handler for CrossRideException.
     */
    @ExceptionHandler(ActivoException.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleCrossException(Exception exception) {
        // general exception
        LOG.debug("ControlledException: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response =
                new AbstractMap.SimpleEntry<>("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Global Exception handler for MethodArgumentNotValidException.
     */
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity
    handleMethodArgumentNotValidException( MethodArgumentNotValidException exception ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult()));
    }*/
}
