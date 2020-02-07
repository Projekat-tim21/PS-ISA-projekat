package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
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
import rs.ac.uns.ftn.informatika.jpa.dto.KalendarDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Odsustvo;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
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
	 
/*	 @RequestMapping(value = "/getCalendar",method = RequestMethod.GET, produces="application/json; charset=utf-8")
	 @ResponseBody
	 public ResponseEntity<String> getCalendar(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(id));
		 request.setAttribute("mode", "MODE_LOGIN");	
		 Korisnik korisnik=korisnikService.findOne(id);
		 Long Idx=korisnikd.getId();
		 System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<TerminiSaId> termini = calendarService.getTerminiByLekarId(id);
		 System.out.println("Size: "+ termini.size());
		 List<TerminDAO> tt=new ArrayList<TerminDAO>();
		 for(int i=0; i<termini.size();i++) {
			 TerminDAO novi=new TerminDAO();
			 novi.setTermin(termini.get(i).getTermin());
			 Korisnik k=korisnikService.findOne(termini.get(i).getId());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(termini.get(i).getTippregleda());;
			 novi.setSala(termini.get(i).getSala());
			 novi.setZakazan(termini.get(i).isZakazan());
			 novi.setIdkorisnika(termini.get(i).getId());
			 tt.add(novi);
			 
		 }
		 
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json; charset=utf-8");
		    if (termini.size() > 0)
		    {
		        return new ResponseEntity<String>(new JSONSerializer().include("termin","pacijentime","pacijentprezime","tippregleda","sala","zakazan","idkorisnika").exclude("*").serialize(tt), headers, HttpStatus.OK);
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
	 //}
	 
	/* @RequestMapping(value = "/getCalendarSestra",method = RequestMethod.GET, produces="application/json; charset=utf-8")
	 @ResponseBody
	 public ResponseEntity<String> getCalendarSestra(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(id));
		 request.setAttribute("mode", "MODE_LOGIN");	
		 Korisnik korisnik=korisnikService.findOne(id);
		 Long Idx=korisnikd.getId();
		 System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<Odsustvo> odsustvo = calendarService.getOdsustvoBySestraId(id);
		 System.out.println("Size: "+ odsustvo.size());
		 
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json; charset=utf-8");
		    if (odsustvo.size() > 0)
		    {
		        return new ResponseEntity<String>(new JSONSerializer().include("pocetak","kraj").exclude("*").serialize(odsustvo), headers, HttpStatus.OK);
		    }
		    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
		
	 }
	 */
	 @RequestMapping(value = "/getCalendar",method = RequestMethod.GET, produces="application/json; charset=utf-8")
	 @ResponseBody
	 public ResponseEntity<String> getCalendarLekar(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(id));
		 request.setAttribute("mode", "MODE_LOGIN");	
		 Korisnik korisnik=korisnikService.findOne(id);
		 Long Idx=korisnikd.getId();
		 Long od=0L;
		 Long tr=1L;
		 Long op=2L;
		 Long pr=3L;
		 System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<TerminiSaId> termini = calendarService.getTerminiByLekarId(id);
		 List<Operacija> operacija = calendarService.getOperacijeByLekarId(id);
		 List<Pregled> pregledi = calendarService.getPreglediByLekarId(id);
		 System.out.println("Size: "+ termini.size());
		 List<KalendarDTO> tt=new ArrayList<KalendarDTO>();
		 for(int i=0; i<termini.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(termini.get(i).getTermin());
			 novi.setTerminkraj(termini.get(i).getTermin());
			 novi.setTipEventa("Unapred definisan pregled");
			 Korisnik k=korisnikService.findOne(termini.get(i).getId());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(termini.get(i).getTippregleda());;
			 novi.setSala(termini.get(i).getSala());
			 novi.setZakazan(termini.get(i).isZakazan());
			 novi.setIdkorisnika(termini.get(i).getId());
			 novi.setId(termini.get(i).getId());
			 novi.setIdEventa(tr);
			 tt.add(novi);
			 
		 }
		 for(int i=0; i<operacija.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(operacija.get(i).getTerminoperacija());
			 novi.setTerminkraj(operacija.get(i).getTerminoperacija());
			 novi.setTipEventa("Operacija");
			 Korisnik k=korisnikService.findOne(operacija.get(i).getIdpacijenta());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(operacija.get(i).getTip());
			 novi.setSala(operacija.get(i).getSala());
			 novi.setZakazan(operacija.get(i).isObavljenaoperacija());
			 novi.setIdkorisnika(operacija.get(i).getIdpacijenta());
			 novi.setId(operacija.get(i).getId());
			 novi.setIdEventa(op);
			 tt.add(novi);
			 
		 }
		 for(int i=0; i<pregledi.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(pregledi.get(i).getTerminpregled());
			 novi.setTerminkraj(pregledi.get(i).getTerminpregled());
			 novi.setTipEventa("Pregled");
			 Korisnik k=korisnikService.findOne(pregledi.get(i).getIdpacijenta());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(pregledi.get(i).getTip());;
			 novi.setSala(pregledi.get(i).getSala());
			 novi.setZakazan(pregledi.get(i).isObavljenpregled());
			 novi.setIdkorisnika(pregledi.get(i).getIdpacijenta());
			 novi.setId(pregledi.get(i).getId());
			 novi.setIdEventa(pr);
			 tt.add(novi);
			 
		 }
		 
		 
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json; charset=utf-8");
		    if (termini.size() > 0)
		    {
		        return new ResponseEntity<String>(new JSONSerializer().include("termin","terminkraj","pacijentime","pacijentprezime","tippregleda","sala","zakazan","idkorisnika","tipEventa","id","idEventa").exclude("*").serialize(tt), headers, HttpStatus.OK);
		    }
		    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
		
	 }
	 @RequestMapping(value = "/getCalendarSestra",method = RequestMethod.GET, produces="application/json; charset=utf-8")
	 @ResponseBody
	 public ResponseEntity<String> getCalendarSestra1(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(id));
		 request.setAttribute("mode", "MODE_LOGIN");	
		 Korisnik korisnik=korisnikService.findOne(id);
		 Long Idx=korisnikd.getId();
		 Long od=0L;
		 Long tr=1L;
		 Long op=2L;
		 Long pr=3L;
		 System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<TerminiSaId> termini = calendarService.getTerminiSaIdAll();
		 List<Operacija> operacija = calendarService.getOperacijeAll();
		 List<Pregled> pregledi = calendarService.getPreglediAll();
		 List<Odsustvo> odsustvo= calendarService.getOdsustvoBySestraId(Idx);
		 System.out.println("Size: "+ termini.size());
		 List<KalendarDTO> tt=new ArrayList<KalendarDTO>();
		 for(int i=0; i<termini.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(termini.get(i).getTermin());
			 novi.setTerminkraj(termini.get(i).getTermin());
			 novi.setTipEventa("Unapred definisan pregled");
			 Korisnik k=korisnikService.findOne(termini.get(i).getId());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(termini.get(i).getTippregleda());;
			 novi.setSala(termini.get(i).getSala());
			 novi.setZakazan(termini.get(i).isZakazan());
			 novi.setIdkorisnika(termini.get(i).getId());
			 novi.setId(termini.get(i).getId());
			 novi.setIdEventa(tr);
			 novi.setLekarId(termini.get(i).getLekarId());
			 tt.add(novi);
			 
		 }
		 for(int i=0; i<operacija.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(operacija.get(i).getTerminoperacija());
			 novi.setTerminkraj(operacija.get(i).getTerminoperacija());
			 novi.setTipEventa("Operacija");
			 Korisnik k=korisnikService.findOne(operacija.get(i).getIdpacijenta());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(operacija.get(i).getTip());
			 novi.setSala(operacija.get(i).getSala());
			 novi.setZakazan(operacija.get(i).isObavljenaoperacija());
			 novi.setIdkorisnika(operacija.get(i).getIdpacijenta());
			 novi.setId(operacija.get(i).getId());
			 novi.setIdEventa(op);
			 novi.setLekarId(operacija.get(i).getIdlekaroperacija());
			 tt.add(novi);
			 
		 }
		 for(int i=0; i<pregledi.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(pregledi.get(i).getTerminpregled());
			 novi.setTerminkraj(pregledi.get(i).getTerminpregled());
			 novi.setTipEventa("Pregled");
			 Korisnik k=korisnikService.findOne(pregledi.get(i).getIdpacijenta());
			 novi.setPacijentime(k.getIme());
			 novi.setPacijentprezime(k.getPrezime());
			 novi.setTippregleda(pregledi.get(i).getTip());;
			 novi.setSala(pregledi.get(i).getSala());
			 novi.setZakazan(pregledi.get(i).isObavljenpregled());
			 novi.setIdkorisnika(pregledi.get(i).getIdpacijenta());
			 novi.setId(pregledi.get(i).getId());
			 novi.setIdEventa(pr);
			 Long lekarID=Long.parseLong(pregledi.get(i).getIdlekarpregled());
			 novi.setLekarId(lekarID);
			 tt.add(novi);
			 
		 }
		 
		 for(int i=0; i<odsustvo.size();i++) {
			 KalendarDTO novi=new KalendarDTO();
			 novi.setTermin(odsustvo.get(i).getPocetak());
			 novi.setTerminkraj(odsustvo.get(i).getKraj());
			 novi.setTipEventa("Odsustvo");
			 novi.setId(odsustvo.get(i).getId());
			 novi.setIdEventa(od);
			 
			 Korisnik k=korisnikService.findOne(1L);
			 novi.setPacijentime("");
			 novi.setPacijentprezime("");
			 novi.setTippregleda("odsustvo");;
			 novi.setIdkorisnika(5L);
			 novi.setLekarId(16L);
			 tt.add(novi);
			 
		 }
		 
		 
		 
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json; charset=utf-8");
		    if (termini.size() > 0)
		    {
		        return new ResponseEntity<String>(new JSONSerializer().include("termin","terminkraj","pacijentime","pacijentprezime","tippregleda","sala","zakazan","idkorisnika","tipEventa","id","idEventa","lekarId").exclude("*").serialize(tt), headers, HttpStatus.OK);
		    }
		    return new ResponseEntity<String>(null, headers, HttpStatus.OK);
		 }
}
	 

