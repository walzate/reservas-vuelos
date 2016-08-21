package co.com.payu.reservasvuelos.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import co.com.payu.reservasvuelos.constants.Constants;
import co.com.payu.reservasvuelos.model.Avion;


/**
 * Clase encargada de encapsular los filtros para realizar el reporte
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Feb 1, 2015 10:46:11 PM
 *
 */
public class FiltrosReporteDTO {

	/**
	 * El filtro por avión
	 */
	private Avion avion;
	/**
	 * El filtro por fecha inicial
	 */
	@DateTimeFormat(pattern = Constants.DATE_FORMAT)
	private Date fechaInicial;

	/**
	 * El filtro por fecha final
	 */
	@DateTimeFormat(pattern = Constants.DATE_FORMAT)
	private Date fechaFinal;
	
	/**
	 * Método que retorna el valor de la variable avion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:43:43 PM
	 * @return the avion
	 */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * Método que establece el valor de la variable avion
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 2:43:43 PM
	 * @param avion the avion to set
	 */
	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	/**
	 * Método que retorna el valor de la variable fechaInicial
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Feb 1, 2015 6:07:40 PM
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * Método que establece el valor de la variable fechaInicial
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Feb 1, 2015 6:07:40 PM
	 * @param fechaInicial
	 *            the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * Método que retorna el valor de la variable fechaFinal
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Feb 1, 2015 6:07:40 PM
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Método que establece el valor de la variable fechaFinal
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Feb 1, 2015 6:07:40 PM
	 * @param fechaFinal
	 *            the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
