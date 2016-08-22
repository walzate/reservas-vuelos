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
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Controlador de las páginas de pasajeros
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:09:40 PM
 *
 */
@Controller
public class PasajeroController {

	/**
	 * Inyección del servicio de pasajeros
	 */
	@Autowired
	GenericService<Pasajero> pasajeroService;

	/**
	 * Método que realiza la redirección al formulario de creación
	 * 
	 * @param pasajero
	 *            el pasajero que se va a manejar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:04 PM
	 */
	@RequestMapping("pasajero/form")
	public ModelAndView getForm(@ModelAttribute Pasajero pasajero) {
		return new ModelAndView("pasajero/form");
	}

	/**
	 * Método que almacena el pasajero y redirecciona a la pagina de lista
	 * 
	 * @param pasajero
	 *            el pasajero a almacenar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:42 PM
	 */
	@RequestMapping("pasajero/register")
	public ModelAndView registerUser(@ModelAttribute Pasajero pasajero) {
		
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			pasajeroService.insertRow(pasajero);
		} catch (FunctionalException e) {
			mav.addObject("error", e.getMessage());
		}
		return mav;
	}

	/**
	 * Método que consulta los pasajeros en el sistema
	 * 
	 * @return el modelo con la lista
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:21 PM
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("pasajero/list")
	public ModelAndView getList() {
		List pasajerosList = pasajeroService.getList();
		return new ModelAndView("pasajero/list", "pasajerosList", pasajerosList);
	}

	/**
	 * Método que elimina un pasajero y redirecciona a la lista de pasajeros
	 * 
	 * @param id
	 *            el id del pasajero a eliminar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:43 PM
	 */
	@RequestMapping("pasajero/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		pasajeroService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	/**
	 * Método que redirecciona a la página de edición y carga la información del
	 * pasajero
	 * 
	 * @param id
	 *            el id del pasajero a editar
	 * @param pasajero
	 *            el pasajero a editar
	 * @return el modelo con la redirección y el objeto resultado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:12:11 PM
	 */
	@RequestMapping("pasajero/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Pasajero pasajero) {
		Pasajero pasajeroObject = pasajeroService.getRowById(id);
		return new ModelAndView("pasajero/edit", "pasajeroObject", pasajeroObject);
	}

	/**
	 * Método que edita un pasajero y redirecciona a la lista de pasajeros
	 * 
	 * @param pasajero el pasajero a actualizar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:13:14 PM
	 */
	@RequestMapping("pasajero/update")
	public ModelAndView updateUser(@ModelAttribute Pasajero pasajero) {
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			pasajeroService.updateRow(pasajero);
		} catch (FunctionalException e) {
			mav.addObject("error", e.getMessage());
		}
		return mav;
	}

}
