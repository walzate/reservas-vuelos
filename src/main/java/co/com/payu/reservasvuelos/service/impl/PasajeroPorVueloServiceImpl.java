package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.impl.GenericDaoImpl;
import co.com.payu.reservasvuelos.model.PasajeroPorVuelo;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.payu.reservasvuelos.service.GenericService#insertRow(java.lang.
	 * Object)
	 */
	@Override
	public int insertRow(PasajeroPorVuelo pasajeroPorVuelo) {
		return pasajeroPorVueloDao.insertRow(pasajeroPorVuelo);
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
	public int updateRow(PasajeroPorVuelo pasajeroPorVuelo) {
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
