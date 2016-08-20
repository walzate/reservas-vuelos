package co.com.payu.reservasvuelos.dao;

import java.util.List;



/**
 * Interfaz del Data access object para pasajeros
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 11:32:44 AM
 *
 */
public interface GenericDao <T> {
	/**
	 * Método que almacena una entidad 
	 * @param pasajero el pasajero a almacenar
	 * @return el id del pasajero almacenado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int insertRow(T row);

	/**
	 * Método que consulta los pasajeros en el sistema 
	 * @return la lista de pasajeros
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public List<T> getList();

	/**
	 * Método que obtiene un pasajero dado su id 
	 * @param id el id por el cual consultar
	 * @return el pasajero encontrado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public T getRowById(int id);

	/**
	 * Método que actualiza un pasajero
	 * @param pasajero el pasajero a actualizar
	 * @return el pasajero actualizado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int updateRow(T pasajero);

	/**
	 * Método que elimina un pasajero 
	 * @param id el id del pasajero a eliminar
	 * @return el id del pasajero eliminado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int deleteRow(int id);

}
