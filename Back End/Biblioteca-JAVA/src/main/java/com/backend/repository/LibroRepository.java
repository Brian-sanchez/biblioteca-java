package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
	
}
