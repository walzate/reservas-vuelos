package co.com.payu.reservasvuelos.service;

import java.util.List;

import co.com.payu.reservasvuelos.dto.FiltrosReporteDTO;
import co.com.payu.reservasvuelos.dto.ReporteDTO;

/**
 * Interfaz del Data access object del reporte
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 */
public interface ReporteService {
	/**
	 * Método que generar un reporte que, dado un rango de fechas y un avión
	 * muestre, agrupados por ruta, cuantos vuelos realizó así como cuantos
	 * pasajeros transportó.
	 * 
	 * @param filtro
	 *            el filtro para el reporte
	 * @return el resultado del reporte
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 */
	public List<ReporteDTO> obtenerReporte(FiltrosReporteDTO filtro);

}
