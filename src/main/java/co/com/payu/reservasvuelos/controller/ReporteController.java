package co.com.payu.reservasvuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.com.payu.reservasvuelos.dto.FiltrosReporteDTO;
import co.com.payu.reservasvuelos.model.Avion;
import co.com.payu.reservasvuelos.service.GenericService;
import co.com.payu.reservasvuelos.service.ReporteService;

@Controller
public class ReporteController {

	/**
	 * Inyección del servicio de reportes
	 */
	@Autowired
	ReporteService reporteService;

	/**
	 * Inyección del servicio de clientes
	 */
	@Autowired
	GenericService<Avion> avionService;

	/**
	 * Variable para almacenar el filtro seleccionado para luego realizar la
	 * consulta
	 */
	FiltrosReporteDTO filtroSeleccionado;

	/**
	 * Método que redirecciona a  los filtros 
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 10:22:33 PM
	 */
	@RequestMapping("reporte/form")
	public ModelAndView getReporteForm() {
		ModelAndView mva = new ModelAndView("reporte/form");

		mva.addObject("filtro", new FiltrosReporteDTO());

		List<Avion> avionesList = avionService.getList();
		mva.addObject("avionesList", avionesList);

		return mva;
	}

	/**
	 * Método que almacena el filtro
	 * @param filtro el filtro seleccionado
	 * @return el modelo con la redirección
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 10:22:59 PM
	 */
	@RequestMapping("reporte/filter")
	public ModelAndView filter(@ModelAttribute FiltrosReporteDTO filtro) {
		ModelAndView mva = new ModelAndView("redirect:list");
		filtroSeleccionado = filtro;
		mva.addObject("filtro", filtro);
		return mva;
	}

	/**
	 * Método que consulta el reporte
	 * @param filtro el filtro para consultar
	 * @author Wilson Alzate Calderon <wilson.alzate@gmail.com>
	 * @version Aug 21, 2016 10:23:20 PM
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("reporte/list")
	public ModelAndView getReporteList(@ModelAttribute FiltrosReporteDTO filtro) {
		List reporteDTOList;
		reporteDTOList = reporteService.obtenerReporte(filtroSeleccionado);
		return new ModelAndView("reporte/list", "reporteDTOList",
				reporteDTOList);
	}
}
