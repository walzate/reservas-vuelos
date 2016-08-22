package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.impl.GenericDaoImpl;
import co.com.payu.reservasvuelos.model.Ruta;
import co.com.payu.reservasvuelos.service.GenericService;

/**
 * Implementación del servicio de rutas
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:57:37 PM
 *
 */
public class RutaServiceImpl implements GenericService<Ruta> {

	/**
	 * Inyección del DAO de rutas
	 */
	@Autowired
	GenericDaoImpl<Ruta> rutaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.RutaService#insertRow(com.payulatam
	 * .simuladorbanco.model.Ruta)
	 */
	@Override
	public int insertRow(Ruta ruta) {
		return rutaDao.insertRow(ruta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.RutaService#getList()
	 */
	@Override
	public List<Ruta> getList() {
		return rutaDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.RutaService#getRowById(int)
	 */
	@Override
	public Ruta getRowById(int id) {
		return rutaDao.getRowById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.RutaService#updateRow(com.payulatam
	 * .simuladorbanco.model.Ruta)
	 */
	@Override
	public int updateRow(Ruta ruta) {
		return rutaDao.updateRow(ruta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.simuladorbanco.service.RutaService#deleteRow(int)
	 */
	@Override
	public int deleteRow(int id) {
		return rutaDao.deleteRow(id);
	}

}
