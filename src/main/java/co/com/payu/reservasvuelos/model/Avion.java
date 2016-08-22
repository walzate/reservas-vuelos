package co.com.payu.reservasvuelos.model;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase encargada de modelar la entidad Avion
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:02:50 AM
 *
 */
@Entity
@Table(name = "avion")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a"),
		@NamedQuery(name = "Avion.findById", query = "SELECT a FROM Avion a WHERE a.id = :id"),
		@NamedQuery(name = "Avion.findByModelo", query = "SELECT a FROM Avion a WHERE a.modelo = :modelo"),
		@NamedQuery(name = "Avion.findByCapacidad", query = "SELECT a FROM Avion a WHERE a.capacidad = :capacidad"),
		@NamedQuery(name = "Avion.findByFabricante", query = "SELECT a FROM Avion a WHERE a.fabricante = :fabricante") })
public class Avion implements Serializable {

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
	 * El año correspondiente al modelo del avión
	 */
	@Column(name = "modelo")
	private Integer modelo;
	/**
	 * Capacidad del avión en términos del número de pasajeros
	 */
	@Basic(optional = false)
	@Column(name = "capacidad")
	private int capacidad;
	/**
	 * El nombre del fabricante del avión
	 */
	@Column(name = "fabricante")
	private String fabricante;
	/**
	 * Vuelos asociados al avión
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
	private List<Vuelo> vueloList;
	/**
	 * Representación del vuelo en String
	 */
	@Transient
	private String nombreAMostrar;

	/**
	 * Método constructor de la clase Avion.java
	 */
	public Avion() {
	}

	/**
	 * Método constructor de la clase Avion.java
	 * 
	 * @param id
	 */
	public Avion(Integer id) {
		this.id = id;
	}

	/**
	 * Método constructor de la clase Avion.java
	 * 
	 * @param id
	 * @param capacidad
	 */
	public Avion(Integer id, int capacidad) {
		this.id = id;
		this.capacidad = capacidad;
	}

	/**
	 * Método que retorna el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método que establece el valor de la variable id
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable modelo
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @return the modelo
	 */
	public Integer getModelo() {
		return modelo;
	}

	/**
	 * Método que establece el valor de la variable modelo
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	/**
	 * Método que retorna el valor de la variable capacidad
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Método que establece el valor de la variable capacidad
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @param capacidad
	 *            the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Método que retorna el valor de la variable fabricante
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * Método que establece el valor de la variable fabricante
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:06:18 AM
	 * @param fabricante
	 *            the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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
	 * @version Aug 21, 2016 9:31:34 AM
	 * @return the nombreAMostrar
	 */
	public String getNombreAMostrar() {
		String resultado = fabricante + " " + modelo + " " + capacidad + " pasajeros";
		nombreAMostrar = resultado;
		return nombreAMostrar;
	}

	/**
	 * Método que establece el valor de la variable nombreAMostrar
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 9:31:34 AM
	 * @param nombreAMostrar
	 *            the nombreAMostrar to set
	 */
	public void setNombreAMostrar(String nombreAMostrar) {
		this.nombreAMostrar = nombreAMostrar;
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
		if (!(object instanceof Avion)) {
			return false;
		}
		Avion other = (Avion) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "co.com.payu.model.Avion[ id=" + id + " ]";
	}

}
