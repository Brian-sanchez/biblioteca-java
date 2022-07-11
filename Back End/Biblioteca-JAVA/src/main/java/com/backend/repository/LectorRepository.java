package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.model.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {
	Lector findByNombre(String nombre);
}
