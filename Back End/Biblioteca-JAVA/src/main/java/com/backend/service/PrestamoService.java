package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.backend.model.Prestamo;

public interface PrestamoService {
	List<Prestamo> getAllPrestamos();
	List<Prestamo> prestamosPorLector(long id);
	List<Prestamo> prestamosActivos();
	List<Prestamo> prestamosActivosPorLector(long id);
	ResponseEntity<Optional<Prestamo>> getPrestamoById(long id);
	Prestamo editPrestamo(long id, Prestamo prestamo);
	Prestamo addPrestamo(Prestamo prestamo);
	Prestamo devolverPrestamo(long id, Prestamo prestamo);
	void deletePrestamoById(long id);
}
