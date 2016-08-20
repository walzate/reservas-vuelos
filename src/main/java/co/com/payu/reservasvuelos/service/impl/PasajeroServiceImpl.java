package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.PasajeroDao;
import co.com.payu.reservasvuelos.model.Pasajero;
import co.com.payu.reservasvuelos.service.PasajeroService;


/**
 * Implementación del servicio de pasajeros 
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:57:37 PM
 *
 */
public class PasajeroServiceImpl implements PasajeroService {

	/**
	 * Inyección del DAO de pasajeros 
	 */
	@Autowired
	PasajeroDao pasajeroDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.PasajeroService#insertRow(com.payulatam
	 * .simuladorbanco.model.Pasajero)
	 */
	@Override
	public int insertRow(Pasajero pasajero) {
		return pasajeroDao.insertRow(pasajero);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.PasajeroService#getList()
	 */
	@Override
	public List<Pasajero> getList() {
		return pasajeroDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.PasajeroService#getRowById(int)
	 */
	@Override
	public Pasajero getRowById(int id) {
		return pasajeroDao.getRowById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.PasajeroService#updateRow(com.payulatam
	 * .simuladorbanco.model.Pasajero)
	 */
	@Override
	public int updateRow(Pasajero pasajero) {
		return pasajeroDao.updateRow(pasajero);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.PasajeroService#deleteRow(int)
	 */
	@Override
	public int deleteRow(int id) {
		return pasajeroDao.deleteRow(id);
	}

}
