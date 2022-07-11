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
import com.backend.model.Copia;
import com.backend.service.CopiaService;
import com.backend.service.LibroService;
import com.backend.service.PrestamoService;

@RestController
@RequestMapping(value = "/api")
public class CopiaController {
	@Autowired
	CopiaService copiaService;
	@Autowired
	LibroService libroService;
	@Autowired
	PrestamoService prestamoService;
	
	@GetMapping("/copias")
	public List<Copia> getAll() {
		return copiaService.getAllCopias();
	}
	
	@GetMapping("/copias/{id}")
	public ResponseEntity<Optional<Copia>>geById(@PathVariable(value = "id") long id) {
		return copiaService.getCopiaById(id);
	}
	
	@GetMapping("/copias/disponibles")
	public List<Copia> copiasDisponibles() {
		return copiaService.copiasDisponibles();
	}
	
	@PostMapping(value = "/copias")
	public Copia add(@RequestBody Copia copia) {
		return copiaService.addCopia(copia);
	}
	
	@PutMapping(value = "/copias/edit/{id}")
	public Copia edit(@PathVariable("id") long id, @RequestBody Copia copia) {
		return copiaService.editCopia(id, copia);
	}
	
	@DeleteMapping(value = "/copias/{id}")
	public void delete(@PathVariable("id") long id) {
		copiaService.deleteCopiaById(id);
	}
}
