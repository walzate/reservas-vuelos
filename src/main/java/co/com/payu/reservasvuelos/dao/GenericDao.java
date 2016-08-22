package co.com.payu.reservasvuelos.dao;

import java.util.List;



/**
 * Interfaz genérica para un del Data access object
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 11:32:44 AM
 *
 */
public interface GenericDao <T> {
	/**
	 * Método que almacena una entidad 
	 * @param entidad la entidad a almacenar
	 * @return el id de la entidad almacenada
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int insertRow(T row);

	/**
	 * Método que consulta los entidades en el sistema 
	 * @return la lista de entidades
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public List<T> getList();

	/**
	 * Método que obtiene un entidad dado su id 
	 * @param id el id por el cual consultar
	 * @return la entidad encontrado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public T getRowById(int id);

	/**
	 * Método que actualiza un entidad
	 * @param entidad la entidad a actualizar
	 * @return la entidad actualizado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int updateRow(T entidad);

	/**
	 * Método que elimina un entidad 
	 * @param id el id de la entidad a eliminar
	 * @return el id de la entidad eliminado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 11:32:44 AM
	 */
	public int deleteRow(int id);

}
