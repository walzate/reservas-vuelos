package co.com.payu.reservasvuelos.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase encargada de modelar la entidad Pasajero
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:02:50 AM
 *
 */
@Entity
@Table(name = "pasajero")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p"),
		@NamedQuery(name = "Pasajero.findById", query = "SELECT p FROM Pasajero p WHERE p.id = :id"),
		@NamedQuery(name = "Pasajero.findByNombre", query = "SELECT p FROM Pasajero p WHERE p.nombre = :nombre"),
		@NamedQuery(name = "Pasajero.findByDireccion", query = "SELECT p FROM Pasajero p WHERE p.direccion = :direccion"),
		@NamedQuery(name = "Pasajero.findByTelefono", query = "SELECT p FROM Pasajero p WHERE p.telefono = :telefono") })
public class Pasajero implements Serializable {

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
	 * Nombres y apellidos del pasajero
	 */
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	/**
	 * Dirección de vivienda del pasajero
	 */
	@Column(name = "direccion")
	private String direccion;
	/**
	 * Teléfono principal del pasajero
	 */
	@Column(name = "telefono")
	private String telefono;

	/**
	 * Método constructor de la clase Pasajero.java
	 */
	public Pasajero() {
	}

	/**
	 * Método constructor de la clase Pasajero.java
	 * 
	 * @param id
	 */
	public Pasajero(Integer id) {
		this.id = id;
	}

	/**
	 * Método constructor de la clase Pasajero.java
	 * 
	 * @param id
	 * @param nombre
	 */
	public Pasajero(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Método que retorna el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método que establece el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable nombre
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que establece el valor de la variable nombre
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que retorna el valor de la variable direccion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método que establece el valor de la variable direccion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método que retorna el valor de la variable telefono
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método que establece el valor de la variable telefono
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:08:44 AM
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

		if (!(object instanceof Pasajero)) {
			return false;
		}
		Pasajero other = (Pasajero) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "co.com.payu.model.Pasajero[ id=" + id + " ]";
	}

}
