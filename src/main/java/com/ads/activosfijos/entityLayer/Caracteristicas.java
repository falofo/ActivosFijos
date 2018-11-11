package com.ads.activosfijos.entityLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fabiani Lozano
 */
@Entity
@Table(name = "caracteristicas")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Caracteristicas.findAll", query = "SELECT c FROM Caracteristicas c")
        , @NamedQuery(name = "Caracteristicas.findByIdcaracteristica", query = "SELECT c FROM Caracteristicas c WHERE c.idcaracteristica = :idcaracteristica")
        , @NamedQuery(name = "Caracteristicas.findByPeso", query = "SELECT c FROM Caracteristicas c WHERE c.peso = :peso")
        , @NamedQuery(name = "Caracteristicas.findByAlto", query = "SELECT c FROM Caracteristicas c WHERE c.alto = :alto")
        , @NamedQuery(name = "Caracteristicas.findByAncho", query = "SELECT c FROM Caracteristicas c WHERE c.ancho = :ancho")
        , @NamedQuery(name = "Caracteristicas.findByLargo", query = "SELECT c FROM Caracteristicas c WHERE c.largo = :largo")
        , @NamedQuery(name = "Caracteristicas.findByColor", query = "SELECT c FROM Caracteristicas c WHERE c.color = :color")})
public class Caracteristicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcaracteristica")
    private Integer idcaracteristica;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "alto")
    private Double alto;
    @Column(name = "ancho")
    private Double ancho;
    @Column(name = "largo")
    private Double largo;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivo", nullable = false)
    private Activo activo;

    public Caracteristicas() {
    }

    public Caracteristicas(Integer idcaracteristica) {
        this.idcaracteristica = idcaracteristica;
    }

    public Integer getIdcaracteristica() {
        return idcaracteristica;
    }

    public void setIdcaracteristica(Integer idcaracteristica) {
        this.idcaracteristica = idcaracteristica;
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

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaracteristica != null ? idcaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristicas)) {
            return false;
        }
        Caracteristicas other = (Caracteristicas) object;
        if ((this.idcaracteristica == null && other.idcaracteristica != null) || (this.idcaracteristica != null && !this.idcaracteristica.equals(other.idcaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ads.activosfijos.entityLayer.Caracteristicas[ idactivo=" + idcaracteristica + " ]";
    }

}
