package com.ads.activosfijos.entityLayer.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
public class ActivoDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idactivo;
    @NotNull
    @Size(min = 1, max = 45)
    private String nombre;
    @Size(max = 200)
    private String descripcion;
    @NotNull
    @Size(min = 1, max = 45)
    private String serial;
    @NotNull
    private Integer numeroInterno;
    @NotNull
    private Double valorCompra;
    @NotNull
    private Date fechaCompra;
    private Double peso;
    private Double alto;
    private Double ancho;
    private Double largo;
    private String color;
    @NotNull
    private TipoDueno tipoDueno;
    @NotNull
    private Integer idDueno;
    @NotNull
    private Integer idestado;
    @NotNull
    private Integer idtipo;

    public Integer getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Integer idactivo) {
        this.idactivo = idactivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(Integer numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoDueno getTipoDueno() {
        return tipoDueno;
    }

    public void setTipoDueno(TipoDueno tipoDueno) {
        this.tipoDueno = tipoDueno;
    }

    public Integer getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Integer idDueno) {
        this.idDueno = idDueno;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public enum TipoDueno {
        PERSONA("persona"),
        AREA("area")
        ;

        private final String text;

        TipoDueno(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
