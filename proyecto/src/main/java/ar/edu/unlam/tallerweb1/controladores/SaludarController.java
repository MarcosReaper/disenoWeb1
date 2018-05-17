package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludarController {
	@RequestMapping (path = "/saludarConApellido", method = RequestMethod.GET)
	public ModelAndView saludar(@RequestParam("persona") String nombre, @RequestParam("apellido") String apellido){
		ModelMap model = new ModelMap();
		model.put("saludar", "Hola "+nombre+" tu apellido es "+ apellido);
		ModelAndView modelAndView = new ModelAndView("saludar",model);
		return modelAndView;
	}
	
	@RequestMapping (path = "/saludar", method = RequestMethod.GET)
	public ModelAndView saludar(@RequestParam("persona") String nombre){
		ModelMap model = new ModelMap();
		model.put("saludar", "Hola "+nombre);
		ModelAndView modelAndView = new ModelAndView("saludar",model);
		return modelAndView;
	}
	
	@RequestMapping (path = "/saludarConVariable/{nombre}", method = RequestMethod.GET)
	public ModelAndView saludarSinParametroEnBarra(@PathVariable("nombre") String nombre){
		ModelMap model = new ModelMap();
		model.put("saludar", "Hola "+nombre);
		ModelAndView modelAndView = new ModelAndView("saludar",model);
		return modelAndView;
	}
}
