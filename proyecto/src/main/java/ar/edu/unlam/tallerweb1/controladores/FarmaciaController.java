package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class FarmaciaController {

	@RequestMapping(path = "/verFarmacia", method = RequestMethod.GET)
	public ModelAndView mostrarFarmacia() {
		ModelMap modelo = new ModelMap();
		Farmacia miFarmacia = new Farmacia();
		miFarmacia.setNombre("Doctor Ahorro");
		miFarmacia.setTelefono("1122554477");
		modelo.put("clave", miFarmacia);
		return new ModelAndView("farmacia",modelo);
	}
}
