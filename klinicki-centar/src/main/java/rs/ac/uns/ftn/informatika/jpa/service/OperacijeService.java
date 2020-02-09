package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.OperacijeRepository;

@Service
@Transactional
public class OperacijeService {

	private final OperacijeRepository orepo;

	public OperacijeService(OperacijeRepository orepo) {
		this.orepo = orepo;
	}

	public List<Operacija> pokaziSveOperacije() {
		// TODO Auto-generated method stub
		List<Operacija> operacije = new ArrayList<Operacija>();
		for (Operacija operacija : orepo.findAll()) {
			operacije.add(operacija);
		}
		return operacije;
	}

	public Operacija findOneById(Long id) {
		
		return orepo.findOneById(id);
	}

	public void save(Operacija o) {
		// TODO Auto-generated method stub
		orepo.save(o);
	}

	public List<Operacija> pokaziSveBezSale() {
		List<Operacija> operacije = new ArrayList<Operacija>();
		for (Operacija operacija : orepo.findAll()) {
			if(operacija.getSala()==null && operacija.getTerminoperacija()!=null && operacija.getObradjen()==false) {
				operacije.add(operacija);
			}else {
			}
	}
		return operacije;
	}

	public Operacija terminZauzet(String terminpregled,Long id) {
		// TODO Auto-generated method stub
		return orepo.findByTerminoperacijaAndKorisnikId(terminpregled,id);
	}
	

}
