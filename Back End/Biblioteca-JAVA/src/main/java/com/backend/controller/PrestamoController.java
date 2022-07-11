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
import com.backend.model.Prestamo;
import com.backend.service.CopiaService;
import com.backend.service.LectorService;
import com.backend.service.LibroService;
import com.backend.service.PrestamoService;

@RestController
@RequestMapping(value = "/api")
public class PrestamoController {
	@Autowired
	PrestamoService prestamoService;
	
	@Autowired
	LibroService libroService;
	
	@Autowired
	LectorService lectorService;
	
	@Autowired
	CopiaService copiaService;
	
	@GetMapping(value = "/prestamos")
	public List<Prestamo> getAll(){
		return prestamoService.getAllPrestamos();
	}

	@GetMapping(value = "/prestamos/{id}")
	public ResponseEntity<Optional<Prestamo>> getById(@PathVariable(value = "id") long id) {
		return prestamoService.getPrestamoById(id);
	}
	
	@GetMapping(value = "/prestamos/activos")
	public List<Prestamo> activos() {
		return prestamoService.prestamosActivos();
	}
	
	/*
	@GetMapping(value = "/prestamos/retrasados")
	public List<Prestamo> retrasados() {
		return prestamoService.prestamosRetrasados();
	}
	*/
	@GetMapping(value = "/prestamos/lector/{id}")
	public List<Prestamo> prestamosPorLector(@PathVariable(value = "id") long id) {
		return prestamoService.prestamosPorLector(id);
	}
	
	@GetMapping(value = "/prestamos/lector/activos/{id}")
	public List<Prestamo> prestamosActivosPorLector(@PathVariable(value = "id") long id) {
		return prestamoService.prestamosActivosPorLector(id);
	}
	
	@PostMapping(value = "/prestamos/prestar")
	public Prestamo add(@RequestBody Prestamo prestamo) {
		return prestamoService.addPrestamo(prestamo);
	}
	
	@PutMapping(value = "/prestamos/devolver/{id}")
	public Prestamo devolver(@PathVariable("id") long id, Prestamo prestamo) {
		return prestamoService.devolverPrestamo(id, prestamo);
	}
	
	@PutMapping(value = "/prestamos/edit/{id}")
	public Prestamo edit(@PathVariable("id") long id, @RequestBody Prestamo prestamo) {
		return prestamoService.editPrestamo(id, prestamo);
	}
	
	@DeleteMapping(value = "/prestamos/{id}")
	public void delete(@PathVariable("id") long id) {
		prestamoService.deletePrestamoById(id);
	}
}
