package com.ads.activosfijos.entityLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fabiani Lozano
 */
@Entity
@Cacheable(false)
@Table(name = "tipo")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
        , @NamedQuery(name = "Tipo.findByIdtipo", query = "SELECT t FROM Tipo t WHERE t.idtipo = :idtipo")
        , @NamedQuery(name = "Tipo.findByDescripcion", query = "SELECT t FROM Tipo t WHERE t.descripcion = :descripcion")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo")
    private Integer idtipo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipo")
    private Collection<Activo> activoCollection;

    public Tipo() {
    }

    public Tipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Activo> getActivoCollection() {
        return activoCollection;
    }

    public void setActivoCollection(Collection<Activo> activoCollection) {
        this.activoCollection = activoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ads.activosfijos.entityLayer.Tipo[ idtipo=" + idtipo + " ]";
    }

}
