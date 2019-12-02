package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;
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
