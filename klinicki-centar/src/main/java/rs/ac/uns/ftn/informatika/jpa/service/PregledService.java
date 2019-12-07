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
	
	@Autowired 
	private KorisnikService korisnikS;
	
	@Autowired 
	private AdminService adminS;
	
	public PregledService(PregledRepository pregledRepo) {
		this.pregledRepo = pregledRepo;
	}
	
	public List<Pregled> findAll(){
		List<Pregled> allP = new ArrayList<Pregled>();
		for(Pregled pregled : pregledRepo.findAll()) {
			allP.add(pregled);
		}
		return allP;
		
	}
	
	/*public List<Pregled> nadjiSve(){
		
		List<Pregled> sviDatumi = new ArrayList<Pregled>();
		List<Pregled> svi = new ArrayList<Pregled>();
		
		for(Pregled pr : pregledRepo.findAll()) {
			for(Pregled listDatu : pregledRepo.findByDatum()) {
			
				System.out.println("f");
				if(pr.getZakazan()==false) {
					System.out.println("caooooo");
					//svi.add(pr);
					svi.add(listDatu);
					System.out.println();
			}
				
		}
				
			
		}
		return svi;
	}*/
	
	public Pregled findOneById(Long id) {
		
		return pregledRepo.findOneById(id);
	}
	
	public Pregled findByDatum(String datum) {
		
		return pregledRepo.findByDatum(datum);
	}	
	
	public Pregled findByVreme(String vreme) {
		
		return pregledRepo.findByVreme(vreme);
	}
	/*
	public Boolean findByZakazan(Boolean zakazan) {
		
		return pregledRepo.findByZakazan(zakazan);
	}*/
	/*
	public List<Pregled> ListaBooleanZakazan(){
		List<Pregled> zakazani = new ArrayList<Pregled>();
		for(Pregled zakazan : pregledRepo.findByZakazan()) {
			zakazani.add(zakazan);
		}
		return zakazani;
	}*/
	//ne diratiiii
	/*public List<Pregled> ListaDatuma(){
		List<Pregled> allDATUMI = new ArrayList<Pregled>();
		//List<Pregled>()=new List<Pregled>
		for(Pregled listDatu : pregledRepo.findByDatum()) {
			for(Pregled listZakazan: pregledRepo.findByDatum()) {
				System.out.println(listZakazan);
				if(listZakazan.getZakazan()==false) {
					System.out.println("caooooo");
					allDATUMI.add(listDatu);
					System.out.println(allDATUMI.add(listDatu));
				}
			}
				
				
			
		}
		return allDATUMI;
	}*/
	//public Pregled findByVremeDatum(String vreme, String datum) {
	//	return pregledRepo.findByVremeDatum(vreme, datum);
	//}
	
	public void obrisi(Long id) {
		pregledRepo.deleteById(id);
	}
	
	public void dodajPregled(Pregled p) {
		
		pregledRepo.save(p);
	}
	
	
	/*public ArrayList<Pregled> slobodniPregledi(Long id, Boolean zakazan) {
		
		Boolean p = pregledRepo.findByZakazan(zakazan);
		
		ArrayList<Pregled> slobodniDatumi = new ArrayList<Pregled>();
		
		
		if(p.getZakazan() == false) {
			slobodniDatumi.add(p);
			
		} 
		
		return slobodniDatumi;
		
	}
	*/
	/*public ArrayList<Pregled> slobodniPreglediV(Long id, Boolean zakazan) {
		
		Boolean p = pregledRepo.findByZakazan(zakazan);
		
		ArrayList<Pregled> slobodnaVremena = new ArrayList<Pregled>();
		
		
		if(p.getZakazan() == false) {
			slobodnaVremena.add(p);
			
		} 
		
		return slobodnaVremena;
		
	}
	*/
	
	
	
}
	/*public ArrayList<Pregled> prihvatiZahtev(String vreme, String datum){
		
		Pregled p = pregledRepo.findByDatum(datum);
		Pregled pr = pregledRepo.findByVreme(vreme);
		
		//System.out.println("PRIHVACENO");
		
		ArrayList<Pregled> prihvaceni = new ArrayList<Pregled>();
		
		if(!p.getDatum().equals(datum) && !p.getVreme().equals(vreme)) {
			dodajPregled(p);
			prihvaceni.add(p);
		}
		
		
		return prihvaceni;
	}
}*/
	
	
