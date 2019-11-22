package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;

@Service
@Transactional
public class KorisnikService {

	private final KorisnikRepository korisnikRepository;
	
	public KorisnikService(KorisnikRepository korisnikRepository) {
		this.korisnikRepository=korisnikRepository;
	}
	
	public void saveMogKorisnika(Korisnik korisnik) {
		korisnikRepository.save(korisnik);
	}

	public List<Korisnik> pokaziSveKorisnike() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findAll()) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}	
	
	public Korisnik findByUsernameAndPassword(String username, String password) {
		return korisnikRepository.findByUsernameAndPassword(username, password);
	}
	
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByUsername(username);
	}
	

}
