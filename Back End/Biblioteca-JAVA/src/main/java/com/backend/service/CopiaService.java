package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.backend.model.Copia;

public interface CopiaService {
	List<Copia> getAllCopias();
	List<Copia> copiasDisponibles();
	ResponseEntity<Optional<Copia>> getCopiaById(long id);
	Copia addCopia(Copia copia);
	Copia editCopia(long id, Copia copia);
	void deleteCopiaById(long id);
	Copia buscarCopia(Copia copia);
}
