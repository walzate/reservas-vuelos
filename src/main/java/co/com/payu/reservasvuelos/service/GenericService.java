package co.com.payu.reservasvuelos.service;

import java.util.List;

import co.com.payu.reservasvuelos.exception.FunctionalException;


/**
 * Interfaz del servicio genérico
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:53:39 PM
 *
 */
public interface GenericService<T> {
	/**
	 * Método que almacena una entidad
	 * 
	 * @param entidad
	 *            la entidad a almacenar
	 * @return el id de la entidad almacenado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:24:20 PM
	 */
	public int insertRow(T entidad) throws FunctionalException;

	/**
	 * Método que consulta los entidades en el sistema
	 * 
	 * @return la lista de entidades
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:24:41 PM
	 */
	public List<T> getList();

	/**
	 * Método que obtiene una entidad dado su id
	 * 
	 * @param id
	 *            el id por el cual consultar
	 * @return la entidad encontrado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:04 PM
	 */
	public T getRowById(int id);

	/**
	 * Método que actualiza una entidad
	 * 
	 * @param entidad
	 *            la entidad a actualizar
	 * @return la entidad actualizado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:26 PM
	 */
	public int updateRow(T entidad) throws FunctionalException;

	/**
	 * Método que elimina una entidad
	 * 
	 * @param id
	 *            el id de la entidad a eliminar
	 * @return el id de la entidad eliminado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:25:49 PM
	 */
	public int deleteRow(int id);
}
