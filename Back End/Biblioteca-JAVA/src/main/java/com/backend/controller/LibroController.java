package com.backend.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.model.Libro;
import com.backend.service.CopiaService;
import com.backend.service.LectorService;
import com.backend.service.LibroService;
import com.backend.service.PrestamoService;

@RestController
@RequestMapping(value = "/api")
public class LibroController {
	@Autowired
	LibroService libroService;
	
	@Autowired
	PrestamoService prestamoService;
	
	@Autowired
	LectorService lectorService;
	
	@Autowired
	CopiaService copiaService;
	
	@GetMapping(value = "/libros")
	public List<Libro> getAll(){
		return libroService.getAllLibros();
	}
	
	@GetMapping(value = "/libros/{id}")
	public ResponseEntity<Optional<Libro>>getById(@PathVariable(value = "id") long id) {
		return libroService.getLibroById(id);
	}
	
	@PostMapping(value = "/libros")
	public Libro add(@RequestBody Libro libro) {
		return libroService.addLibro(libro);
	}
	
	@DeleteMapping(value = "/libros/{id}")
	public void delete(@PathVariable("id") long id) {
		libroService.deleteLibroById(id);
	}
	
	@PutMapping(value = "/libros/{id}")
	public Libro edit(@PathVariable("id") long id, @RequestBody Libro libro) {
		return libroService.editLibro(id, libro);
	}
}
