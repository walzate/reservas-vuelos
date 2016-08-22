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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

import co.com.payu.reservasvuelos.constants.Constants;

/**
 * Clase encargada de modelar la entidad Ruta
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:02:50 AM
 *
 */
@Entity
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
		@NamedQuery(name = "Ruta.findById", query = "SELECT r FROM Ruta r WHERE r.id = :id"),
		@NamedQuery(name = "Ruta.findByAeropuertoOrigen", query = "SELECT r FROM Ruta r WHERE r.aeropuertoOrigen = :aeropuertoOrigen"),
		@NamedQuery(name = "Ruta.findByAeropuertoDestino", query = "SELECT r FROM Ruta r WHERE r.aeropuertoDestino = :aeropuertoDestino"),
		@NamedQuery(name = "Ruta.findByDuracion", query = "SELECT r FROM Ruta r WHERE r.duracion = :duracion") })
public class Ruta implements Serializable {

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
	 * Aeropuerdo desde donde se inicia el vuelo
	 */
	@Basic(optional = false)
	@Column(name = "aeropuerto_origen")
	private String aeropuertoOrigen;
	/**
	 * Aeropuerto desde donde se finaliza el vuelo
	 */
	@Basic(optional = false)
	@Column(name = "aeropuerto_destino")
	private String aeropuertoDestino;
	/**
	 * Duración del vuelo
	 */
	@Basic(optional = false)
	@Column(name = "duracion")
	@DateTimeFormat(pattern = Constants.TIME_FORMAT)
	@Temporal(TemporalType.TIME)
	private Date duracion;
	/**
	 * Vuelos asociados
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
	private List<Vuelo> vueloList;
	/**
	 * Representación del vuelo en String
	 */
	@Transient
	private String nombreAMostrar;

	/**
	 * Método constructor de la clase Ruta.java
	 */
	public Ruta() {
	}

	/**
	 * Método constructor de la clase Ruta.java
	 * 
	 * @param id
	 */
	public Ruta(Integer id) {
		this.id = id;
	}

	/**
	 * Método constructor de la clase Ruta.java
	 * 
	 * @param id
	 * @param aeropuertoOrigen
	 * @param aeropuertoDestino
	 * @param duracion
	 */
	public Ruta(Integer id, String aeropuertoOrigen, String aeropuertoDestino, Date duracion) {
		this.id = id;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.duracion = duracion;
	}

	/**
	 * Método que retorna el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método que establece el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable aeropuertoOrigen
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @return the aeropuertoOrigen
	 */
	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	/**
	 * Método que establece el valor de la variable aeropuertoOrigen
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @param aeropuertoOrigen
	 *            the aeropuertoOrigen to set
	 */
	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	/**
	 * Método que retorna el valor de la variable aeropuertoDestino
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @return the aeropuertoDestino
	 */
	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	/**
	 * Método que establece el valor de la variable aeropuertoDestino
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @param aeropuertoDestino
	 *            the aeropuertoDestino to set
	 */
	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	/**
	 * Método que retorna el valor de la variable duracion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @return the duracion
	 */
	public Date getDuracion() {
		return duracion;
	}

	/**
	 * Método que establece el valor de la variable duracion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:14:05 AM
	 * @param duracion
	 *            the duracion to set
	 */
	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	/**
	 * Método que retorna el valor de la variable vueloList
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @return the vueloList
	 */
	@XmlTransient
	public List<Vuelo> getVueloList() {
		return vueloList;
	}

	/**
	 * Método que establece el valor de la variable vueloList
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @param vueloList
	 *            the vueloList to set
	 */
	public void setVueloList(List<Vuelo> vueloList) {
		this.vueloList = vueloList;
	}

	/**
	 * Método que retorna el valor de la variable nombreAMostrar
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 9:32:56 AM
	 * @return the nombreAMostrar
	 */
	public String getNombreAMostrar() {
		String resultado = aeropuertoOrigen + "-" + aeropuertoDestino + " " + duracion;
		nombreAMostrar = resultado;
		return nombreAMostrar;
	}

	/**
	 * Método que establece el valor de la variable nombreAMostrar
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 9:32:56 AM
	 * @param nombreAMostrar
	 *            the nombreAMostrar to set
	 */
	public void setNombreAMostrar(String nombreAMostrar) {
		this.nombreAMostrar = nombreAMostrar;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
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
