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
import com.backend.model.Lector;
import com.backend.service.LectorService;

@RestController
@RequestMapping(value = "/api")
public class LectorController {
	@Autowired
	LectorService lectorService;
	
	@GetMapping(value = "/lectores")
	public List<Lector> getAll(){
		return lectorService.getAllLectores();
	}
	
	@GetMapping("/lectores/{id}")
	public ResponseEntity<Optional<Lector>>geById(@PathVariable(value = "id") long id) {
		return lectorService.getLectorById(id);
	}
	
	@PostMapping(value = "/lectores")
	public Lector add(@RequestBody Lector lector) {
		return lectorService.addLector(lector);
	}
	
	@DeleteMapping("/lectores/{id}")
	public void delete(@PathVariable("id") long id) {
		lectorService.deleteLectorById(id);
	}
	
	@PutMapping("/lectores/{id}")
	public Lector edit(@PathVariable("id") long id , @RequestBody Lector lector) {
		return lectorService.editLector(id, lector);
	}
}
