package com.ads.activosfijos.entityLayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fabiani Lozano
 */
@Entity
@Table(name = "activo")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a")
        , @NamedQuery(name = "Activo.findByIdactivo", query = "SELECT a FROM Activo a WHERE a.idactivo = :idactivo")
        , @NamedQuery(name = "Activo.findByNombre", query = "SELECT a FROM Activo a WHERE a.nombre = :nombre")
        , @NamedQuery(name = "Activo.findByDescripcion", query = "SELECT a FROM Activo a WHERE a.descripcion = :descripcion")
        , @NamedQuery(name = "Activo.findBySerial", query = "SELECT a FROM Activo a WHERE a.serial = :serial")
        , @NamedQuery(name = "Activo.findByNumeroInterno", query = "SELECT a FROM Activo a WHERE a.numeroInterno = :numeroInterno")
        , @NamedQuery(name = "Activo.findByValorCompra", query = "SELECT a FROM Activo a WHERE a.valorCompra = :valorCompra")
        , @NamedQuery(name = "Activo.findByFechaCompra", query = "SELECT a FROM Activo a WHERE a.fechaCompra = :fechaCompra")
        , @NamedQuery(name = "Activo.findByFechaBaja", query = "SELECT a FROM Activo a WHERE a.fechaBaja = :fechaBaja")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivo")
    private Integer idactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_interno")
    private int numeroInterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    private double valorCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @OneToOne(mappedBy = "activo", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Caracteristicas caracteristicas;
    @JoinColumn(name = "iddueno", referencedColumnName = "iddueno")
    @ManyToOne(optional = false)
    private Dueno iddueno;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;
    @JoinColumn(name = "idtipo", referencedColumnName = "idtipo")
    @ManyToOne(optional = false)
    private Tipo idtipo;

    public Activo() {
    }

    public Activo(Integer idactivo) {
        this.idactivo = idactivo;
    }

    public Activo(Integer idactivo, String nombre, String serial, int numeroInterno, double valorCompra, Date fechaCompra) {
        this.idactivo = idactivo;
        this.nombre = nombre;
        this.serial = serial;
        this.numeroInterno = numeroInterno;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
    }

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

    public int getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(int numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        if (caracteristicas == null) {
            if (this.caracteristicas != null) {
                this.caracteristicas.setActivo(null);
            }
        }
        else {
            caracteristicas.setActivo(this);
        }
        this.caracteristicas = caracteristicas;
    }

    public Dueno getIddueno() {
        return iddueno;
    }

    public void setIddueno(Dueno iddueno) {
        this.iddueno = iddueno;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Tipo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipo idtipo) {
        this.idtipo = idtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivo != null ? idactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.idactivo == null && other.idactivo != null) || (this.idactivo != null && !this.idactivo.equals(other.idactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ads.activosfijos.entityLayer.Activo[ idactivo=" + idactivo + " ]";
    }

}
