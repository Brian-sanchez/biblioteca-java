package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.model.Lector;
import com.backend.repository.LectorRepository;

@Service
public class LectorServiceImpl implements LectorService{
	@Autowired
	private LectorRepository lectorRepository;

	@Override
	public List<Lector> getAllLectores() {
		return lectorRepository.findAll();
	}

	@Override
	public Lector addLector(Lector lector) {
		return lectorRepository.save(lector);
	}

	@Override
	public void deleteLectorById(long id) {
		this.lectorRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<Optional<Lector>> getLectorById(long id) {
		Optional<Lector> lector = lectorRepository.findById(id);
		return ResponseEntity.ok().body(lector);
	}

	@Override
	public Lector editLector(long id, Lector lector) {
		Lector lectorDB = lectorRepository.findById(id).get();
		BeanUtils.copyProperties(lector, lectorDB, "id");
		return lectorRepository.save(lectorDB);
	}
}
