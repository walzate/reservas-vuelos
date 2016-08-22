package co.com.payu.reservasvuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.payu.reservasvuelos.exception.FunctionalException;
import co.com.payu.reservasvuelos.model.Avion;
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Controlador de las páginas de aviones
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:09:40 PM
 *
 */
@Controller
public class AvionController {

	/**
	 * Inyección del servicio de aviones
	 */
	@Autowired
	GenericService<Avion> avionService;

	/**
	 * Método que realiza la redirección al formulario de creación
	 * 
	 * @param avion
	 *            el avion que se va a manejar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:04 PM
	 */
	@RequestMapping("avion/form")
	public ModelAndView getForm(@ModelAttribute Avion avion) {
		return new ModelAndView("avion/form");
	}

	/**
	 * Método que almacena el avion y redirecciona a la pagina de lista
	 * 
	 * @param avion
	 *            el avion a almacenar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:42 PM
	 */
	@RequestMapping("avion/register")
	public ModelAndView registerUser(@ModelAttribute Avion avion) {
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			avionService.insertRow(avion);
		} catch (FunctionalException e) {
			mav.addObject("error", e.getMessage());
		}
		return mav;
	}

	/**
	 * Método que consulta los aviones en el sistema
	 * 
	 * @return el modelo con la lista
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:21 PM
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("avion/list")
	public ModelAndView getList() {
		List avionesList = avionService.getList();
		return new ModelAndView("avion/list", "avionesList", avionesList);
	}

	/**
	 * Método que elimina un avion y redirecciona a la lista de aviones
	 * 
	 * @param id
	 *            el id del avion a eliminar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:43 PM
	 */
	@RequestMapping("avion/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		avionService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	/**
	 * Método redirecciona a la página de edición y carga la información del
	 * avion
	 * 
	 * @param id
	 *            el id del avion a editar
	 * @param avion
	 *            el avion a editar
	 * @return el modelo con la redirección y el objeto resultado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:12:11 PM
	 */
	@RequestMapping("avion/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Avion avion) {
		Avion avionObject = avionService.getRowById(id);
		return new ModelAndView("avion/edit", "avionObject", avionObject);
	}

	/**
	 * Método que edita un avion y redirecciona a la lista de aviones
	 * 
	 * @param avion el avion a actualizar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:13:14 PM
	 */
	@RequestMapping("avion/update")
	public ModelAndView updateUser(@ModelAttribute Avion avion) {
		avionService.updateRow(avion);
		return new ModelAndView("redirect:list");
	}

}
