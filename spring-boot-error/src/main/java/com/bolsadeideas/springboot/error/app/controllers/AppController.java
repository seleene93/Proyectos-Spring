package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("unused") // es para que no salga el warning de valor
	@GetMapping("/index")
	private String index() {
		// Integer valor = 100 / 0;
		Integer valor = Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("/ver/{id}") // obtenemos el id a través de un parámetro de la ruta, pasamos el id al service y lo pasamos para obtener el usuario y el usuario lo pasmaos a la vista
	public String ver(@PathVariable Integer id, Model model) {
		//Usuario usuario = usuarioService.obtenerPorId(id);
		
//		if(usuario==null) {
//			throw new UsuarioNoEncontradoException(id.toString()); // si el usuario obtenido mediante la id no existe lanzará esta excepcion
//		}
		
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
