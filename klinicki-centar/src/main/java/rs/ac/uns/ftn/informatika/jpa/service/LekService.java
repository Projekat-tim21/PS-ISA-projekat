package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.uns.ftn.informatika.jpa.model.Lek;


public interface LekService {

	 Page<Lek> listUsers(Pageable pageable);
}

