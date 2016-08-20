package co.com.payu.reservasvuelos.service;

import java.util.List;

import co.com.payu.reservasvuelos.model.Pasajero;


/**
 * Interfaz del servicio de pasajeros
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:53:39 PM
 *
 */
public interface PasajeroService {
	/**
	 * Método que almacena un pasajero
	 * 
	 * @param pasajero
	 *            el pasajero a almacenar
	 * @return el id del pasajero almacenado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:24:20 PM
	 */
	public int insertRow(Pasajero pasajero);

	/**
	 * Método que consulta los pasajeros en el sistema
	 * 
	 * @return la lista de pasajeros
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:24:41 PM
	 */
	public List<Pasajero> getList();

	/**
	 * Método que obtiene un pasajero dado su id
	 * 
	 * @param id
	 *            el id por el cual consultar
	 * @return el pasajero encontrado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:04 PM
	 */
	public Pasajero getRowById(int id);

	/**
	 * Método que actualiza un pasajero
	 * 
	 * @param pasajero
	 *            el pasajero a actualizar
	 * @return el pasajero actualizado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:26 PM
	 */
	public int updateRow(Pasajero pasajero);

	/**
	 * Método que elimina un pasajero
	 * 
	 * @param id
	 *            el id del pasajero a eliminar
	 * @return el id del pasajero eliminado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:49 PM
	 */
	public int deleteRow(int id);
}