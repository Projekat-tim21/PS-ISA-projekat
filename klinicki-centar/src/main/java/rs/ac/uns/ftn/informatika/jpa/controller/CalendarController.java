package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import flexjson.JSONSerializer;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.CalendarService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;



@Controller
public class CalendarController {

	@Autowired
	private KorisnikService korisnikService;
	 
	// @Autowired
	 private CalendarService calendarService;
	 
	 @Autowired
	 private KorisnikService userService;

	public CalendarController( CalendarService calendarService,
			KorisnikService userService) {
		this.calendarService = calendarService;
		this.userService = userService;
	}
	 
	 @RequestMapping(value = "/getCalendar",method = RequestMethod.GET, produces="application/json; charset=utf-8")
	 @ResponseBody
	 public ResponseEntity<String> getCalendar(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(id));
		 request.setAttribute("mode", "MODE_LOGIN");	
		 Korisnik korisnik=korisnikService.findOne(id);
			//Korisnik k=new Korisnik();
			Long Idx=korisnikd.getId();
			System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
			Map<String, Object> map = new HashMap<String, Object>();
		 List<TerminiSaId> termini = calendarService.getTerminiByLekarId(id);
		 System.out.println("Size: "+ termini.size());
		 
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json; charset=utf-8");
		    if (termini.size() > 0)
		    {
		        return new ResponseEntity<String>(new JSONSerializer().include("termin","sala","cena").exclude("*").serialize(termini), headers, HttpStatus.OK);
		    }
		    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
		/* for(int i=0; i<termini.size();i++) {
			 String termin=termini.get(i).getTermin();
			 Long lekarId=termini.get(i).getLekarId();
			 String lekarime=termini.get(i).getLekarime();
			 String lekarprezime=termini.get(i).getLekarprezime();
			 String tippregleda=termini.get(i).getTippregleda();
			 String sala=termini.get(i).getSala();id
			 Double cena=termini.get(i).getCena();
			 Double popust=termini.get(i).getPopust();
			 Boolean zakazan=termini.get(i).isZakazan();
			 Long idkorisnika=termini.get(i).getIdkorisnika();
			 
			 map.put("termin", termin);
			 map.put("lekarId", lekarId);
			 map.put("lekarime", lekarime);
			 map.put("lekarprezime", lekarprezime);
			 map.put("tippregleda", tippregleda);
			 map.put("sala", sala);
			 map.put("cena", cena);
			 map.put("popust", popust);
			 map.put("zakazan", zakazan);
			 map.put("idkorisnika", idkorisnika);
		 }
		 
		System.out.println(map);
	     return map;*/
	 }
	 
	
}
