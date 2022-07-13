package com.backend.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
	public static final int LIMITE_PRESTAMOS = 3;
	
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column
    @CreatedDate
	private LocalDate inicio;
    
    @Column
	private LocalDate fin;
    
	@ManyToOne
	@JoinColumn(name = "id_lector")
	private Lector lector;

	@OneToOne
	@JoinColumn(name = "id_libro")
	private Libro libro;
	
	@OneToOne
	@JoinColumn(name = "id_copia")
	private Copia copia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public static int getLimitePrestamos() {
		return LIMITE_PRESTAMOS;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}
}
