package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Calendar;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public interface CalendarService {
	
	Object save(Calendar calendar);
	
	Calendar getCalendarByUsername(String username);
	
	Pregled getPregledByDate(Date date, String username);

	Calendar getCalendarById(Long id);
	
	List<TerminiSaId> getTerminiByLekarId(Long id);
	

}
