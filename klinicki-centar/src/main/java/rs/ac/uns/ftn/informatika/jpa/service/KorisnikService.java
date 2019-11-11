package rs.ac.uns.ftn.informatika.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;

@Service
@Transactional
public class KorisnikService {

	private final KorisnikRepository korisnikRepository;
	
	public KorisnikService(KorisnikRepository korisnikRepository) {
		this.korisnikRepository=korisnikRepository;
	}
	
	public void saveMogKorisnika(Korisnik k) {
		korisnikRepository.save(k);
	}	
}
