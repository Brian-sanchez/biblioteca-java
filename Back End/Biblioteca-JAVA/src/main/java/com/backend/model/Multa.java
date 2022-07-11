package com.backend.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "multa")
public class Multa {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column
    @CreatedDate
	private LocalDate inicioM;
    
    @Column
	private LocalDate finM;
    
	@OneToOne
	@JoinColumn(name = "id_copiaM")
	private Copia copia;
    
	@OneToOne
	@JoinColumn(name = "id_lectorM")
	private Lector lector;
	
	@OneToOne
	@JoinColumn(name = "id_libroM")
	private Libro libro;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getInicioM() {
		return inicioM;
	}

	public void setInicioM(LocalDate inicioM) {
		this.inicioM = inicioM;
	}

	public LocalDate getFinM() {
		return finM;
	}

	public void setFinM(LocalDate finM) {
		this.finM = finM;
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

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}
}
