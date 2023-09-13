package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"}) // Configuramos Cors
@RestController // Como es una APIrest anotamos con Rest, manejará las solicitudes HTTP y devolverá respuestas en formato JSON o XML
@RequestMapping("/api") // Cualquier solicitud que tenga una URL que comience con "/api" será manejada 
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes") // Manejará solicitudes GET a la ruta "/clientes".
	public List<Cliente> index() {
		return clienteService.findAll();
	}
}
