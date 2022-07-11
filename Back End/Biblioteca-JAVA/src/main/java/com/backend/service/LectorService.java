package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.backend.model.Lector;

public interface LectorService {
	List<Lector> getAllLectores();
	Lector addLector(Lector lector);
	Lector editLector(long id, Lector lector);
	ResponseEntity<Optional<Lector>> getLectorById(long id);
	void deleteLectorById(long id);
}
