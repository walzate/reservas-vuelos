package co.com.payu.reservasvuelos.dto;

import co.com.payu.reservasvuelos.model.Avion;
import co.com.payu.reservasvuelos.model.Ruta;

/**
 * Clase encargada de encapsular los valores del reporte
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 *
 */
public class ReporteDTO {

	/**
	 * El avión para el cual se realizó el reporte
	 */
	private Avion avion;

	/**
	 * Ruta por la cual se agrupa
	 */
	private Ruta ruta;

	/**
	 * Conteo del número de vuelos realizados por el avión
	 */
	private int numeroVuelosRealizados;

	/**
	 * Conteo de pasajeros transportados por el avión
	 */
	private int numeroPasajerosTransportados;

	/**
	 * Método que retorna el valor de la variable avion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @return the avion
	 */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * Método que establece el valor de la variable avion
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @param avion
	 *            the avion to set
	 */
	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	/**
	 * Método que retorna el valor de la variable ruta
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @return the ruta
	 */
	public Ruta getRuta() {
		return ruta;
	}

	/**
	 * Método que establece el valor de la variable ruta
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @param ruta
	 *            the ruta to set
	 */
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	/**
	 * Método que retorna el valor de la variable numeroVuelosRealizados
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @return the numeroVuelosRealizados
	 */
	public int getNumeroVuelosRealizados() {
		return numeroVuelosRealizados;
	}

	/**
	 * Método que establece el valor de la variable numeroVuelosRealizados
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @param numeroVuelosRealizados
	 *            the numeroVuelosRealizados to set
	 */
	public void setNumeroVuelosRealizados(int numeroVuelosRealizados) {
		this.numeroVuelosRealizados = numeroVuelosRealizados;
	}

	/**
	 * Método que retorna el valor de la variable numeroPasajerosTransportados
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @return the numeroPasajerosTransportados
	 */
	public int getNumeroPasajerosTransportados() {
		return numeroPasajerosTransportados;
	}

	/**
	 * Método que establece el valor de la variable numeroPasajerosTransportados
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:58:55 PM
	 * @param numeroPasajerosTransportados
	 *            the numeroPasajerosTransportados to set
	 */
	public void setNumeroPasajerosTransportados(int numeroPasajerosTransportados) {
		this.numeroPasajerosTransportados = numeroPasajerosTransportados;
	}

}
