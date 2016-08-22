package co.com.payu.reservasvuelos.exception;


/**
 * Excepción que encapsula los errores de validación 
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Feb 1, 2015 10:50:02 PM
 *
 */
public class FunctionalException extends Exception {

	/**
	 * El id de serialización
	 */
	private static final long serialVersionUID = 3144683024132100818L;

	/**
	 * Método constructor de la clase FunctionalException.java
	 */
	public FunctionalException() {
		super();
	}

	/**
	 * Método constructor de la clase FunctionalException.java
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FunctionalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * Método constructor de la clase FunctionalException.java
	 * @param message
	 * @param cause
	 */
	public FunctionalException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * Método constructor de la clase FunctionalException.java
	 * @param message
	 */
	public FunctionalException(String message) {
		super(message);

	}

	/**
	 * Método constructor de la clase FunctionalException.java
	 * @param cause
	 */
	public FunctionalException(Throwable cause) {
		super(cause);

	}

}
