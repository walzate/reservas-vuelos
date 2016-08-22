package co.com.payu.reservasvuelos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import co.com.payu.reservasvuelos.constants.Constants;
import co.com.payu.reservasvuelos.util.ReservasVuelosUtil;

/**
 * Clase encargada de modelar la entidad Vuelo
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:02:50 AM
 *
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
    /**
     * Identificador único de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    /**
     * Fecha del vuelo
     */
    @Basic(optional = false)
    @Column(name = "fecha")
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    /**
     * Hora de inicio del vuelo
     */
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @DateTimeFormat(pattern = Constants.TIME_FORMAT)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    /**
     * Avión que realiza el vuelo
     */
    @JoinColumn(name = "id_avion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Avion avion;
    /**
     * Ruta que realiza el avión en el vuelo
     */
    @JoinColumn(name = "id_ruta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ruta ruta;
    /**
     * Lista de pasajeros
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<PasajeroPorVuelo> pasajeroPorVueloList;
    /**
     * Representación del vuelo en String
     */
    @Transient
    private String nombreAMostrar;
    /**
     * Hora calculada de finalización del vuelo teniendo en cuenta la hora de inicio
     * y la duración del vuelo
     */
    @Transient
    @DateTimeFormat(pattern = Constants.TIME_FORMAT)
    @Temporal(TemporalType.TIME)
    private Date horaEstimadaFinalizacion;

    /**
     * Método constructor de la clase Vuelo.java
     */
    public Vuelo() {
    }

    /**
     * Método constructor de la clase Vuelo.java
     * @param id
     */
    public Vuelo(Integer id) {
        this.id = id;
    }

    /**
     * Método constructor de la clase Vuelo.java
     * @param id
     * @param fecha
     * @param horaInicio
     */
    public Vuelo(Integer id, Date fecha, Date horaInicio) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }
    
    /**
	 * Método que retorna el valor de la variable id
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método que establece el valor de la variable id
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método que retorna el valor de la variable fecha
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Método que establece el valor de la variable fecha
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método que retorna el valor de la variable horaInicio
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}

	/**
	 * Método que establece el valor de la variable horaInicio
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:18:09 AM
	 * @param horaInicio the horaInicio to set
	 */
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

	
	
	/**
	 * Método que retorna el valor de la variable horaEstimadaFinalizacion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 6:42:34 PM
	 * @return the horaEstimadaFinalizacion
	 */
	public Date getHoraEstimadaFinalizacion() {
		Date resultado = ReservasVuelosUtil.getInstance().sumarHoraDeInicioYDuracion(horaInicio, ruta.getDuracion());
		horaEstimadaFinalizacion = resultado;
		return horaEstimadaFinalizacion;
	}

	/**
	 * Método que establece el valor de la variable horaEstimadaFinalizacion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 6:42:34 PM
	 * @param horaEstimadaFinalizacion the horaEstimadaFinalizacion to set
	 */
	public void setHoraEstimadaFinalizacion(Date horaEstimadaFinalizacion) {
		this.horaEstimadaFinalizacion = horaEstimadaFinalizacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "co.com.payu.model.Vuelo[ id=" + id + " ]";
    }
    
}
