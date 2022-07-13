package com.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.model.Copia;
import com.backend.model.EstadoCopia;
import com.backend.model.Lector;
import com.backend.model.Libro;
import com.backend.model.Prestamo;
import com.backend.repository.CopiaRepository;
import com.backend.repository.LectorRepository;
import com.backend.repository.LibroRepository;
import com.backend.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	LectorService lectorService;
	
	@Autowired
	private LectorRepository lectorRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private CopiaRepository copiaRepository;
	
	@Override
	public List<Prestamo> getAllPrestamos() {
		return prestamoRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Optional<Prestamo>> getPrestamoById(long id) {
		Optional<Prestamo> prestamo = prestamoRepository.findById(id);
		return ResponseEntity.ok().body(prestamo);
	}

	@Override
	public List<Prestamo> prestamosPorLector(long id) {
		var allPrestamos = this.getAllPrestamos();
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : allPrestamos) {
			if (prestamo.getLector().getId().equals(id)) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	public Prestamo addPrestamo(Prestamo prestamo) {
		Copia copia = copiaRepository.findById(prestamo.getCopia().getId()).get();
		Lector lector = lectorRepository.findById(prestamo.getLector().getId()).get();
		Libro libro = libroRepository.findById(prestamo.getLibro().getId()).get();
		long lectorId = lector.getId();
		
		var cantPrestamosActivosLector = this.prestamosActivosPorLector(lectorId).size();
		
		if (cantPrestamosActivosLector >= Prestamo.LIMITE_PRESTAMOS) {			
			throw new RuntimeException("El lector: " + lector.getNombre() + " no puede pedir prestado mas de 3 libros");
		}
		
		Prestamo prestamoP = new Prestamo();
		prestamoP.setLibro(libro);
		prestamoP.setCopia(copia);
		prestamoP.setLector(lector);
		prestamoP.setInicio(LocalDate.now());
		prestamoP.setFin(LocalDate.now().plusDays(30));
		copia.setEstado(EstadoCopia.PRESTADO);

		return prestamoRepository.save(prestamoP);
	}

	@Override
	public Prestamo devolverPrestamo(long id, Prestamo prestamo) {
		Prestamo prestamoDB = prestamoRepository.findById(id).get();
		prestamoDB.setFin(LocalDate.now());
		prestamoDB.getCopia().setEstado(EstadoCopia.BIBLIOTECA);
		return prestamoRepository.save(prestamoDB);
	}
	
	@Override
	public void deletePrestamoById(long id) {
		Prestamo prestamoDB = prestamoRepository.findById(id).get();
		prestamoDB.getCopia().setEstado(EstadoCopia.BIBLIOTECA);
		this.prestamoRepository.deleteById(id);
	}

	@Override
	public Prestamo editPrestamo(long id, Prestamo prestamo) {
		Prestamo prestamoDB = prestamoRepository.findById(id).get();
		BeanUtils.copyProperties(prestamo, prestamoDB, "id");
		prestamoDB.setInicio(prestamo.getInicio());
		prestamoDB.setFin(prestamo.getFin());
		return prestamoRepository.save(prestamoDB);
	}

	@Override
	public List<Prestamo> prestamosActivos() {
		var allPrestamos = this.getAllPrestamos();
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : allPrestamos) {
			if (prestamo.getCopia().getEstado() == EstadoCopia.PRESTADO) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	public List<Prestamo> prestamosActivosPorLector(long id) {
		var prestamosLector = this.prestamosPorLector(id);
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : prestamosLector) {
			if (prestamo.getCopia().getEstado() == EstadoCopia.PRESTADO) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}
}
