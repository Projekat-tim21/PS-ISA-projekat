package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;

@Service
@Transactional
public class TerminSaIdService {

	private TerminSaIdRepository tidRepo;

	
	public TerminSaIdService(TerminSaIdRepository tidRepo) {
		this.tidRepo=tidRepo;
	}


	public void saveMojTermin(TerminiSaId termini) {
		// TODO Auto-generated method stub
		tidRepo.save(termini);
	}
	
	
	public List<TerminiSaId> pokaziSveTermine() {
		// TODO Auto-generated method stub
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findAll()) {
			termini.add(termin);
		}
		return termini;
	}
	
	public TerminiSaId findOne(Long id) {
		return tidRepo.findById(id).orElseGet(null);
	}


	public void deleteMyTermin(long id) {
		// TODO Auto-generated method stub
		tidRepo.deleteById(id);
	}

	public List<TerminiSaId> getTerminiByLekarId(Long id) {
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId t : tidRepo.findByLekarId(id)) {
			termini.add(t);
		}
		return termini;
	}
	

	
	
	
}
