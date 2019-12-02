package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.LekDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.repository.LekRepository;

@Service
@Transactional
public class LekService {
	
	private final LekRepository lekRepository;
	
	public LekService(LekRepository lekRepository) {
		this.lekRepository=lekRepository;
	}

	LekDTO lekDTO;
	
	public void sacuvajLek(Lek lek) {
		lekRepository.save(lek);
	}
	
	public List<Lek> showAll(){
		List<Lek> lekovi=new ArrayList<Lek>();
		for(Lek lek:lekRepository.findAll()) {
			lekovi.add(lek);
		}
		return lekovi;
		
	}
	
	public void obrisiLek(Long id) {
		lekRepository.deleteById(id);;
	}
}
