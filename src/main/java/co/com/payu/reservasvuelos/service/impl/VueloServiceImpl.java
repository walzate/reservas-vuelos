package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.VueloDao;
import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Vuelo;
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Implementación del servicio de vuelos 
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:57:37 PM
 *
 */
public class VueloServiceImpl implements GenericService<Vuelo> {

	/**
	 * Inyección del DAO de vuelos 
	 */
	@Autowired
	VueloDao vueloDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.VueloService#insertRow(com.payulatam
	 * .simuladorbanco.model.Vuelo)
	 */
	@Override
	public int insertRow(Vuelo vuelo) throws FunctionalException {
		List<Vuelo> vuelos =vueloDao.vuelosAvionMismoDiaYHora(vuelo);
		
		if(vuelos!= null && vuelos.size()>0){
			throw new FunctionalException(
					"El avión está destinado a otra ruta ese mismo día y hora.");
		}
		
		return vueloDao.insertRow(vuelo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.VueloService#getList()
	 */
	@Override
	public List<Vuelo> getList() {
		return vueloDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.VueloService#getRowById(int)
	 */
	@Override
	public Vuelo getRowById(int id) {
		return vueloDao.getRowById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.VueloService#updateRow(com.payulatam
	 * .simuladorbanco.model.Vuelo)
	 */
	@Override
	public int updateRow(Vuelo vuelo) {
		return vueloDao.updateRow(vuelo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.VueloService#deleteRow(int)
	 */
	@Override
	public int deleteRow(int id) {
		return vueloDao.deleteRow(id);
	}

}
