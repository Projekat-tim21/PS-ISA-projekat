package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Calendar;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.CalendarRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;
@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private TerminSaIdRepository terminiRepository;
	
	@Override
	public Object save(Calendar calendar) {
		return calendarRepository.save(calendar);
	}

	public CalendarServiceImpl(CalendarRepository calendarRepository, KorisnikRepository korisnikRepository) {
		this.calendarRepository = calendarRepository;
		this.korisnikRepository = korisnikRepository;
	}
	
	@Override
	public Calendar getCalendarByUsername(String username) {
		for(Calendar cal:calendarRepository.findAll()) {
			if(cal.getKorisnik().getUsername().equals(username)) {
				return cal;
			}
		}
		
		return null;
		
	}

	@Override
	public Pregled getPregledByDate(Date date, String username) {
		Calendar cale=null;
		for(Calendar cal: calendarRepository.findAll()) {
			if(cal.getKorisnik().getUsername().equals(username)) {
				cale=cal;
			}
		}
		if(cale==null) {
			return null;
		}else {
			for(Pregled pr:cale.getPregledi()) {
				
				if(pr.getDatum().compareTo(date.toString())==0) {
					return pr;
				}
			}
		}
		
		return null;
	}

	@Override
	public Calendar getCalendarById(Long id) {
		for(Calendar cal:calendarRepository.findAll()) {
			if(cal.getKorisnik().getId().equals(id)) {
				return cal;
			}
		}
		
		return null;

	}

	@Override
	public List<TerminiSaId> getTerminiByLekarId(Long id) {
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId t : terminiRepository.findByLekarId(id)) {
			termini.add(t);
		}
		return termini;
	}
	
	
}