/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.payu.reservasvuelos.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.com.payu.reservasvuelos.constants.Constants;

/**
 * Clase encargada de probar la clase de utilitarios
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 22, 2016 8:28:11 AM
 *
 */
public class ReservasVuelosUtilTest {

	/**
	 * Método constructor de la clase ReservasVuelosUtilTest.java
	 */
	public ReservasVuelosUtilTest() {
	}

	/**
	 * Método que establece las variables para toda la clase
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:29:01 AM
	 */
	@BeforeClass
	public static void setUpClass() {
	}

	/**
	 * Método que cierra las variables para toda la clase
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:29:01 AM
	 */
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Método que establece las variables para todo método
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:29:01 AM
	 */
	@Before
	public void setUp() {
	}

	/**
	 * Método que cierra las variables para todo método
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:29:01 AM
	 */
	@After
	public void tearDown() {
	}

	/**
	 * Método que prueba la funcionalidad de suma de una duración a una hora de
	 * inicio
	 * 
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 22, 2016 8:28:38 AM
	 */
	@Test
	public void testSumarHoraDeInicioYDuracion() {
		System.out.println("sumarHoraDeInicioYDuracion");
		DateTime dtInicio = DateTime.parse("10:30:50", DateTimeFormat.forPattern(Constants.TIME_FORMAT));
		DateTime dtDuracion = DateTime.parse("00:30:05", DateTimeFormat.forPattern(Constants.TIME_FORMAT));
		DateTime dtResultado = DateTime.parse("11:00:55", DateTimeFormat.forPattern(Constants.TIME_FORMAT));

		Date horaInicio = dtInicio.toDate();
		Date duracion = dtDuracion.toDate();
		ReservasVuelosUtil instance = new ReservasVuelosUtil();
		Date expResult = dtResultado.toDate();
		Date result = instance.sumarHoraDeInicioYDuracion(horaInicio, duracion);
		assertEquals(expResult, result);
	}

}
