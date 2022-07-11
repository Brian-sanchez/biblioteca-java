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
import com.backend.model.Multa;
import com.backend.service.MultaService;

@RestController
@RequestMapping(value = "/api")
public class MultaController {
	@Autowired
	MultaService multaService;

	@GetMapping(value = "/multas")
	public List<Multa> getAll(){
		return multaService.getAllMultas();
	}

	@GetMapping(value = "/multas/{id}")
	public ResponseEntity<Optional<Multa>> getById(@PathVariable(value = "id") long id) {
		return multaService.getMultaById(id);
	}
	
	@PostMapping(value = "/multas")
	public String add(@RequestBody Multa multa) {
		return multaService.addMulta(multa);
	}
	
	@PutMapping(value = "/multas/{id}")
	public Multa edit(@PathVariable("id") long id, @RequestBody Multa multa) {
		return multaService.editMulta(id, multa);
	}
	
	@DeleteMapping(value = "/multas/{id}")
	public void delete(@PathVariable("id") long id) {
		multaService.deleteMultaById(id);
	}
	
//	@GetMapping("/update/{id}")
//	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
//
//		Multa multaa = multa.getMultaById(id);
//		model.addAttribute("multaa", multaa);
//		return "update_multa";
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String deleteCourse(@PathVariable (value = "id") long id) {
//		this.multa.deleteMultaById(id);
//		return "redirect:/";
//	}
//	
//	@PostMapping
//	public String agregar(@RequestBody Multa m) {
//		multa.saveMulta(m);
//		return "redirect:/";
//	}
}
