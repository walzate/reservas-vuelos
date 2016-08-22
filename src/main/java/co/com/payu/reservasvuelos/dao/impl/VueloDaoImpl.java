package co.com.payu.reservasvuelos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.com.payu.reservasvuelos.dao.VueloDao;
import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Vuelo;

public class VueloDaoImpl extends GenericDaoImpl<Vuelo> implements VueloDao {
	
	public List<Vuelo> vuelosAvionMismoDiaYHora(Vuelo vuelo) throws FunctionalException{
		Session session = sessionFactory.openSession();
		String sql = "SELECT distinct v from Vuelo v left join v.avion a left join v.ruta WHERE v.fecha = :fechaInicial AND v.horaInicio=:horaInicio AND v.avion.id = :idAvion";
		
		Query query = session.createQuery(sql);
		query.setParameter("fechaInicial", vuelo.getFecha());
		query.setParameter("horaInicio", vuelo.getHoraInicio());
		query.setParameter("idAvion", vuelo.getAvion().getId());
		
		@SuppressWarnings("unchecked")
		List<Vuelo> vuelos = query.list();
		
		return vuelos;
		
		
	}
	
	
}
