package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Sala;
import rs.ac.uns.ftn.informatika.jpa.repository.SalaRepository;

@Service
@Transactional
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepo;
	
	public Sala findOneById(Long id) {
		
		return salaRepo.findOneById(id);
	}

	public List<Sala> pokaziSveSale() {
		// TODO Auto-generated method stub
		List<Sala> sale = new ArrayList<Sala>();
		for(Sala sala : salaRepo.findAll()) {
			sale.add(sala);
		}
		return sale;
	}
}
