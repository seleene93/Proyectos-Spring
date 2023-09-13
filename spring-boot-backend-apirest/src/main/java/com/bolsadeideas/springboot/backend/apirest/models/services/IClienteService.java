package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	// Es una interfaz que se utiliza para definir los métodos que estarán disponibles en la capa de servicio relacionada con la entidad Cliente.
	// Los métodos que se definen en esta interfaz suelen estar relacionados con las operaciones CRUD
	
	public List<Cliente> findAll();
}
