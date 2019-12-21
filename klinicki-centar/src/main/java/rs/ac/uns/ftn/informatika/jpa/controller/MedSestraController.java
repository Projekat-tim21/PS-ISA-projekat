package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.Response;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Odsustvo;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.OdsustvoService;
import rs.uns.ac.ftn.informatika.jpa.constatns.AppConstant;

@Controller
public class MedSestraController {

	
	 private final KorisnikService korisnikService;
	 
	 private final OdsustvoService odsustvoSerevice;


	public MedSestraController( KorisnikService korisnikService,
			OdsustvoService odsustvoSerevice) {

		this.korisnikService = korisnikService;
		this.odsustvoSerevice = odsustvoSerevice;
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
	 
	 @GetMapping("/vidijos/{korisnikId}")
	    public String enable(@PathVariable Long korisnikId,HttpServletRequest request) {
		 request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			Korisnik k=korisnikService.findOne(korisnikId);
			System.out.println(k.getVisina());
			request.setAttribute("mode", "MODE_ZKARTON");
			
			return "pacijentSestra";   }
	 
	
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
		
}

