package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.impl.GenericDaoImpl;
import co.com.payu.reservasvuelos.model.Avion;
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Implementación del servicio de aviones 
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:57:37 PM
 *
 */
public class AvionServiceImpl implements GenericService<Avion> {

	/**
	 * Inyección del DAO de avions 
	 */
	@Autowired
	GenericDaoImpl<Avion> avionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.AvionService#insertRow(com.payulatam
	 * .simuladorbanco.model.Avion)
	 */
	@Override
	public int insertRow(Avion avion) {
		return avionDao.insertRow(avion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.AvionService#getList()
	 */
	@Override
	public List<Avion> getList() {
		return avionDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.AvionService#getRowById(int)
	 */
	@Override
	public Avion getRowById(int id) {
		return avionDao.getRowById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.AvionService#updateRow(com.payulatam
	 * .simuladorbanco.model.Avion)
	 */
	@Override
	public int updateRow(Avion avion) {
		return avionDao.updateRow(avion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.AvionService#deleteRow(int)
	 */
	@Override
	public int deleteRow(int id) {
		return avionDao.deleteRow(id);
	}

}
