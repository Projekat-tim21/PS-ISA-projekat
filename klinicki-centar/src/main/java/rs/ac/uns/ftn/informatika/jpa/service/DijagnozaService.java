package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;

public interface DijagnozaService {

	Page<Dijagnoza> listUsers(Pageable pageable);
	}

