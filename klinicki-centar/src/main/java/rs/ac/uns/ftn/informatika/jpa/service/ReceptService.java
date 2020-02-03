package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Recept;
import rs.ac.uns.ftn.informatika.jpa.repository.ReceptRepository;

@Service
public class ReceptService {
	
	public final ReceptRepository recRepo;

	public ReceptService(ReceptRepository recRepo) {
		super();
		this.recRepo = recRepo;
	}
	
	public void save(Recept recept) {
		recRepo.save(recept);
	}

}
