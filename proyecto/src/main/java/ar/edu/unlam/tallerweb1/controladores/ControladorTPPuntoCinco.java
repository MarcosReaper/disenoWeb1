package ar.edu.unlam.tallerweb1.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTPPuntoCinco {

	Integer operando1;
	Integer operando2;
	String error;
	
	private Map<String,String> operadores;
	
	@PostConstruct
	public void init() {
		operadores = new HashMap<>();
		operadores.put("sumar", "sumar");
		operadores.put("restar", "restar");
		operadores.put("multiplicar", "multiplicar");
		operadores.put("dividir", "dividir");
	}
	
	@RequestMapping (path = "/puntoCinco/{operador}/{operando1}/{operando2}", method = RequestMethod.GET)
	public ModelAndView saludarSinParametroEnBarra(@PathVariable("operador") String operador,
			@PathVariable("operando1") String operando1,
			@PathVariable("operando2") String operando2){
		ModelAndView modelAndView = null;
		ModelMap model = new ModelMap();
		if(validateOperacion(operador,operando1,operando2)){
			model = realizarOperacion(operador);
			modelAndView = new ModelAndView("operacion",model);
		}else{
			model.put("error", error);
			modelAndView = new ModelAndView("error",model);
		}
		return modelAndView;
	}

	private ModelMap realizarOperacion(String operador) {
		ModelMap modelMap = new ModelMap();
		Integer resultado = null;
		switch(operadores.get(operador)){
			case "sumar":
				resultado = operando1 + operando2;
				break;
			case "restar":
				resultado = operando1 - operando2;
				break;
			case "multiplicar":
				resultado = operando1 * operando2;
				break;
			case "dividir":
				resultado = operando1 / operando2;
				break;
		}
		modelMap.put("resultado", "El resultado de "+operador+" "+operando1.toString()+" y " +operando2.toString()+ " da "+ resultado.toString());
		return modelMap;
	}

	private boolean validateOperacion(String operador, String operando1, String operando2) {
		if(operadores.containsKey(operador)){
			try{
				this.operando1 = Integer.valueOf(operando1);
				this.operando2 = Integer.valueOf(operando2);
				return true;
			}catch(Exception e){
				this.error = "error parseando operandos a numeros";
				System.out.println(error);
				return false;
			}
		}else{
			this.error = "el operador no existe";
			System.out.println(error);
		}
		return false;
	}
}
