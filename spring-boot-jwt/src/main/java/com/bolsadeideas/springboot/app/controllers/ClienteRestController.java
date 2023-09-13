package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.models.entity.ClienteList;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(value = "/listar") // es como get mapping, si no se especifica el metodo por defecto es get.
	@Secured("ROLE_ADMIN")
	public ClienteList listar() { 
		return new ClienteList(clienteService.findAll());
	}
}
