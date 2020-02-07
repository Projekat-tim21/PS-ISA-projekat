package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Sala> findByDatum(String terminoperacija) {
		// TODO Auto-generated method stub
				List<Sala> sale = new ArrayList<Sala>();
				for(Sala sala : salaRepo.findAll()) {
					if(sala.getDatum()==terminoperacija && sala.isRezervisana()==false) {
						sale.add(sala);
						System.out.println(sala.getDatum());
					}
				}
				return sale;
	}

	public Object pokaziZaDatum(String terminoperacija) throws ParseException {
		// TODO Auto-generated method stub
				List<Sala> sale = new ArrayList<Sala>();
				for(Sala sala : salaRepo.findAll()) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
					LocalDateTime datum=java.time.LocalDateTime.parse(terminoperacija);
					LocalDateTime datumsale=java.time.LocalDateTime.parse(sala.getDatum());
					if(sala.getDatum().equals(terminoperacija) && sala.isRezervisana()==false) {
						sale.add(sala);
					}
				}
				if(sale.size()==0) {
					for(Sala sala : salaRepo.findAll()) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
					LocalDateTime datum=java.time.LocalDateTime.parse(terminoperacija);
					LocalDateTime datumsale=java.time.LocalDateTime.parse(sala.getDatum());
					if(datum.compareTo(datumsale)<0 && sala.isRezervisana()==false) {
					sale.add(sala);
					}
					}
				}
				return sale;
	}

	public void save(Sala sala) {
		// TODO Auto-generated method stub
		salaRepo.save(sala);
	}

	public List<Sala> sveSlobodne() {
		// TODO Auto-generated method stub
		List<Sala> sale = new ArrayList<Sala>();
		for(Sala sala : salaRepo.findAll()) {
			if(sala.isRezervisana()==false) {
				sale.add(sala);
				System.out.println(sala.getDatum());
			}
		}
		return sale;
	}
}
