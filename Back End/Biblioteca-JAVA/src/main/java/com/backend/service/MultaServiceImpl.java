package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend.model.Multa;
import com.backend.repository.MultaRepository;

@Service
public class MultaServiceImpl implements MultaService {
	@Autowired
	private MultaRepository multaRepository;
	
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
	public void deleteMultaById(long id) {
		this.multaRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<Optional<Multa>> getMultaById(long id) {
		Optional<Multa> multa = multaRepository.findById(id);
		return ResponseEntity.ok().body(multa);
	}

	@Override
	public Multa addMulta(Multa multa) {
		return multaRepository.save(multa);
	}
}
