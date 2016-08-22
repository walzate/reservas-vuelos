package co.com.payu.reservasvuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Pasajero;
import co.com.payu.reservasvuelos.model.PasajeroPorVuelo;
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
public class PasajeroPorVueloController {

	/**
	 * Inyección del servicio de pasajeros por vuelos
	 */
	@Autowired
	GenericService<PasajeroPorVuelo> pasajeroPorVueloService;
	
	/**
	 * Inyección del servicio de vuelos
	 */
	@Autowired
	GenericService<Vuelo> vueloService;
	
	/**
	 * Inyección del servicio de pasajero
	 */
	@Autowired
	GenericService<Pasajero> pasajeroService;
	
	/**
	 * Método que realiza la redirección al formulario de creación
	 * 
	 * @param vuelo
	 *            el vuelo que se va a manejar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:04 PM
	 */
	@RequestMapping("pasajeroPorVuelo/form")
	public ModelAndView getForm(@ModelAttribute PasajeroPorVuelo pasajeroPorVuelo) {
		
		ModelAndView mav = new ModelAndView("pasajeroPorVuelo/form");

		List<Vuelo> vuelosList = vueloService.getList();
		List<Pasajero> pasajerosList = pasajeroService.getList();

		mav.addObject("vuelosList", vuelosList);
		mav.addObject("pasajerosList", pasajerosList);

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
	@RequestMapping("pasajeroPorVuelo/register")
	public ModelAndView registerUser(@ModelAttribute PasajeroPorVuelo pasajeroPorVuelo) {
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			pasajeroPorVueloService.insertRow(pasajeroPorVuelo);
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
	@RequestMapping("pasajeroPorVuelo/list")
	public ModelAndView getList() {
		List pasajeroPorVueloList = pasajeroPorVueloService.getList();
		return new ModelAndView("pasajeroPorVuelo/list", "pasajeroPorVueloList", pasajeroPorVueloList);
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
	@RequestMapping("pasajeroPorVuelo/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		pasajeroPorVueloService.deleteRow(id);
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
	@RequestMapping("pasajeroPorVuelo/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute PasajeroPorVuelo pasajeroPorVuelo) {
		
		ModelAndView mav = new ModelAndView("pasajeroPorVuelo/edit");
		
		PasajeroPorVuelo pasajeroPorVueloObject = pasajeroPorVueloService.getRowById(id);
		List<Vuelo> vuelosList = vueloService.getList();
		List<Pasajero> pasajerosList = pasajeroService.getList();

		mav.addObject("vuelosList", vuelosList);
		mav.addObject("pasajerosList", pasajerosList);

		mav.addObject("pasajeroPorVueloObject", pasajeroPorVueloObject);
		
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
	@RequestMapping("pasajeroPorVuelo/update")
	public ModelAndView updateUser(@ModelAttribute PasajeroPorVuelo pasajeroPorVuelo) {
		pasajeroPorVueloService.updateRow(pasajeroPorVuelo);
		return new ModelAndView("redirect:list");
	}

}
