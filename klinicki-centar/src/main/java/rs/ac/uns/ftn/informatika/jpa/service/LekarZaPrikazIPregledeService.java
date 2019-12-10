package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;

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
	

	
}
