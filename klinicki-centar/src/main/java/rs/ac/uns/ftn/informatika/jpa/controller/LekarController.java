package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.InformacijeOpregleduDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PregledDTO;
import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.InformacijeOpregleduService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.OperacijeService;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class LekarController {
	
	 @Autowired
	 private KorisnikService korisnikService;
	
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private InformacijeOpregleduService infoService;

	 @Autowired
	 private TerminSaIdService terService;
	 
	 @Autowired
	 private OperacijeService oService;
	 
	 @Autowired
	 private PregledService pService;

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
	 
	 @RequestMapping(value="/zapocniOperacijeP/{lekarId}/{korisnikId}", method = { RequestMethod.GET, RequestMethod.POST })
	    public ModelAndView addmin(@PathVariable Long lekarId,@PathVariable Long korisnikId,HttpServletRequest request) {
		 	
		 	request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			Korisnik k=korisnikService.findOne(korisnikId);
			System.out.println("PACIJENT PONOVO: "+k.getIme());
			request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			request.setAttribute("mode", "MODE_ZKARTON");
			request.setAttribute("lekar", korisnikService.findOne(lekarId));
			System.out.println("PACIJENT JADNI: " + k.getIme());
			request.setAttribute("mode", "MODE_LEKAR");
		 	LinkedList<String> list = getList();
	        ModelAndView map = new ModelAndView("pregled");
	        map.addObject("lists", list);
	        return map;
	    }
	 
	 @RequestMapping(value="/noviPregled/{korisnikId}/{lekarId}", method = { RequestMethod.GET, RequestMethod.POST } )
	    public ModelAndView noviPregled(@PathVariable Long korisnikId,@PathVariable Long lekarId,
				@ModelAttribute InformacijeOpregleduDTO info,HttpServletRequest request) {
		 
			request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			request.setAttribute("mode", "MODE_ZKARTON");
			InformacijeOpregledu infor=new InformacijeOpregledu();
	        infor.setInformacije(info.getInformacije());
	        infor.setLekarId(lekarId);
			infor.setDijagnozaId(info.getDijagnozaId());
	        Set<Lek> leks = new HashSet<Lek>();
	        String[] lekici = request.getParameterValues("lekici");
	        for(int i=0;i<lekici.length;i++) {
	        	Lek nov=lekService.findByNaziv(lekici[i]);
	        	System.out.println(nov.getNaziv());
	        	leks.add(nov);
	        }
	        infor.setLeks(leks);
	        infor.setPacijentId(korisnikId);
	        infor.setOveren(false);
	        infoService.saveInformacije(infor);
	        request.setAttribute("lekar", korisnikService.findOne(lekarId));
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("uspesan");
	        return modelAndView;
	    }
	 
	 @RequestMapping(value="/sacuvajIzmeneIzvestaja/{idP}/{idL}/{idK}",method = { RequestMethod.GET, RequestMethod.POST }) 
		public String sacuvajIzvestaj(@PathVariable Long idP,@PathVariable Long idL,@PathVariable Long idK,@ModelAttribute InformacijeOpregleduDTO infod, HttpServletRequest request) {
			InformacijeOpregledu izBaze=infoService.findOne(idP);
			System.out.println("ISPISISI "+ izBaze.getId());
			InformacijeOpregledu i = new InformacijeOpregledu();
			i.setId(izBaze.getId());
			System.out.println("ONO STO JE ID SAD : "+i.getId());
			i.setLekarId(izBaze.getLekarId());
			i.setPacijentId(izBaze.getPacijentId());
			i.setDijagnozaId(infod.getDijagnozaId());
			Set<Lek> leks = new HashSet<Lek>();
			String[] lekici = request.getParameterValues("lekici");
		    for(int j=0;j<lekici.length;j++) {
		    	Lek nov=lekService.findByNaziv(lekici[j]);
		        System.out.println("IZ FOR PETLJE "+ nov.getNaziv());
		        leks.add(nov);
		    }
		    i.setLeks(leks);
			i.setInformacije(infod.getInformacije());
			System.out.println(i.getInformacije());
			i.setOveren(izBaze.getOveren());
			System.out.println(i.getOveren());
			infoService.saveInformacije(i);
			request.setAttribute("lekar", korisnikService.findOne(idL));
			request.setAttribute("korisnik", korisnikService.findOne(idK));
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";

		}

	 @RequestMapping("/izmenaKartona/{pacijentId}")
		public String editUserProfilIzBara(@PathVariable Long pacijentId, HttpServletRequest request) {
			request.setAttribute("korisnik", korisnikService.findOne(pacijentId));
			request.setAttribute("mode", "MODE_PREGLED");

			return "kartonPacijenta";  //bio je login
		}
	
	 
	 @RequestMapping("/istorijaIzvestaja/{pacijentId}/{lekarId}")
		public String istorijaIzvestaja(@PathVariable Long pacijentId,@PathVariable Long lekarId, HttpServletRequest request) {
		 
		 	System.out.println("NAS PACIJENNNT " + pacijentId);
		 	 request.setAttribute("lekar", korisnikService.findOne(lekarId));
		 	request.setAttribute("izvestaji", infoService.izvestajiDatogPacijenta(pacijentId));
			List<InformacijeOpregledu> niv=infoService.izvestajiDatogPacijenta(pacijentId);
			for(int i=0; i<niv.size();i++) {
			System.out.println(niv.get(i).getDijagnozaId());
			}
			request.setAttribute("mode", "MODE_PREGLED");

			return "istorijaIzvestaja";  //bio je login
		}
	 
	 @RequestMapping(value="/sacuvajKarton",method = { RequestMethod.GET, RequestMethod.POST }) 
		public String sacuvajZK(@ModelAttribute KorisnikDTO korisnikd, HttpServletRequest request) {
	  
			Korisnik izBaze=korisnikService.findOne(korisnikd.getId());
			System.out.println("ISPISISI "+ izBaze.getId());
			Korisnik k = new Korisnik();
			k.setId(izBaze.getId());
			System.out.println("ONO STO JE ID SAD : "+k.getId());
			k.setId(izBaze.getId());
			k.setIme(izBaze.getIme());
			k.setPrezime(izBaze.getPrezime());
			k.setJedBrOsig(izBaze.getJedBrOsig());
			k.setEmail(izBaze.getEmail());
			k.setAdresa(izBaze.getAdresa());
			k.setDrzava(izBaze.getDrzava());
			k.setGrad(izBaze.getGrad());
			k.setTelefon(izBaze.getTelefon());
			k.setUsername(izBaze.getUsername());
			k.setPassword(izBaze.getPassword());
			k.setIsActive(izBaze.getIsActive());
			k.setFirst_Login(true);
			k.setRoleName(Role.PACIJENT.name());
			k.setDatum(korisnikd.getDatum());
			k.setPol(korisnikd.getPol());
			k.setVisina(korisnikd.getVisina());
			k.setTezina(korisnikd.getTezina());
			k.setKgrupa(korisnikd.getKgrupa());
			k.setDioptrija(korisnikd.getDioptrija());
			k.setAlergije(korisnikd.getAlergije());
			k.setBolesti(korisnikd.getBolesti());
			k.setAnamneza(korisnikd.getAnamneza());
			korisnikService.saveMogKorisnika(k);
			request.setAttribute("korisnik", korisnikService.findOne(korisnikd.getId()));
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";

		}
	 
	 @GetMapping("/izmenaIzvestaja/{IId}/{lekarId}")
	    public ModelAndView izmenaIzvestaja(@PathVariable Long IId,@PathVariable Long lekarId,HttpServletRequest request) {
		 	Korisnik kor=korisnikService.findOne(lekarId);
		 	request.setAttribute("novi", infoService.findOne(IId));
		 	InformacijeOpregledu info=infoService.findOne(IId);
			request.setAttribute("mode", "MODE_ZKARTON");
			LinkedList<String> list = getList();
			ModelAndView map = new ModelAndView("izmenaIzvestaja");
			ModelAndView map1 = new ModelAndView("ne");
			map.addObject("lists", list);
			if(kor.getId()==info.getLekarId()) {
				return map;
			}
			return map1;   			
	 }
	 
	 @GetMapping("/kreirajPregled/{IId}/{lekarId}")
	    public ModelAndView kreirajPregled(@PathVariable Long IId,@PathVariable Long lekarId,HttpServletRequest request) {
		 request.setAttribute("lekar", korisnikService.findOne(lekarId));
			request.setAttribute("korisnik", korisnikService.findOne(IId));
			request.setAttribute("mode", "MODE_PREGLED");
		 	ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("noviPL");
	        return modelAndView;  			
	 }
	
	 @GetMapping("/kreirajOperaciju/{IId}/{lekarId}")
	    public ModelAndView kreirajOperaciju(@PathVariable Long IId,@PathVariable Long lekarId,HttpServletRequest request) {
		 	request.setAttribute("lekar", korisnikService.findOne(lekarId));
			request.setAttribute("korisnik", korisnikService.findOne(IId));
			request.setAttribute("mode", "MODE_PREGLED");
		 	ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("novaOL");
	        return modelAndView;  			
	 }

	 @RequestMapping(value="/sacuvajNoviPregled/{lekarId}/{pacijentId}",method = { RequestMethod.GET, RequestMethod.POST }) // korisnik povezan sa valuom iz js
		public String cuvajPregled(@PathVariable String lekarId,@PathVariable Long pacijentId,@ModelAttribute PregledDTO pregledDTO, BindingResult bindingResult,
				HttpServletRequest request) throws ParseException {
		
			Pregled o= new Pregled();
			o.setIdlekarpregled(lekarId);
			o.setIdpacijenta(pacijentId);
			o.setTerminpregled(pregledDTO.getTerminpregled());
			o.setObradjen(false);
			pService.save(o);
			request.setAttribute("message", "uspesno kreirana operacija");
			Long n=Long.parseLong( lekarId );
			request.setAttribute("lekar", korisnikService.findOne(n));
			request.setAttribute("korisnik", korisnikService.findOne(pacijentId));
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";
		}
	 @RequestMapping(value="/sacuvajNovuOperaciju/{pacijentId}/{lekarId}",method = { RequestMethod.GET, RequestMethod.POST }) // korisnik povezan sa valuom iz js
		public String cuvajOperaciju(@PathVariable Long lekarId,@PathVariable Long pacijentId,@ModelAttribute Operacija operacijaDTO, BindingResult bindingResult,
				HttpServletRequest request) throws ParseException {
		
			Operacija o= new Operacija();
			o.setIdpacijenta(pacijentId);
			o.setTerminoperacija(operacijaDTO.getTerminoperacija());
			o.setObradjen(false);
			oService.save(o);
			request.setAttribute("message", "uspesno kreirana operacija");
			request.setAttribute("lekar", korisnikService.findOne(lekarId));
			request.setAttribute("korisnik", korisnikService.findOne(pacijentId));
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";
		}
	 
}
