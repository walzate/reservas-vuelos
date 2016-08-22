package co.com.payu.reservasvuelos.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase encargada de modelar la entidad de unión entre pasajeros y vuelos
 * (reservas)
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:02:50 AM
 *
 */
@Entity
@Table(name = "pasajero_por_vuelo")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PasajeroPorVuelo.findAll", query = "SELECT p FROM PasajeroPorVuelo p"),
		@NamedQuery(name = "PasajeroPorVuelo.findById", query = "SELECT p FROM PasajeroPorVuelo p WHERE p.id = :id") })
public class PasajeroPorVuelo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identificador único de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	/**
	 * El pasajero que se relaciona con el vuelo
	 */
	@JoinColumn(name = "id_pasajero", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Pasajero pasajero;
	/**
	 * El vuelo asociado al pasajero
	 */
	@JoinColumn(name = "id_vuelo", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Vuelo vuelo;

	/**
	 * Método constructor de la clase PasajeroPorVuelo.java
	 */
	public PasajeroPorVuelo() {
	}

	/**
	 * Método constructor de la clase PasajeroPorVuelo.java
	 * 
	 * @param id
	 */
	public PasajeroPorVuelo(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:11:04 AM
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método que establece el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:11:04 AM
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable pasajero
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @return the pasajero
	 */
	public Pasajero getPasajero() {
		return pasajero;
	}

	/**
	 * Método que establece el valor de la variable pasajero
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @param pasajero
	 *            the pasajero to set
	 */
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	/**
	 * Método que retorna el valor de la variable vuelo
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @return the vuelo
	 */
	public Vuelo getVuelo() {
		return vuelo;
	}

	/**
	 * Método que establece el valor de la variable vuelo
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @param vuelo
	 *            the vuelo to set
	 */
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PasajeroPorVuelo)) {
			return false;
		}
		PasajeroPorVuelo other = (PasajeroPorVuelo) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "co.com.payu.reservasvuelos.model.PasajeroPorVuelo[ id=" + id + " ]";
	}

}
