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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author fawkes
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findById", query = "SELECT v FROM Vuelo v WHERE v.id = :id"),
    @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vuelo.findByHoraInicio", query = "SELECT v FROM Vuelo v WHERE v.horaInicio = :horaInicio")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @JoinColumn(name = "id_avion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Avion avion;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ruta ruta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<PasajeroPorVuelo> pasajeroPorVueloList;
    @Transient
    private String nombreAMostrar;

    public Vuelo() {
    }

    public Vuelo(Integer id) {
        this.id = id;
    }

    public Vuelo(Integer id, Date fecha, Date horaInicio) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
	 * Método que retorna el valor de la variable avion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:47:06 AM
	 * @return the avion
	 */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * Método que establece el valor de la variable avion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:47:06 AM
	 * @param avion the avion to set
	 */
	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	/**
	 * Método que retorna el valor de la variable ruta
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:47:06 AM
	 * @return the ruta
	 */
	public Ruta getRuta() {
		return ruta;
	}

	/**
	 * Método que establece el valor de la variable ruta
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:47:06 AM
	 * @param ruta the ruta to set
	 */
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	
	
	/**
	 * Método que retorna el valor de la variable nombreAMostrar
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 11:37:09 AM
	 * @return the nombreAMostrar
	 */
	public String getNombreAMostrar() {
		String resultado = fecha + " " + horaInicio + " "+ ruta.getAeropuertoOrigen() + "-"+ ruta.getAeropuertoDestino();
		nombreAMostrar = resultado;
		return nombreAMostrar;
	}

	/**
	 * Método que establece el valor de la variable nombreAMostrar
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 11:37:09 AM
	 * @param nombreAMostrar the nombreAMostrar to set
	 */
	public void setNombreAMostrar(String nombreAMostrar) {
		this.nombreAMostrar = nombreAMostrar;
	}

	
	
	/**
	 * Método que retorna el valor de la variable pasajeroPorVueloList
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 3:15:59 PM
	 * @return the pasajeroPorVueloList
	 */
	@XmlTransient
	public List<PasajeroPorVuelo> getPasajeroPorVueloList() {
		return pasajeroPorVueloList;
	}

	/**
	 * Método que establece el valor de la variable pasajeroPorVueloList
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 3:15:59 PM
	 * @param pasajeroPorVueloList the pasajeroPorVueloList to set
	 */
	public void setPasajeroPorVueloList(List<PasajeroPorVuelo> pasajeroPorVueloList) {
		this.pasajeroPorVueloList = pasajeroPorVueloList;
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
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.payu.model.Vuelo[ id=" + id + " ]";
    }
    
}
