package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.backend.model.Libro;

public interface LibroService {
	List<Libro> getAllLibros();
	Libro addLibro(Libro libro);
	Libro editLibro(long id, Libro libro);
	ResponseEntity<Optional<Libro>> getLibroById(long id);
	void deleteLibroById(long id);
}
