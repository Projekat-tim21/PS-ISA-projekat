package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarIPregledi;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;

@Service
@Transactional
public class LekarZaPrikazIPregledeService {

	private final LekarZaPrikazIPregledeRepository lipRepo;
	
	
	
	public LekarZaPrikazIPregledeService(LekarZaPrikazIPregledeRepository lipRepo) {
		this.lipRepo=lipRepo;
	}
	
	
	public List<LekarZaPrikazIPreglede> pokaziSveKorisnikeKojiSuLekari() {
		List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
			lipi.add(lip);
		}
		return lipi;
	}
	
	public LekarZaPrikazIPreglede findOne(Long id) {
		return lipRepo.findById(id).orElseGet(null);
	}
	

	public void saveMojLekar(LekarZaPrikazIPreglede lip) {
		lipRepo.save(lip);
	}


	public void saveOcenaLekara(double prosek,long lekarid) {
		// TODO Auto-generated method stub
		
		List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
			if(lip.getId()==lekarid) {
				LekarZaPrikazIPreglede lip2=new LekarZaPrikazIPreglede();
				lip2.setId(lekarid);
				lip2.setOcena(prosek);
				lip2.setImelek(lip.getImelek());
				lip2.setPrezimelek(lip.getPrezimelek());
				lip2.setTipspecijalizacije(lip.getTipspecijalizacije());
				lip2.setUloga(lip.getUloga());
				lipRepo.save(lip2);
				
			}
		}
	}


	public LekarZaPrikazIPreglede pronadji(Long id) {
		// TODO Auto-generated method stub
		return lipRepo.findByLekarveza(id);
	}


	public LekarZaPrikazIPreglede findVeza(Long lekarId) {
		// TODO Auto-generated method stub
		return lipRepo.findByLekarveza(lekarId);
				
	}


}
