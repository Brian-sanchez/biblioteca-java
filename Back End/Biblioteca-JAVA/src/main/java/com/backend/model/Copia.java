package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "copia")
public class Copia {
    @Id
	@Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
    private long idLibro;
	@Enumerated(EnumType.STRING)
	private EstadoCopia estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	public EstadoCopia getEstado() {
		return estado;
	}
	public void setEstado(EstadoCopia estado) {
		this.estado = estado;
	}
}
