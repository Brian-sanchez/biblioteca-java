package com.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "lector")
public class Lector {
    @Id
	@Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    @Column
	private String nombre;
    @Column
	private String telefono;
    @Column
	private String direccion;
    
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
