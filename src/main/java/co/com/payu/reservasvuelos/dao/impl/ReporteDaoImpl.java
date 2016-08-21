/**
 * 
 */
package co.com.payu.reservasvuelos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.payu.reservasvuelos.dao.ReporteDao;
import co.com.payu.reservasvuelos.dto.FiltrosReporteDTO;
import co.com.payu.reservasvuelos.dto.ReporteDTO;
import co.com.payu.reservasvuelos.model.Vuelo;

/**
 * Clase encargada de realizar las acciones con la base de datos relacionadas al
 * reporte de vuelos
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 21, 2016 3:02:16 PM
 *
 */
public class ReporteDaoImpl implements ReporteDao {

	/**
	 * Inyección de la fábrica de sesiones
	 */
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.payu.reservasvuelos.dao.ReporteDao#obtenerReporte(co.com.payu.
	 * reservasvuelos.dto.FiltrosReporteDTO)
	 */
	@Override
	public List<ReporteDTO> obtenerReporte(FiltrosReporteDTO filtro) {
		Session session = sessionFactory.openSession();
		String sql = "SELECT distinct v FROM Vuelo v left join v.avion a left join v.ruta left join v.pasajeroPorVueloList  WHERE v.fecha >= :fechaInicial AND v.fecha <= :fechaFinal AND v.avion.id = :idAvion";
		Query query = session.createQuery(sql);
		query.setParameter("fechaInicial", filtro.getFechaInicial());
		query.setParameter("fechaFinal", filtro.getFechaFinal());
		query.setParameter("idAvion", filtro.getAvion().getId());

		@SuppressWarnings("unchecked")
		List<Vuelo> vuelos = query.list();

		List<ReporteDTO> resultado;
		resultado = new ArrayList<ReporteDTO>();

		int numeroVuelosRealizados = 0;
		if (vuelos != null && vuelos.size() > 0) {
			ReporteDTO reporte = new ReporteDTO();
			numeroVuelosRealizados = vuelos.size();
			reporte.setNumeroVuelosRealizados(numeroVuelosRealizados);
			int numeroPasajerosTransportados = 0;
			for (Vuelo vuelo : vuelos) {
				reporte.setAvion(vuelo.getAvion());
				reporte.setRuta(vuelo.getRuta());

				if (vuelo.getPasajeroPorVueloList() != null && vuelo.getPasajeroPorVueloList().size() > 0) {
					numeroPasajerosTransportados += vuelo.getPasajeroPorVueloList().size();
				}
				reporte.setNumeroPasajerosTransportados(numeroPasajerosTransportados);
			}
			resultado.add(reporte);
		}
		session.close();

		return resultado;
	}

}
