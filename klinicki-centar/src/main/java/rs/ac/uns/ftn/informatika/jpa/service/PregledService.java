package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;

@Service
@Transactional
public class PregledService {
	
	@Autowired
	private PregledRepository pregledRepo;
	
	public PregledService(PregledRepository pregledRepo) {
		this.pregledRepo = pregledRepo;
	}
	
	public List<Pregled> pokaziSvePreglede(){
		List<Pregled> allP = new ArrayList<Pregled>();
		for(Pregled pregled : pregledRepo.findAll()) {
			allP.add(pregled);
		}
		return allP;
	}
	
	
	public void obrisi(Long id) {
		pregledRepo.deleteById(id);
	}
	
	public void dodajPregled(Pregled p) {
		
		pregledRepo.save(p);
	}
	
	public Pregled findOneById(Long id) {
		
		return pregledRepo.findOneById(id);
	}
	
	public Pregled findByDatum(String datum) {
		
		return pregledRepo.findByDatum(datum);
	}	
	
	public Pregled findByVreme(String vreme) {
		
		return pregledRepo.findByVreme(vreme);
	}
	
}
	/*public Pregled findByDate(String date) {
		
		return pregledRepo.findByDate(date);
	}
/*
@Service
@Transactional
public class PregledService {

		private final PregledRepository prepo;
		
		public PregledService(PregledRepository prepo) {
			this.prepo=prepo;
		}
		
		public List<Pregled> pokaziSvePreglede() {
			// TODO Auto-generated method stub
			List<Pregled> pregledi=new ArrayList<Pregled>();
			for(Pregled pregled : prepo.findAll()) {
				pregledi.add(pregled);
			}
			return pregledi;
		}
	

}
*/