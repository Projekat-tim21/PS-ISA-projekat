package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;

@Service
@Transactional
public class KorisnikService {

	private final KorisnikRepository korisnikRepository;
	
	@Autowired
	private PregledRepository pregledRepo;
	
	KorisnikDTO korDto;
	
	public KorisnikService(KorisnikRepository korisnikRepository) {
		this.korisnikRepository=korisnikRepository;
	}
	
	public void saveMogKorisnika(Korisnik korisnik) {
		korisnikRepository.save(korisnik);
	}
	
/*	public void sacuvajKarton(Korisnik korisnik) {
		korisnikRepository.sacuvajUKarton(korisnik);
	}*/

	public List<Korisnik> pokaziSveKorisnike() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findAll()) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}
	
	
	
	public List<Korisnik> pokaziSveZahteve() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("PACIJENT")) {
			if(korisnik.getIsActive()==false) {
				korisnici.add(korisnik);
			}
		}
		return korisnici;
	}
	

	public List<Korisnik> pokaziSvePacijente() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("PACIJENT")) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}
	
	public List<Korisnik> pokaziAdmineKlinike() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("ADMIN_KLINIKE")) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}
	
	public List<Korisnik> pokaziAdmine() {
		// TODO Auto-generated method stub
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("ADMIN")) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}
	
	public List<Korisnik> pokaziBezKartona(){
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("PACIJENT")) {
			if(korisnik.getDatum()==null && korisnik.getPol()==null && korisnik.getIsActive()==true &&(korisnik.getFirst_Login()!=false || korisnik.getFirst_Login()!=null)) {
				korisnici.add(korisnik);
			}
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
/*
	public void saveDatum(LekarIPregledi novidatum) {
		// TODO Auto-generated method stub
		korisnikRepository.saveDatum(novidatum);
	}
*/

	public List<Korisnik> pokaziLekare() {
		List<Korisnik> korisnici=new ArrayList<Korisnik>();
		for(Korisnik korisnik : korisnikRepository.findByRoleName("LEKAR")) {
			korisnici.add(korisnik);
		}
		return korisnici;
	}

	

	


	//public Korisnik findById(String id) {
	//	return korisnikRepository.findById(id);
	//}

	//public Korisnik findByIdLong(Long id) {
	//	// TODO Auto-generated method stub
	//	return korisnikRepository.findById(id);
	//}
	
	
	 /*   public Page<Korisnik> listUsers(Pageable pageable) {
	        return korisnikRepository.findAll(pageable);
	    }*/

	

	
}
