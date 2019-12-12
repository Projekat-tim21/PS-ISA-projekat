package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DijagnozaDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.repository.DijagnozaRepository;

@Service
@Transactional
public class DijagnozaServiceImpl {
	
	private final DijagnozaRepository dijagnozaRepository;
	
	public DijagnozaServiceImpl(DijagnozaRepository dijagnozaRepository) {
		this.dijagnozaRepository=dijagnozaRepository;
	}

	DijagnozaDTO dijagnozaDTO;
	
	public Dijagnoza findBySifra(String sifra) {
		return dijagnozaRepository.findBySifra(sifra);
	}
	
	public Dijagnoza findDijagnozaById(Long id) {
        return dijagnozaRepository.findOneById(id);
    }
	
	public void sacuvajDijagnozu(Dijagnoza dijagnoza) {
		dijagnozaRepository.save(dijagnoza);
	}
	
	public List<Dijagnoza> showAll(){
		List<Dijagnoza> dijagnoze=new ArrayList<Dijagnoza>();
		for(Dijagnoza dijagnoza:dijagnozaRepository.findAll()) {
			dijagnoze.add(dijagnoza);
		}
		return dijagnoze;
		
	}
	
	public void obrisiDijagnozu(Long id) {
		dijagnozaRepository.deleteById(id);;
	}

	
}
