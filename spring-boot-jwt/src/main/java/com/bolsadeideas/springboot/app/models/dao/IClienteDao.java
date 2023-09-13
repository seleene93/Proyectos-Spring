package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{ // primer parámetro la entidad y el segundo el tipo de la primary key

	@Query("select  c from Cliente c left join fetch c.facturas f where c.id=?1") //  seleccionar un cliente y cargar en la consulta todas las facturas asociadas a ese cliente. por el id del cliente
	public Cliente fetchByIdWithFacturas(Long id);
}
