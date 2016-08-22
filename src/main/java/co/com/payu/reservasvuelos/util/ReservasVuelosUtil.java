package co.com.payu.reservasvuelos.util;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * Clase con métodos utilitarios
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:26:10 AM
 *
 */
public class ReservasVuelosUtil {

	/**
	 * Instancia para la implementación del Singleton
	 */
	private static ReservasVuelosUtil instance = null;

	/**
	 * Método constructor de la clase ReservasVuelosUtil.java
	 */
	protected ReservasVuelosUtil() {

	}

	/**
	 * Método que retorna una única instancia de la clase
	 * 
	 * @return el Singleton de la clase
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:26:51 AM
	 */
	public static ReservasVuelosUtil getInstance() {
		if (instance == null) {
			instance = new ReservasVuelosUtil();
		}
		return instance;
	}

	/**
	 * Método que suma una duración a una hora de inicio
	 * 
	 * @param horaInicio
	 *            la hora inicial
	 * @param duracion
	 *            la duración del evento
	 * @return la nueva hora
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:27:16 AM
	 */
	public Date sumarHoraDeInicioYDuracion(Date horaInicio, Date duracion) {
		DateTime dtInicio = new DateTime(horaInicio);
		DateTime dtDuracion = new DateTime(duracion);

		DateTime resultado = dtInicio.plusHours(dtDuracion.getHourOfDay());
		resultado = resultado.plusMinutes(dtDuracion.getMinuteOfDay());
		resultado = resultado.plusSeconds(dtDuracion.getSecondOfMinute());
		return resultado.toDate();
	}

}
