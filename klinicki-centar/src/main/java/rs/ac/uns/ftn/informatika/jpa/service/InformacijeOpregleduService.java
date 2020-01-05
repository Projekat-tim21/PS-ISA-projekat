package rs.ac.uns.ftn.informatika.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.repository.InforimacijeOpregleduRepository;

@Service
@Transactional
public class InformacijeOpregleduService {

	private final InforimacijeOpregleduRepository infoRepo;

	public InformacijeOpregleduService(InforimacijeOpregleduRepository info) {
		super();
		this.infoRepo = info;
	}
	
	public void saveInformacije(InformacijeOpregledu info) {
		infoRepo.save(info);
	}
	
}
