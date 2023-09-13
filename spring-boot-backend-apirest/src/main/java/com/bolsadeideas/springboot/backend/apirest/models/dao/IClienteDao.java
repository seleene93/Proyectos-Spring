package com.bolsadeideas.springboot.backend.apirest.models.dao; // Dao = Objeto de acceso a datos

import org.springframework.data.repository.CrudRepository; // es una interfaz proporcionada por Spring Data JPA  proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una entidad específica.

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
