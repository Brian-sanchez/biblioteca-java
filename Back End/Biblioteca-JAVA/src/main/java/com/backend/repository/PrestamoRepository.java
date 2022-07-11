package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
