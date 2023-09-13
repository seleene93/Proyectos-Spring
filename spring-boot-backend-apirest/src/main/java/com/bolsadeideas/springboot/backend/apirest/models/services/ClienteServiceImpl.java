package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

@Service // Componente de servicio de Spring
public class ClienteServiceImpl implements IClienteService {
 // Diseñada para proporcionar la implementación concreta de los métodos definidos en la interfaz `IClienteService`
	
	@Autowired // Inyecta automáticamente la dependencia requerida para la interfaz 
	private IClienteDao clienteDao;
	
	@Override // Para indicar que estás reemplazando (o sobrescribiendo) un método que ya existe en una clase superior *BUENA PRÁCTICA*
	@Transactional(readOnly = true) // Se utilizará para operaciones de solo lectura
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

}
