package com.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.backend.model.Multa;

public interface MultaService {
	List<Multa> getAllMultas();
	ResponseEntity<Optional<Multa>> getMultaById(long id);
	Multa addMulta(Multa multa);
	Multa editMulta(long id, Multa multa);
	void deleteMultaById(long id);
}
