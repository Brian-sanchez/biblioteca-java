package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long> {
}
