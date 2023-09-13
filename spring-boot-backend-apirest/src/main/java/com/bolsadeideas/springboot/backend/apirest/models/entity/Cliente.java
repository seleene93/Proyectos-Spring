package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable; // Se utiliza para indicar que las instancias de esta clase pueden ser serializadas, es decir, convertidas en una secuencia de bytes para su almacenamiento o transmisión.
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="cliente") // Si la tabla se llama igual que la clase se podría emitir indicar el name
public class Cliente implements Serializable{ 
	
	// Se definen varios campos o propiedades que representan información sobre un cliente:

	@Id // Clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de autoincremento en MySQL
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name="create_at") // Esta anotación es para indicar como está definida en la BBDD
	@Temporal(TemporalType.DATE)
	private Date createAt;

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	private static final long serialVersionUID = 1L;

}
