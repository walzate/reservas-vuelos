package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.VueloDao;
import co.com.payu.reservasvuelos.dao.impl.GenericDaoImpl;
import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.PasajeroPorVuelo;
import co.com.payu.reservasvuelos.model.Vuelo;
import co.com.payu.reservasvuelos.service.GenericService;

/**
 * Implementación del servicio de pasajeros por vuelos
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:57:37 PM
 *
 */
public class PasajeroPorVueloServiceImpl implements GenericService<PasajeroPorVuelo> {

	/**
	 * Inyección del DAO de pasajeros por vuelos
	 */
	@Autowired
	GenericDaoImpl<PasajeroPorVuelo> pasajeroPorVueloDao;
	/**
	 * Inyección del DAO de vuelos
	 */
	@Autowired
	VueloDao vueloDao;
	
	final static Logger LOGGER = Logger.getLogger(PasajeroPorVueloServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.payu.reservasvuelos.service.GenericService#insertRow(java.lang.
	 * Object)
	 */
	@Override
	public int insertRow(PasajeroPorVuelo pasajeroPorVuelo) throws FunctionalException{
		validarCapacidadAvion(pasajeroPorVuelo);
		return pasajeroPorVueloDao.insertRow(pasajeroPorVuelo);
	}

	private void validarCapacidadAvion(PasajeroPorVuelo pasajeroPorVuelo) throws FunctionalException{
		Vuelo vueloCompleto = vueloDao.obtenerVueloCompleto(pasajeroPorVuelo.getVuelo().getId());
		
		int capacidad = vueloCompleto.getAvion().getCapacidad();
		LOGGER.debug("capacidad: "+capacidad);
		int reservas = vueloCompleto.getPasajeroPorVueloList().size();
		LOGGER.debug("reservas: "+reservas);
		
		if(reservas >= capacidad){
			LOGGER.debug("No se pueden realizar más reservas dado que el vuelo ha excedido la capacidad del avión.");
			throw new FunctionalException(
					"No se pueden realizar más reservas dado que el vuelo ha excedido la capacidad del avión.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.payu.reservasvuelos.service.GenericService#getList()
	 */
	@Override
	public List<PasajeroPorVuelo> getList() {
		return pasajeroPorVueloDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.payu.reservasvuelos.service.GenericService#getRowById(int)
	 */
	@Override
	public PasajeroPorVuelo getRowById(int id) {
		return pasajeroPorVueloDao.getRowById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.payu.reservasvuelos.service.GenericService#updateRow(java.lang.
	 * Object)
	 */
	@Override
	public int updateRow(PasajeroPorVuelo pasajeroPorVuelo) throws FunctionalException{
		validarCapacidadAvion(pasajeroPorVuelo);
		return pasajeroPorVueloDao.updateRow(pasajeroPorVuelo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.payu.reservasvuelos.service.GenericService#deleteRow(int)
	 */
	@Override
	public int deleteRow(int id) {
		return pasajeroPorVueloDao.deleteRow(id);
	}

}
