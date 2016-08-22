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
import co.com.payu.reservasvuelos.model.Ruta;
import co.com.payu.reservasvuelos.service.GenericService;


/**
 * Controlador de las páginas de rutas
 * 
 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
 * @version Aug 20, 2016 10:09:40 PM
 *
 */
@Controller
public class RutaController {

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
	@InitBinder
	public void binder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, 
	            new CustomDateEditor(new SimpleDateFormat("HH:mm:ss"), true));
	}
	
	/**
	 * Inyección del servicio de rutas
	 */
	@Autowired
	GenericService<Ruta> rutaService;

	/**
	 * Método que realiza la redirección al formulario de creación
	 * 
	 * @param ruta
	 *            el ruta que se va a manejar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:04 PM
	 */
	@RequestMapping("ruta/form")
	public ModelAndView getForm(@ModelAttribute Ruta ruta) {
		return new ModelAndView("ruta/form");
	}

	/**
	 * Método que almacena el ruta y redirecciona a la pagina de lista
	 * 
	 * @param ruta
	 *            el ruta a almacenar
	 * @return El modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:10:42 PM
	 */
	@RequestMapping("ruta/register")
	public ModelAndView registerUser(@ModelAttribute Ruta ruta) {
		
		ModelAndView mav = new ModelAndView("redirect:list");
		try {
			rutaService.insertRow(ruta);
		} catch (FunctionalException e) {
			mav.addObject("error", e.getMessage());
		}
		return mav;
	}

	/**
	 * Método que consulta los rutas en el sistema
	 * 
	 * @return el modelo con la lista
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:21 PM
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("ruta/list")
	public ModelAndView getList() {
		List rutasList = rutaService.getList();
		return new ModelAndView("ruta/list", "rutasList", rutasList);
	}

	/**
	 * Método que elimina un ruta y redirecciona a la lista de rutas
	 * 
	 * @param id
	 *            el id del ruta a eliminar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:11:43 PM
	 */
	@RequestMapping("ruta/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		rutaService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	/**
	 * Método redirecciona a la página de edición y carga la información del
	 * ruta
	 * 
	 * @param id
	 *            el id del ruta a editar
	 * @param ruta
	 *            el ruta a editar
	 * @return el modelo con la redirección y el objeto resultado
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:12:11 PM
	 */
	@RequestMapping("ruta/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Ruta ruta) {
		Ruta rutaObject = rutaService.getRowById(id);
		return new ModelAndView("ruta/edit", "rutaObject", rutaObject);
	}

	/**
	 * Método que edita un ruta y redirecciona a la lista de rutas
	 * 
	 * @param ruta el ruta a actualizar
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 20, 2016 10:13:14 PM
	 */
	@RequestMapping("ruta/update")
	public ModelAndView updateUser(@ModelAttribute Ruta ruta) {
		rutaService.updateRow(ruta);
		return new ModelAndView("redirect:list");
	}

}
