package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Odsustvo;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.service.InformacijeOpregleduService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.OdsustvoService;

@Controller
public class MedSestraController {

	
	 private final KorisnikService korisnikService;
	 
	 private final OdsustvoService odsustvoSerevice;

	 private final InformacijeOpregleduService infoService;

	public MedSestraController( KorisnikService korisnikService,
			OdsustvoService odsustvoSerevice,InformacijeOpregleduService info) {

		this.korisnikService = korisnikService;
		this.odsustvoSerevice = odsustvoSerevice;
		this.infoService=info;
		
	}

	@GetMapping("/medSestraPocetna")
	    public ModelAndView sestra() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("medSestraPocetna");
	        return modelAndView;
	    }
	
	@GetMapping("/zahtevZaOdsustvo")
    public ModelAndView zahtevZaOdsustvo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zahtevZaOdsustvo");
        return modelAndView;
    }
	 
	 @GetMapping("/sviSestraPacijenti")
	    public ModelAndView svi(HttpServletRequest request) {
		 request.setAttribute("korisnici", korisnikService.pokaziSvePacijente());
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("sviSestraPacijenti");
	        return modelAndView;
	    }
	 
	 @GetMapping("/overaRecepta")
	    public ModelAndView sviRecepti(HttpServletRequest request) {
		 request.setAttribute("info", infoService.pokaziZaOveru());
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("sestraOvera");
	        return modelAndView;
	    }
	 
	 @GetMapping("/vidijos/{korisnikId}")
	    public String enable(@PathVariable Long korisnikId,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			Korisnik k=korisnikService.findOne(korisnikId);
			System.out.println(k.getVisina());
			request.setAttribute("mode", "MODE_ZKARTON");
			
			return "pacijentSestra";   }
	 
	 @GetMapping("/overi/{infoid}")
	    public String overa(@PathVariable Long infoid,HttpServletRequest request) {
		 request.setAttribute("korisnik", infoService.findOne(infoid));
		InformacijeOpregledu i=	(InformacijeOpregledu) infoService.findOne(infoid);
		i.setOveren(true);
		
		Set novi=i.getLeks();
		request.setAttribute("lekici", novi);
		System.out.println(novi.isEmpty());
		 request.setAttribute("mode", "MODE_OVERA");
	//	request.setAttribute("lekovi", i.getLeks());
		//request.setAttribute("mode1", "MODE_LEK");	
		 infoService.saveRecept(i);	
		 return "overa";   }
	 
	
	 @PostMapping("/zahtevZaOdsustvoo/{id}") // korisnik povezan sa valuom iz js
		public String zahtevZaOdsustvo(@PathVariable(value="id") Long id,@ModelAttribute Odsustvo odsustvo, BindingResult bindingResult,
				HttpServletRequest request) throws ParseException {
	
		 	Korisnik k=korisnikService.findOne(id);
			Odsustvo o = new Odsustvo();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1 = sdf.parse(odsustvo.getPocetak());
	        Date date2 = sdf.parse(odsustvo.getKraj());
	        LocalDate sada=java.time.LocalDate.now();
	        Date date3=java.sql.Date.valueOf(sada);
	        System.out.println(java.time.LocalDate.now());
	       System.out.println(date2);
	        
	        
			
			o.setPocetak(odsustvo.getPocetak());
			o.setKraj(odsustvo.getKraj());
			o.setIdkorisnika(id);
			o.setOdobren(false);
			
			 if (date1.compareTo(date2) > 0) {
		            System.out.println("Date1 is after Date2");
		            return "redirect:/zahtevZaOdsustvo?error=Datum pocetka posle datuma kraja";
		        } else if(date1.compareTo(date3) < 0){
		            System.out.println("Date1 is before Date3");
		            return "redirect:/zahtevZaOdsustvo?error=Datum pocetka pre danasnjeg datuma";
		        }else if(date2.compareTo(date3) < 0) {
		        	 System.out.println("Date2 is before Date3");
		        	 return "redirect:/zahtevZaOdsustvo?error=Datum kraja pre danasnjeg datuma";
		        }
			
			System.out.println("Id sestre "+o.getIdkorisnika() + " Kraj " +o.getKraj()+ " Pocetak " +o.getPocetak() + " odobren "+ o.isOdobren());
			odsustvoSerevice.saveOdsutvo(o);
			return "redirect:/medSestraPocetna";
		}
	 
	 @RequestMapping("/profilSestra")
		public String editUserProfilPregled(@RequestParam Long id, HttpServletRequest request) {
			request.setAttribute("korisnik", korisnikService.findOne(id));
			request.setAttribute("mode", "MODE_PREGLED");
			return "profilSestra";
		}
	 
	
	 
	 @RequestMapping("/izmenaPodatakaSestre/{id}")
		public String editUserProfil2(@PathVariable(value="id") Long id, HttpServletRequest request) {
			request.setAttribute("korisnik", korisnikService.findOne(id));
			request.setAttribute("mode", "MODE_PREGLED");
			return "izmenaPodatakaSestre";  //bio je login
		}
		
	 @PostMapping("/sacuvajIzmeneProfila/{id}") // korisnik povezan sa valuom iz js
		public String UpdateKorisnik2(@PathVariable(value="id") Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
				HttpServletRequest request) {
		
			String id2 = request.getParameter("id");
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id2);
			
			
			Korisnik izBaze=korisnikService.findOne(id);
			
			Korisnik k = new Korisnik();
			Long Idx = korisnikd.getId();
			k.setId(korisnikd.getId());
			k.setIme(korisnikd.getIme());
			k.setPrezime(korisnikd.getPrezime());
			k.setJedBrOsig(korisnikd.getJedBrOsig());
			k.setEmail(korisnikd.getEmail());
			k.setAdresa(korisnikd.getAdresa());
			k.setDrzava(korisnikd.getDrzava());
			k.setGrad(korisnikd.getGrad());
			k.setTelefon(korisnikd.getTelefon());
			k.setUsername(korisnikd.getUsername());
			k.setPassword(korisnikd.getPassword());
			k.setRoleName(Role.SESTRA.name());
			
			korisnikService.saveMogKorisnika(k);
			//request.setAttribute("mode", "MODE");
			return "redirect:/profilSestra?id={id}";

		}
	 
	 @GetMapping("/radniKalendarSestre")
	    public ModelAndView kalendar(@RequestParam Long id, HttpServletRequest request) {
		 String id2 = request.getParameter("id");
			System.out.println(id);
			HttpSession session = request.getSession();
			session.setAttribute("id", id2);
			request.setAttribute("korisnik", korisnikService.findOne(id));
			Korisnik k=korisnikService.findOne(id);
			System.out.println(k.getVisina());
			request.setAttribute("mode", "MODE_ZKARTON");
		 	ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("radniKalendarSestre");
	        return modelAndView;
	    }
}

