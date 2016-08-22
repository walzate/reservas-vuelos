package co.com.payu.reservasvuelos.dao;

import java.util.List;

import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Vuelo;

/**
 * Interfaz para el Data access object de aviones
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 7:48:46 AM
 *
 */
public interface VueloDao extends GenericDao<Vuelo> {

	/**
	 * Método que consulta los vuelos de un avion para el mismo día y hora
	 * 
	 * @param vuelo
	 *            El vuelo que contiene el avión y la fecha
	 * @return Una lista de vuelos
	 * @throws FunctionalException
	 *             Si hay más vuelos para el mismo avión el mismo día y hora
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 7:49:07 AM
	 */
	public List<Vuelo> consultarVuelosAvionMismoDiaYHora(Vuelo vuelo) throws FunctionalException;

	/**
	 * Método que consulta el vuelo con su ruta y pasajeros
	 * 
	 * @param idVuelo
	 *            el id del vuelo a buscar
	 * @return Un objeto de tipo Vuelo con toda su información asociada
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 7:51:52 AM
	 */
	public Vuelo obtenerVueloCompleto(int idVuelo);

}
