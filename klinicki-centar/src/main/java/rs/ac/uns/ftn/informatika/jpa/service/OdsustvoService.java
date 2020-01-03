package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Odsustvo;
import rs.ac.uns.ftn.informatika.jpa.repository.OdsustvoRepository;

@Service
@Transactional
public class OdsustvoService {

	private final OdsustvoRepository orepo;

	public OdsustvoService(OdsustvoRepository orepo) {
		this.orepo = orepo;
	}
	
	public List<Odsustvo> pokaziSvaOdsustvaOdobrena(){
		List<Odsustvo> odsustva=new ArrayList<Odsustvo>();
		for(Odsustvo o:orepo.findAll()) {
			if(o.isOdobren()==true) {
				odsustva.add(o);
			}
		}
		return odsustva;
		
	}
	
	public List<Odsustvo> pokaziSvaOdsustvaZaOdobravanje(){
		List<Odsustvo> odsustva=new ArrayList<Odsustvo>();
		for(Odsustvo o:orepo.findAll()) {
			if(o.isOdobren()==false) {
				odsustva.add(o);
			}
		}
		return odsustva;
		
	}
	
	public Odsustvo findOne(Long id) {
		return orepo.findById(id).orElseGet(null);
	}

	public void saveOdsutvo(Odsustvo odsustvo) {
		// TODO Auto-generated method stub
		System.out.println("Pokusaj cuvanja");
		orepo.save(odsustvo);
		
		System.out.println("Uspesno sacuvano");
	}
	
	public void deleteOdsustvo(long id) {
		// TODO Auto-generated method stub
		orepo.deleteById(id);
	}
	
}
