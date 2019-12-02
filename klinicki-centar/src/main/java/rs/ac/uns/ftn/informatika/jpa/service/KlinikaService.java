package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;

@Service
@Transactional
public class KlinikaService {

	private final KlinikaRepository klinikaRepository;
	
	public KlinikaService(KlinikaRepository klinikaRepository) {
		this.klinikaRepository=klinikaRepository;
	}
	
	public List<Klinika> pokaziSveKlinike() {
		// TODO Auto-generated method stub
		List<Klinika> klinike=new ArrayList<Klinika>();
		for(Klinika klinika : klinikaRepository.findAll()) {
			klinike.add(klinika);
		}
		return klinike;
	}
	
}
