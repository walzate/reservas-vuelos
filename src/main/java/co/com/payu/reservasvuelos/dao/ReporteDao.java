package co.com.payu.reservasvuelos.dao;

import java.util.List;

import co.com.payu.reservasvuelos.dto.FiltrosReporteDTO;
import co.com.payu.reservasvuelos.dto.ReporteDTO;

/**
 * Interfaz del Data access object para el reporte
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 10:29:27 PM
 *
 */
public interface ReporteDao {
	/**
	 * Método utilizado para generar un reporte que, dado un rango de fechas y
	 * un avión muestre, agrupados por ruta, cuantos vuelos realizó así como
	 * cuantos pasajeros transportó.
	 * 
	 * @param filtro
	 *            el filtro para el reporte
	 * @return el resultado del reporte
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 10:35:24 PM
	 */
	public List<ReporteDTO> obtenerReporte(FiltrosReporteDTO filtro);
}
