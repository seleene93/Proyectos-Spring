package com.bolsadeideas.springboot.app.models.entity;

import java.util.List;

public class ClienteList {
	public List<Cliente> clientes;
	
	public ClienteList() {
		
	}
	
	public ClienteList(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}