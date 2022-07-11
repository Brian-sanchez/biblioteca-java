package com.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.model.Lector;
import com.backend.model.Libro;
import com.backend.model.Multa;
import com.backend.model.Prestamo;
import com.backend.repository.LectorRepository;
import com.backend.repository.LibroRepository;
import com.backend.repository.MultaRepository;
import com.backend.repository.PrestamoRepository;

@Service
public class MultaServiceImpl implements MultaService {
	@Autowired
	private MultaRepository multaRepository;
	@Autowired
	private LectorRepository lectorRepository;
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Override
	public List<Multa> getAllMultas() {
		return multaRepository.findAll();
	}

	@Override
	public Multa editMulta(long id, Multa multa) {
		Multa multaDB = multaRepository.findById(id).get();
		BeanUtils.copyProperties(multa, multaDB, "id");
		return multaRepository.save(multaDB);
	}

	@Override
	public String addMulta(Multa multa) {
		/*
		Lector lector = lectorRepository.findById(multa.getmLectorID()).get();
		Libro libro = libroRepository.findById(multa.getmLibroID()).get();
		Prestamo prestamo = prestamoRepository.findById(multa.getPrestamoID()).get();
		LocalDate ultimoDia = prestamo.getFin();
		//LocalDate diaDespues = multa.getInicioM();
		
		if (LocalDate.now() == ultimoDia.plusDays(1)) {
			libro.setEstado("retraso");			
			libroRepository.save(libro);
			multaRepository.save(multa);
			
			return lector.getNombre() + " ha sido multado por no devolver el libro: " + libro.getTitulo() + " en tiempo y forma";
		}
		/*
		else if (libro.getEstado().equals("retraso") && LocalDate.now() == diaDespues.plusDays(1)) { // Este if tiene que ir en el controller
			// asi se va sumando los dias de multa
			LocalDate dosDias = diaDespues.plusDays(2);
			multa.setFinM(dosDias);
			return lector.getNombre() + " ha sido multado por 2 dias mas ya que no devolvio el libro: " + libro.getTitulo();
		}
		*/
		
		/*
		libro.setEstado("retraso");
		libroRepository.save(libro);
		multaRepository.save(multa);
		*/
		
		return "Lector: "  + ", no multado ya que no tiene ningun libro en retraso o devolvio en tiempo y forma el libro prestado";
	}

	@Override
	public void deleteMultaById(long id) {
		this.multaRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<Optional<Multa>> getMultaById(long id) {
		Optional<Multa> multa = multaRepository.findById(id);
		return ResponseEntity.ok().body(multa);
	}
}
