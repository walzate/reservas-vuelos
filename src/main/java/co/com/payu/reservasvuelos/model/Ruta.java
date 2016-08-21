/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.payu.reservasvuelos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author fawkes
 */
@Entity
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findById", query = "SELECT r FROM Ruta r WHERE r.id = :id"),
    @NamedQuery(name = "Ruta.findByAeropuertoOrigen", query = "SELECT r FROM Ruta r WHERE r.aeropuertoOrigen = :aeropuertoOrigen"),
    @NamedQuery(name = "Ruta.findByAeropuertoDestino", query = "SELECT r FROM Ruta r WHERE r.aeropuertoDestino = :aeropuertoDestino"),
    @NamedQuery(name = "Ruta.findByDuracion", query = "SELECT r FROM Ruta r WHERE r.duracion = :duracion")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "aeropuerto_origen")
    private String aeropuertoOrigen;
    @Basic(optional = false)
    @Column(name = "aeropuerto_destino")
    private String aeropuertoDestino;
    @Basic(optional = false)
    @Column(name = "duracion")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<Vuelo> vueloList;

    public Ruta() {
    }

    public Ruta(Integer id) {
        this.id = id;
    }

    public Ruta(Integer id, String aeropuertoOrigen, String aeropuertoDestino, Date duracion) {
        this.id = id;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.payu.model.Ruta[ id=" + id + " ]";
    }
    
}
