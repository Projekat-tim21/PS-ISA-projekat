package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.OdobravanjePregleda;
import rs.ac.uns.ftn.informatika.jpa.repository.OdobravanjePregledaRepozitorijum;

@Service
@Transactional
public class OdobravanjePregledaService {

private final OdobravanjePregledaRepozitorijum repo;
	

	public OdobravanjePregledaService(OdobravanjePregledaRepozitorijum repo) {
		this.repo=repo;
	}
	
	public void sacuvaj(OdobravanjePregleda op) {
		repo.save(op);
	}

	public List<OdobravanjePregleda> pokaziSveZahteveZaPregledom() {
		// TODO Auto-generated method stub
		List<OdobravanjePregleda> opi=new ArrayList<OdobravanjePregleda>();
		for(OdobravanjePregleda op : repo.findAll()) {
			opi.add(op);
		}
		return opi;
	}
	
	public OdobravanjePregleda findOne(Long id) {
		return repo.findById(id).orElseGet(null);
	}
	
}
