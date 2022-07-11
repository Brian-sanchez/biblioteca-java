package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.model.Copia;
import com.backend.model.EstadoCopia;
import com.backend.repository.CopiaRepository;

@Service
public class CopiaServiceImpl implements CopiaService {
	@Autowired
	CopiaRepository copiaRepository;
	
	@Override
	public List<Copia> getAllCopias() {
		return copiaRepository.findAll();
	}

	@Override
	public Copia addCopia(Copia copia) {
		copia.setEstado(EstadoCopia.BIBLIOTECA);
		return copiaRepository.save(copia);
	}

	@Override
	public Copia buscarCopia(Copia copia) {
		return this.copiaRepository.findById(copia.getId()).orElse(null);
	}

	@Override
	public void deleteCopiaById(long id) {
		this.copiaRepository.deleteById(id);
	}

	@Override
	public List<Copia> copiasDisponibles() {
		var allCopias = this.getAllCopias();
		List<Copia> copias = new ArrayList<>();

		for (Copia copia : allCopias) {
			if (copia.getEstado() == EstadoCopia.BIBLIOTECA) {
				copias.add(copia);
			}
		}

		return copias;
	}

	@Override
	public ResponseEntity<Optional<Copia>> getCopiaById(long id) {
		Optional<Copia> copia = copiaRepository.findById(id);
		return ResponseEntity.ok().body(copia);
	}

	@Override
	public Copia editCopia(long id, Copia copia) {
		Copia copiaDB = copiaRepository.findById(id).get();
		BeanUtils.copyProperties(copia, copiaDB, "id");
		return copiaRepository.save(copiaDB);
	}
}
