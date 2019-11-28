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
	
	
	KorisnikDTO korDto;
	
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
	
	//public Korisnik findAllData(Long id, String username, String ime, String prezime, String jedBrOsig, String email, String adresa, String grad, String drzava, String telefon, String password) {
	//	return korisnikRepository.findAllData(id, username, ime, prezime, jedBrOsig, email, adresa, grad, drzava, telefon, password);
	//}
	
	public Korisnik findByUsernameAndPassword(String username, String password) {
		return korisnikRepository.findByUsernameAndPassword(username, password);
	}
	
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByUsername(username);
	}
	

	public Korisnik findOne(Long id) {
		return korisnikRepository.findById(id).orElseGet(null);
	}

	public Object editUser2(Long id) {
		return korisnikRepository.findById(id);
	}
	
	
	
	public Korisnik editUser(Long id) {
		return korisnikRepository.findOneById(id);
	}
	
	/*public Korisnik editUserByUsername(String username) {
		return korisnikRepository.findByUsername(username);
	}*/

	public void deleteMyUser(Long id) {
		korisnikRepository.deleteById(id);
	}
	
	
	

	

	
}
