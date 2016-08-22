package co.com.payu.reservasvuelos.util;

import java.util.Date;

import org.joda.time.DateTime;

public class ReservasVuelosUtil {

	private static ReservasVuelosUtil instance = null;

	protected ReservasVuelosUtil() {

	}

	public static ReservasVuelosUtil getInstance() {
		if (instance == null) {
			instance = new ReservasVuelosUtil();
		}
		return instance;
	}

	public Date sumarHoraDeInicioYDuracion(Date horaInicio, Date duracion) {
		DateTime dtInicio = new DateTime(horaInicio);
		DateTime dtDuracion = new DateTime(duracion);

		DateTime resultado = dtInicio.plusHours(dtDuracion.getHourOfDay());
		resultado = resultado.plusMinutes(dtDuracion.getMinuteOfDay());
		resultado = resultado.plusSeconds(dtDuracion.getSecondOfMinute());
		return resultado.toDate();
	}

}
