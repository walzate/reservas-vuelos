/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.payu.reservasvuelos.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fawkes
 */
public class ReservasVuelosUtilTest {
    
    public ReservasVuelosUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sumarHoraDeInicioYDuracion method, of class ReservasVuelosUtil.
     */
    @Test
    public void testSumarHoraDeInicioYDuracion() {
        System.out.println("sumarHoraDeInicioYDuracion");
        DateTime dtInicio = DateTime.parse("10:30:50", 
                DateTimeFormat.forPattern("HH:mm:ss"));
        DateTime dtDuracion = DateTime.parse("00:30:05", 
                DateTimeFormat.forPattern("HH:mm:ss"));
        DateTime dtResultado = DateTime.parse("11:00:55", 
                DateTimeFormat.forPattern("HH:mm:ss"));
        
        Date horaInicio = dtInicio.toDate();
        Date duracion = dtDuracion.toDate();
        ReservasVuelosUtil instance = new ReservasVuelosUtil();
        Date expResult = dtResultado.toDate();
        Date result = instance.sumarHoraDeInicioYDuracion(horaInicio, duracion);
        assertEquals(expResult, result);
    }
    
}
