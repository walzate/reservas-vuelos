package co.com.payu.reservasvuelos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Avion;
import co.com.payu.reservasvuelos.model.Ruta;
import co.com.payu.reservasvuelos.model.Vuelo;
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Controlador de las páginas de vuelos
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:09:40 PM
 *
 */
@Controller
public class VueloController {

	/**
	 * Inyección del servicio de vuelos
	 */
	@Autowired
	GenericService<Vuelo> vueloService;
	
	/**
	 * Inyección del servicio de aviones
	 */
	@Autowired
	GenericService<Avion> avionService;
	
	/**
	 * Inyección del servicio de rutas
	 */
	@Autowired
	GenericService<Ruta> rutaService;

	/**
	 * Método que realiza el binding para el campo de duración de String a Date
	 * conservando el formato de hora y fecha
	 * 
	 * @param binder
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 7:27:05 PM
	 * @see http://stackoverflow.com/questions/25219683/date-binder-of-multiple-
	 *      formats-in-java
	 */
	@InitBinder("horaInicio")
	public void binder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, 
	            new CustomDateEditor(new SimpleDateFormat("HH:mm:ss"), true));
	}
	
	/**
	 * Método que realiza la redirección al formulario de creación
	 * 
	 * @param vuelo
	 *            el vuelo que se va a manejar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:04 PM
	 */
	@RequestMapping("vuelo/form")
	public ModelAndView getForm(@ModelAttribute Vuelo vuelo) {
		
		ModelAndView mav = new ModelAndView("vuelo/form");

		List<Avion> avionesList = avionService.getList();
		List<Ruta> rutasList = rutaService.getList();

		mav.addObject("avionesList", avionesList);
		mav.addObject("rutasList", rutasList);

		return mav;
		
	}

	/**
	 * Método que almacena el vuelo y redirecciona a la pagina de lista
	 * 
	 * @param vuelo
	 *            el vuelo a almacenar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:42 PM
	 */
	@RequestMapping("vuelo/register")
	public ModelAndView registerUser(@ModelAttribute Vuelo vuelo) {
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			vueloService.insertRow(vuelo);
		} catch (FunctionalException e) {
			mav.addObject("error", e.getMessage());
		}
		return mav;
	}

	/**
	 * Método que consulta los vuelos en el sistema
	 * 
	 * @return el modelo con la lista
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:21 PM
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("vuelo/list")
	public ModelAndView getList() {
		List vuelosList = vueloService.getList();
		return new ModelAndView("vuelo/list", "vuelosList", vuelosList);
	}

	/**
	 * Método que elimina un vuelo y redirecciona a la lista de vuelos
	 * 
	 * @param id
	 *            el id del vuelo a eliminar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:43 PM
	 */
	@RequestMapping("vuelo/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		vueloService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	/**
	 * Método redirecciona a la página de edición y carga la información del
	 * vuelo
	 * 
	 * @param id
	 *            el id del vuelo a editar
	 * @param vuelo
	 *            el vuelo a editar
	 * @return el modelo con la redirección y el objeto resultado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:12:11 PM
	 */
	@RequestMapping("vuelo/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Vuelo vuelo) {
		
		ModelAndView mav = new ModelAndView("vuelo/edit");
		
		Vuelo vueloObject = vueloService.getRowById(id);
		List<Avion> avionesList = avionService.getList();
		List<Ruta> rutasList = rutaService.getList();

		mav.addObject("vueloObject", vueloObject);
		mav.addObject("avionesList", avionesList);
		mav.addObject("rutasList", rutasList);
		
		return mav;
	}

	/**
	 * Método que edita un vuelo y redirecciona a la lista de vuelos
	 * 
	 * @param vuelo el vuelo a actualizar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:13:14 PM
	 */
	@RequestMapping("vuelo/update")
	public ModelAndView updateUser(@ModelAttribute Vuelo vuelo) {
		vueloService.updateRow(vuelo);
		return new ModelAndView("redirect:list");
	}

}
