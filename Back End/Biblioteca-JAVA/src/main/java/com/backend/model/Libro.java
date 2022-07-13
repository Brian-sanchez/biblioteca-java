package com.backend.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
	@Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column
	private String titulo;
    
    @Column
	private String editorial;
    
    @Column
	private int anyo;
    
    @Column
	private String image;
    
    @Column
	private String autor;
    
    @Column
	private String autorNacionalidad;
    
    @Column
	private Date autorNacimiento;
    
	@Enumerated(EnumType.STRING)
	private TipoLibro tipoLibro;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public int getAnyo() {
		return anyo;
	}
	
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAutorNacionalidad() {
		return autorNacionalidad;
	}

	public void setAutorNacionalidad(String autorNacionalidad) {
		this.autorNacionalidad = autorNacionalidad;
	}

	public Date getAutorNacimiento() {
		return autorNacimiento;
	}

	public void setAutorNacimiento(Date autorNacimiento) {
		this.autorNacimiento = autorNacimiento;
	}

	public TipoLibro getTipoLibro() {
		return tipoLibro;
	}

	public void setTipoLibro(TipoLibro tipoLibro) {
		this.tipoLibro = tipoLibro;
	}
}
