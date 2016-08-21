/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author fawkes
 */
@Entity
@Table(name = "pasajero_por_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasajeroPorVuelo.findAll", query = "SELECT p FROM PasajeroPorVuelo p"),
    @NamedQuery(name = "PasajeroPorVuelo.findById", query = "SELECT p FROM PasajeroPorVuelo p WHERE p.id = :id")})
public class PasajeroPorVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_pasajero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pasajero pasajero;
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vuelo vuelo;

    public PasajeroPorVuelo() {
    }

    public PasajeroPorVuelo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
	 * Método que retorna el valor de la variable pasajero
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @return the pasajero
	 */
	public Pasajero getPasajero() {
		return pasajero;
	}

	/**
	 * Método que establece el valor de la variable pasajero
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @param pasajero the pasajero to set
	 */
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	/**
	 * Método que retorna el valor de la variable vuelo
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @return the vuelo
	 */
	public Vuelo getVuelo() {
		return vuelo;
	}

	/**
	 * Método que establece el valor de la variable vuelo
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 8:53:23 AM
	 * @param vuelo the vuelo to set
	 */
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
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
