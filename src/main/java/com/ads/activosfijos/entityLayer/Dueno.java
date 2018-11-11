/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.activosfijos.entityLayer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fabiani Lozano
 */
@Entity
@Table(name = "dueno")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Dueno.findAll", query = "SELECT d FROM Dueno d")
        , @NamedQuery(name = "Dueno.findByIddueno", query = "SELECT d FROM Dueno d WHERE d.iddueno = :iddueno")
        , @NamedQuery(name = "Dueno.findByTipo", query = "SELECT d FROM Dueno d WHERE d.tipo = :tipo")
        , @NamedQuery(name = "Dueno.findByIdpa", query = "SELECT d FROM Dueno d WHERE d.idpa = :idpa")})
public class Dueno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddueno")
    private Integer iddueno;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "idpa")
    private String idpa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddueno")
    private Collection<Activo> activoCollection;

    public Dueno() {
    }

    public Dueno(Integer iddueno) {
        this.iddueno = iddueno;
    }

    public Integer getIddueno() {
        return iddueno;
    }

    public void setIddueno(Integer iddueno) {
        this.iddueno = iddueno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdpa() {
        return idpa;
    }

    public void setIdpa(String idpa) {
        this.idpa = idpa;
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
        hash += (iddueno != null ? iddueno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dueno)) {
            return false;
        }
        Dueno other = (Dueno) object;
        if ((this.iddueno == null && other.iddueno != null) || (this.iddueno != null && !this.iddueno.equals(other.iddueno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ads.activosfijos.entityLayer.Dueno[ iddueno=" + iddueno + " ]";
    }

}
