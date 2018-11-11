package com.ads.activosfijos.entityLayer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fabiani Lozano
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
        , @NamedQuery(name = "Area.findByIdarea", query = "SELECT a FROM Area a WHERE a.idarea = :idarea")
        , @NamedQuery(name = "Area.findByDescripcion", query = "SELECT a FROM Area a WHERE a.descripcion = :descripcion")
        , @NamedQuery(name = "Area.findByIdciudad", query = "SELECT a FROM Area a WHERE a.idciudad = :idciudad")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idarea")
    private int idarea;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudad")
    private Integer idciudad;

    public Area() {
    }

    public Area(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public Area(Integer idciudad, int idarea) {
        this.idciudad = idciudad;
        this.idarea = idarea;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idciudad != null ? idciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idciudad == null && other.idciudad != null) || (this.idciudad != null && !this.idciudad.equals(other.idciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ads.activosfijos.entityLayer.Area[ idciudad=" + idciudad + " ]";
    }

}
