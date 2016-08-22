package co.com.payu.reservasvuelos.dao;

import java.util.List;

import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Vuelo;

public interface VueloDao extends GenericDao<Vuelo> {
	public List<Vuelo> vuelosAvionMismoDiaYHora(Vuelo vuelo) throws FunctionalException;

}
