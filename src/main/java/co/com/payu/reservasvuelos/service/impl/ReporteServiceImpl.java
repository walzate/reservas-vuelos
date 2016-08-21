package co.com.payu.reservasvuelos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.ReporteDao;
import co.com.payu.reservasvuelos.dto.FiltrosReporteDTO;
import co.com.payu.reservasvuelos.dto.ReporteDTO;
import co.com.payu.reservasvuelos.service.ReporteService;

/**
 * Implementación del servicio de reporte
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 *
 */
public class ReporteServiceImpl implements ReporteService {

	/**
	 * Inyección del DAO de reporte
	 */
	@Autowired
	ReporteDao reporteDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.simuladorbanco.service.ReporteService#obtenerReporte(com
	 * .payulatam.simuladorbanco.dto.FiltrosReporteDTO)
	 */
	@Override
	public List<ReporteDTO> obtenerReporte(FiltrosReporteDTO filtro) {

		return reporteDao.obtenerReporte(filtro);
	}

}
