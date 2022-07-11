package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.model.Libro;
import com.backend.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> getAllLibros() {
		return libroRepository.findAll();
	}

	@Override
	public Libro addLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public void deleteLibroById(long id) {
		this.libroRepository.deleteById(id);
	}

	@Override
	public Libro editLibro(long id, Libro libro) {
		Libro libroDB = libroRepository.findById(id).get();
		BeanUtils.copyProperties(libro, libroDB, "id");
		return libroRepository.save(libroDB);
	}
	
	@Override
	public ResponseEntity<Optional<Libro>> getLibroById(long id) {
		Optional<Libro> libro = libroRepository.findById(id);
		return ResponseEntity.ok().body(libro);
	}
}
