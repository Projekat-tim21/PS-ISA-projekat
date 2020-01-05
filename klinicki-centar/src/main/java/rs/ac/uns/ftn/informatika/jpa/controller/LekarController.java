package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class LekarController {


	private Logger logger = LoggerFactory.getLogger(AdminKCController.class);
	
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	    private KorisnikService korisnikService;
	 
	 @Autowired
	 private KlinikaService klinikaService;
	
	 
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private DijagnozaServiceImpl dijagnozaService;
	 @Autowired
	 private TerminSaIdService terService;

	 @GetMapping("/radniKalendar")
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
	        modelAndView.setViewName("radniKalendarProba");
	        return modelAndView;
	    }
	
	 @RequestMapping(value="/lekaruu", method=RequestMethod.GET)
		public List<TerminiSaId> events() {
			return terService.pokaziSveTermine();
		}
	
	 private LinkedList<String> getList(){
		    LinkedList<String> list = new LinkedList<>();
		    
		    List<Lek> lekovi= lekService.showAll();
		    
		    for(int i=0; i<lekovi.size(); i++) {
		    	list.add(lekovi.get(i).getNaziv());
		    }
		   

		    return list;
		}
	 
	 @GetMapping("/zapocniOperacijeP/{korisnikId}")
	    public ModelAndView addmin(@PathVariable Long korisnikId,HttpServletRequest request) {
		 	
		 	request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			Korisnik k=korisnikService.findOne(korisnikId);
			System.out.println(k.getVisina());
			request.setAttribute("mode", "MODE_ZKARTON");
		 
		 	LinkedList<String> list = getList();
	        ModelAndView map = new ModelAndView("pregled");
	        map.addObject("lists", list);
	        return map;
	    }
}
