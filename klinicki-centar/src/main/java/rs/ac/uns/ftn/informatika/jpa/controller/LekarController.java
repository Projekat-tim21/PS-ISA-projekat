package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import rs.ac.uns.ftn.informatika.jpa.dto.OperacijaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PregledDTO;
import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.InformacijeOpregleduService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
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
	 
	 @Autowired
	 private LekarZaPrikazIPregledeService lpService;

	 @GetMapping("/radniKalendar")
	    public ModelAndView kalendar(@RequestParam Long id, HttpServletRequest request) {
		 String id2 = request.getParameter("id");
			System.out.println(id);
			HttpSession session = request.getSession();
			session.setAttribute("id", id2);
			Korisnik k=korisnikService.findOne(id);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(k.getAdresa());
	    	korisnikDTO.setAlergije(k.getAlergije());
	    	korisnikDTO.setAnamneza(k.getAnamneza());
	    	korisnikDTO.setBolesti(k.getBolesti());
	    	korisnikDTO.setDatum(k.getDatum());
	    	korisnikDTO.setDioptrija(k.getDioptrija());
	    	korisnikDTO.setDrzava(k.getDrzava());
	    	korisnikDTO.setEmail(k.getEmail());
	    	korisnikDTO.setFirstLogin(k.getFirst_Login());
	    	korisnikDTO.setGrad(k.getGrad());
	    	korisnikDTO.setId(k.getId());
	    	korisnikDTO.setIme(k.getIme());
	    	korisnikDTO.setIsActive(k.getIsActive());
	    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
	    	korisnikDTO.setKgrupa(k.getKgrupa());
	    	korisnikDTO.setPassword(k.getPassword());
	    	korisnikDTO.setPol(k.getPol());
	    	korisnikDTO.setPrezime(k.getPrezime());
	    	korisnikDTO.setRole(k.getRoleName());
	    	korisnikDTO.setTelefon(k.getTelefon());
	    	korisnikDTO.setTezina(k.getTezina());
	    	korisnikDTO.setUsername(k.getUsername());
	    	korisnikDTO.setVisina(k.getVisina());
			request.setAttribute("korisnik", korisnikDTO);
			//Korisnik k=korisnikService.findOne(id);
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
	 
	 @RequestMapping(value="/zapocniOperacijeP/{lekarId}/{korisnikId}/{tip}/{idP}", method = { RequestMethod.GET, RequestMethod.POST })
	    public ModelAndView addmin(@PathVariable Long lekarId,@PathVariable Long korisnikId,@PathVariable Long tip,@PathVariable Long idP,HttpServletRequest request) {
		 InformacijeOpregledu o=infoService.postojiVec(idP,tip);
		 	if(o!=null) {
		 		ModelAndView map1 = new ModelAndView("vecPostojiIzvestajLekar");
		 		return map1;
		 	}
		 	//request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			Korisnik k=korisnikService.findOne(korisnikId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(k.getAdresa());
	    	korisnikDTO.setAlergije(k.getAlergije());
	    	korisnikDTO.setAnamneza(k.getAnamneza());
	    	korisnikDTO.setBolesti(k.getBolesti());
	    	korisnikDTO.setDatum(k.getDatum());
	    	korisnikDTO.setDioptrija(k.getDioptrija());
	    	korisnikDTO.setDrzava(k.getDrzava());
	    	korisnikDTO.setEmail(k.getEmail());
	    	korisnikDTO.setFirstLogin(k.getFirst_Login());
	    	korisnikDTO.setGrad(k.getGrad());
	    	korisnikDTO.setId(k.getId());
	    	korisnikDTO.setIme(k.getIme());
	    	korisnikDTO.setIsActive(k.getIsActive());
	    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
	    	korisnikDTO.setKgrupa(k.getKgrupa());
	    	korisnikDTO.setPassword(k.getPassword());
	    	korisnikDTO.setPol(k.getPol());
	    	korisnikDTO.setPrezime(k.getPrezime());
	    	korisnikDTO.setRole(k.getRoleName());
	    	korisnikDTO.setTelefon(k.getTelefon());
	    	korisnikDTO.setTezina(k.getTezina());
	    	korisnikDTO.setUsername(k.getUsername());
	    	korisnikDTO.setVisina(k.getVisina());
			System.out.println("PACIJENT PONOVO: "+k.getIme());
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_ZKARTON");
			Korisnik kk=korisnikService.findOne(lekarId);
	   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
	    	korisnikDTO1.setAdresa(kk.getAdresa());
	    	korisnikDTO1.setAlergije(kk.getAlergije());
	    	korisnikDTO1.setAnamneza(kk.getAnamneza());
	    	korisnikDTO1.setBolesti(kk.getBolesti());
	    	korisnikDTO1.setDatum(kk.getDatum());
	    	korisnikDTO1.setDioptrija(kk.getDioptrija());
	    	korisnikDTO1.setDrzava(kk.getDrzava());
	    	korisnikDTO1.setEmail(kk.getEmail());
	    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
	    	korisnikDTO1.setGrad(kk.getGrad());
	    	korisnikDTO1.setId(kk.getId());
	    	korisnikDTO1.setIme(kk.getIme());
	    	korisnikDTO1.setIsActive(kk.getIsActive());
	    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
	    	korisnikDTO1.setKgrupa(kk.getKgrupa());
	    	korisnikDTO1.setPassword(kk.getPassword());
	    	korisnikDTO1.setPol(kk.getPol());
	    	korisnikDTO1.setPrezime(kk.getPrezime());
	    	korisnikDTO1.setRole(kk.getRoleName());
	    	korisnikDTO1.setTelefon(kk.getTelefon());
	    	korisnikDTO1.setTezina(kk.getTezina());
	    	korisnikDTO1.setUsername(kk.getUsername());
	    	korisnikDTO1.setVisina(kk.getVisina());
			request.setAttribute("lekar", korisnikDTO1);
			System.out.println("PACIJENT JADNI: " + k.getIme());
			request.setAttribute("tip", tip);
			request.setAttribute("pregled", idP);
			request.setAttribute("mode", "MODE_LEKAR");
		 	LinkedList<String> list = getList();
	        ModelAndView map = new ModelAndView("pregled");
	        map.addObject("lists", list);
	        return map;
	    }
	 
	 @RequestMapping(value="/noviPregled/{korisnikId}/{lekarId}/{tip}/{idP}", method = { RequestMethod.GET, RequestMethod.POST } )
	    public ModelAndView noviPregled(@PathVariable Long korisnikId,@PathVariable Long lekarId,@PathVariable Long tip,@PathVariable Long idP,
				@ModelAttribute InformacijeOpregleduDTO info,HttpServletRequest request) {
		 Korisnik k=korisnikService.findOne(korisnikId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(k.getAdresa());
	    	korisnikDTO.setAlergije(k.getAlergije());
	    	korisnikDTO.setAnamneza(k.getAnamneza());
	    	korisnikDTO.setBolesti(k.getBolesti());
	    	korisnikDTO.setDatum(k.getDatum());
	    	korisnikDTO.setDioptrija(k.getDioptrija());
	    	korisnikDTO.setDrzava(k.getDrzava());
	    	korisnikDTO.setEmail(k.getEmail());
	    	korisnikDTO.setFirstLogin(k.getFirst_Login());
	    	korisnikDTO.setGrad(k.getGrad());
	    	korisnikDTO.setId(k.getId());
	    	korisnikDTO.setIme(k.getIme());
	    	korisnikDTO.setIsActive(k.getIsActive());
	    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
	    	korisnikDTO.setKgrupa(k.getKgrupa());
	    	korisnikDTO.setPassword(k.getPassword());
	    	korisnikDTO.setPol(k.getPol());
	    	korisnikDTO.setPrezime(k.getPrezime());
	    	korisnikDTO.setRole(k.getRoleName());
	    	korisnikDTO.setTelefon(k.getTelefon());
	    	korisnikDTO.setTezina(k.getTezina());
	    	korisnikDTO.setUsername(k.getUsername());
	    	korisnikDTO.setVisina(k.getVisina());
			request.setAttribute("korisnik", korisnikDTO);
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
	        infor.setPregledId(idP);
	        infor.setTip(tip);
	        infor.setOveren(false);
	        Pregled p=new Pregled();
	        TerminiSaId t= new TerminiSaId();
	        if(tip==3L) {
	        	p=pService.findOneById(idP);
	        	p.setObavljenpregled(true);
	        	p.setObradjen(true);
	        	pService.save(p);
	        }else if(tip==1L) {
	        	t=terService.findOne(idP);
	        	
	        }
	        infoService.saveInformacije(infor);
	        Korisnik kk=korisnikService.findOne(lekarId);
	   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
	    	korisnikDTO1.setAdresa(kk.getAdresa());
	    	korisnikDTO1.setAlergije(kk.getAlergije());
	    	korisnikDTO1.setAnamneza(kk.getAnamneza());
	    	korisnikDTO1.setBolesti(kk.getBolesti());
	    	korisnikDTO1.setDatum(kk.getDatum());
	    	korisnikDTO1.setDioptrija(kk.getDioptrija());
	    	korisnikDTO1.setDrzava(kk.getDrzava());
	    	korisnikDTO1.setEmail(kk.getEmail());
	    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
	    	korisnikDTO1.setGrad(kk.getGrad());
	    	korisnikDTO1.setId(kk.getId());
	    	korisnikDTO1.setIme(kk.getIme());
	    	korisnikDTO1.setIsActive(kk.getIsActive());
	    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
	    	korisnikDTO1.setKgrupa(kk.getKgrupa());
	    	korisnikDTO1.setPassword(kk.getPassword());
	    	korisnikDTO1.setPol(kk.getPol());
	    	korisnikDTO1.setPrezime(kk.getPrezime());
	    	korisnikDTO1.setRole(kk.getRoleName());
	    	korisnikDTO1.setTelefon(kk.getTelefon());
	    	korisnikDTO1.setTezina(kk.getTezina());
	    	korisnikDTO1.setUsername(kk.getUsername());
	    	korisnikDTO1.setVisina(kk.getVisina());
	        request.setAttribute("lekar", korisnikDTO1);
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
			Korisnik k=korisnikService.findOne(idK);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(k.getAdresa());
	    	korisnikDTO.setAlergije(k.getAlergije());
	    	korisnikDTO.setAnamneza(k.getAnamneza());
	    	korisnikDTO.setBolesti(k.getBolesti());
	    	korisnikDTO.setDatum(k.getDatum());
	    	korisnikDTO.setDioptrija(k.getDioptrija());
	    	korisnikDTO.setDrzava(k.getDrzava());
	    	korisnikDTO.setEmail(k.getEmail());
	    	korisnikDTO.setFirstLogin(k.getFirst_Login());
	    	korisnikDTO.setGrad(k.getGrad());
	    	korisnikDTO.setId(k.getId());
	    	korisnikDTO.setIme(k.getIme());
	    	korisnikDTO.setIsActive(k.getIsActive());
	    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
	    	korisnikDTO.setKgrupa(k.getKgrupa());
	    	korisnikDTO.setPassword(k.getPassword());
	    	korisnikDTO.setPol(k.getPol());
	    	korisnikDTO.setPrezime(k.getPrezime());
	    	korisnikDTO.setRole(k.getRoleName());
	    	korisnikDTO.setTelefon(k.getTelefon());
	    	korisnikDTO.setTezina(k.getTezina());
	    	korisnikDTO.setUsername(k.getUsername());
	    	korisnikDTO.setVisina(k.getVisina());
	    	 Korisnik kk=korisnikService.findOne(idL);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
			request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";

		}

	 @RequestMapping("/izmenaKartona/{pacijentId}/{lekarId}")
		public String editUserProfilIzBara(@PathVariable Long pacijentId, @PathVariable Long lekarId,HttpServletRequest request) {
		 Korisnik k=korisnikService.findOne(pacijentId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(k.getAdresa());
	    	korisnikDTO.setAlergije(k.getAlergije());
	    	korisnikDTO.setAnamneza(k.getAnamneza());
	    	korisnikDTO.setBolesti(k.getBolesti());
	    	korisnikDTO.setDatum(k.getDatum());
	    	korisnikDTO.setDioptrija(k.getDioptrija());
	    	korisnikDTO.setDrzava(k.getDrzava());
	    	korisnikDTO.setEmail(k.getEmail());
	    	korisnikDTO.setFirstLogin(k.getFirst_Login());
	    	korisnikDTO.setGrad(k.getGrad());
	    	korisnikDTO.setId(k.getId());
	    	korisnikDTO.setIme(k.getIme());
	    	korisnikDTO.setIsActive(k.getIsActive());
	    	korisnikDTO.setJedBrOsig(k.getJedBrOsig());
	    	korisnikDTO.setKgrupa(k.getKgrupa());
	    	korisnikDTO.setPassword(k.getPassword());
	    	korisnikDTO.setPol(k.getPol());
	    	korisnikDTO.setPrezime(k.getPrezime());
	    	korisnikDTO.setRole(k.getRoleName());
	    	korisnikDTO.setTelefon(k.getTelefon());
	    	korisnikDTO.setTezina(k.getTezina());
	    	korisnikDTO.setUsername(k.getUsername());
	    	korisnikDTO.setVisina(k.getVisina());
	    	 Korisnik kk=korisnikService.findOne(lekarId);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
		 	request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PREGLED");
			return "kartonPacijenta";  //bio je login
		}
	
	 
	 @RequestMapping("/istorijaIzvestaja/{pacijentId}/{lekarId}")
		public String istorijaIzvestaja(@PathVariable Long pacijentId,@PathVariable Long lekarId, HttpServletRequest request) {
		 
		 	System.out.println("NAS PACIJENNNT " + pacijentId);
		 	 Korisnik kk=korisnikService.findOne(lekarId);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
		 	 request.setAttribute("lekar", korisnikDTO1);
		 	 List<InformacijeOpregledu> iop=infoService.izvestajiDatogPacijenta(pacijentId);
		 	 List<InformacijeOpregleduDTO> iopDTO=new ArrayList<InformacijeOpregleduDTO>();
		 	 for(int i=0; i<iop.size();i++) {
		 		InformacijeOpregleduDTO iDTO=new InformacijeOpregleduDTO();
		 		iDTO.setDijagnozaId(iop.get(i).getDijagnozaId());
		 		iDTO.setId(iop.get(i).getId());
		 		iDTO.setInformacije(iop.get(i).getInformacije());
		 		iDTO.setLekarId(iop.get(i).getLekarId());
		 		iDTO.setLeks(iop.get(i).getLeks());
		 		iDTO.setOveren(iop.get(i).getOveren());
		 		iDTO.setPacijentId(iop.get(i).getPacijentId());
		 		iDTO.setPregledId(iop.get(i).getPregledId());
		 		iDTO.setTip(iop.get(i).getTip());
		 		iopDTO.add(iDTO);
		 	 }
		 	request.setAttribute("izvestaji", iopDTO);
			List<InformacijeOpregledu> niv=infoService.izvestajiDatogPacijenta(pacijentId);
			for(int i=0; i<niv.size();i++) {
			System.out.println(niv.get(i).getDijagnozaId());
			}
			request.setAttribute("mode", "MODE_PREGLED");

			return "istorijaIzvestaja";  //bio je login
		}
	 
	 @RequestMapping(value="/sacuvajKarton/{pacijentId}/{lekarId}",method = { RequestMethod.GET, RequestMethod.POST }) 
		public String sacuvajZK(@PathVariable Long pacijentId,@PathVariable Long lekarId,@ModelAttribute KorisnikDTO korisnikd, HttpServletRequest request) {
	  
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
			Korisnik novi=korisnikService.findOne(pacijentId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(novi.getAdresa());
	    	korisnikDTO.setAlergije(novi.getAlergije());
	    	korisnikDTO.setAnamneza(novi.getAnamneza());
	    	korisnikDTO.setBolesti(novi.getBolesti());
	    	korisnikDTO.setDatum(novi.getDatum());
	    	korisnikDTO.setDioptrija(novi.getDioptrija());
	    	korisnikDTO.setDrzava(novi.getDrzava());
	    	korisnikDTO.setEmail(novi.getEmail());
	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
	    	korisnikDTO.setGrad(novi.getGrad());
	    	korisnikDTO.setId(novi.getId());
	    	korisnikDTO.setIme(novi.getIme());
	    	korisnikDTO.setIsActive(novi.getIsActive());
	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
	    	korisnikDTO.setKgrupa(novi.getKgrupa());
	    	korisnikDTO.setPassword(novi.getPassword());
	    	korisnikDTO.setPol(novi.getPol());
	    	korisnikDTO.setPrezime(novi.getPrezime());
	    	korisnikDTO.setRole(novi.getRoleName());
	    	korisnikDTO.setTelefon(novi.getTelefon());
	    	korisnikDTO.setTezina(novi.getTezina());
	    	korisnikDTO.setUsername(novi.getUsername());
	    	korisnikDTO.setVisina(novi.getVisina());
	    	 Korisnik kk=korisnikService.findOne(lekarId);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
			request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PACIJENT");
			return "uspesan";

		}
	 
	 @GetMapping("/izmenaIzvestaja/{IId}/{lekarId}")
	    public ModelAndView izmenaIzvestaja(@PathVariable Long IId,@PathVariable Long lekarId,HttpServletRequest request) {
		 	Korisnik kor=korisnikService.findOne(lekarId);
		 	InformacijeOpregledu preg=infoService.findOne(IId);
		 	InformacijeOpregleduDTO iDTO=new InformacijeOpregleduDTO();
	 		iDTO.setDijagnozaId(preg.getDijagnozaId());
	 		iDTO.setId(preg.getId());
	 		iDTO.setInformacije(preg.getInformacije());
	 		iDTO.setLekarId(preg.getLekarId());
	 		iDTO.setLeks(preg.getLeks());
	 		iDTO.setOveren(preg.getOveren());
	 		iDTO.setPacijentId(preg.getPacijentId());
	 		iDTO.setPregledId(preg.getPregledId());
	 		iDTO.setTip(preg.getTip());
		 	request.setAttribute("novi", iDTO);
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
		 	
		 Korisnik novi=korisnikService.findOne(IId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(novi.getAdresa());
	    	korisnikDTO.setAlergije(novi.getAlergije());
	    	korisnikDTO.setAnamneza(novi.getAnamneza());
	    	korisnikDTO.setBolesti(novi.getBolesti());
	    	korisnikDTO.setDatum(novi.getDatum());
	    	korisnikDTO.setDioptrija(novi.getDioptrija());
	    	korisnikDTO.setDrzava(novi.getDrzava());
	    	korisnikDTO.setEmail(novi.getEmail());
	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
	    	korisnikDTO.setGrad(novi.getGrad());
	    	korisnikDTO.setId(novi.getId());
	    	korisnikDTO.setIme(novi.getIme());
	    	korisnikDTO.setIsActive(novi.getIsActive());
	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
	    	korisnikDTO.setKgrupa(novi.getKgrupa());
	    	korisnikDTO.setPassword(novi.getPassword());
	    	korisnikDTO.setPol(novi.getPol());
	    	korisnikDTO.setPrezime(novi.getPrezime());
	    	korisnikDTO.setRole(novi.getRoleName());
	    	korisnikDTO.setTelefon(novi.getTelefon());
	    	korisnikDTO.setTezina(novi.getTezina());
	    	korisnikDTO.setUsername(novi.getUsername());
	    	korisnikDTO.setVisina(novi.getVisina());
	    	 Korisnik kk=korisnikService.findOne(lekarId);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
		 
		 	request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PREGLED");
		 	ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("noviPL");
	        return modelAndView;  			
	 }
	
	 @GetMapping("/kreirajOperaciju/{IId}/{lekarId}")
	    public ModelAndView kreirajOperaciju(@PathVariable Long IId,@PathVariable Long lekarId,HttpServletRequest request) {
		 	
		 Korisnik novi=korisnikService.findOne(IId);
	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	    	korisnikDTO.setAdresa(novi.getAdresa());
	    	korisnikDTO.setAlergije(novi.getAlergije());
	    	korisnikDTO.setAnamneza(novi.getAnamneza());
	    	korisnikDTO.setBolesti(novi.getBolesti());
	    	korisnikDTO.setDatum(novi.getDatum());
	    	korisnikDTO.setDioptrija(novi.getDioptrija());
	    	korisnikDTO.setDrzava(novi.getDrzava());
	    	korisnikDTO.setEmail(novi.getEmail());
	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
	    	korisnikDTO.setGrad(novi.getGrad());
	    	korisnikDTO.setId(novi.getId());
	    	korisnikDTO.setIme(novi.getIme());
	    	korisnikDTO.setIsActive(novi.getIsActive());
	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
	    	korisnikDTO.setKgrupa(novi.getKgrupa());
	    	korisnikDTO.setPassword(novi.getPassword());
	    	korisnikDTO.setPol(novi.getPol());
	    	korisnikDTO.setPrezime(novi.getPrezime());
	    	korisnikDTO.setRole(novi.getRoleName());
	    	korisnikDTO.setTelefon(novi.getTelefon());
	    	korisnikDTO.setTezina(novi.getTezina());
	    	korisnikDTO.setUsername(novi.getUsername());
	    	korisnikDTO.setVisina(novi.getVisina());
	    	 Korisnik kk=korisnikService.findOne(lekarId);
		   		KorisnikDTO korisnikDTO1=new KorisnikDTO();
		    	korisnikDTO1.setAdresa(kk.getAdresa());
		    	korisnikDTO1.setAlergije(kk.getAlergije());
		    	korisnikDTO1.setAnamneza(kk.getAnamneza());
		    	korisnikDTO1.setBolesti(kk.getBolesti());
		    	korisnikDTO1.setDatum(kk.getDatum());
		    	korisnikDTO1.setDioptrija(kk.getDioptrija());
		    	korisnikDTO1.setDrzava(kk.getDrzava());
		    	korisnikDTO1.setEmail(kk.getEmail());
		    	korisnikDTO1.setFirstLogin(kk.getFirst_Login());
		    	korisnikDTO1.setGrad(kk.getGrad());
		    	korisnikDTO1.setId(kk.getId());
		    	korisnikDTO1.setIme(kk.getIme());
		    	korisnikDTO1.setIsActive(kk.getIsActive());
		    	korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
		    	korisnikDTO1.setKgrupa(kk.getKgrupa());
		    	korisnikDTO1.setPassword(kk.getPassword());
		    	korisnikDTO1.setPol(kk.getPol());
		    	korisnikDTO1.setPrezime(kk.getPrezime());
		    	korisnikDTO1.setRole(kk.getRoleName());
		    	korisnikDTO1.setTelefon(kk.getTelefon());
		    	korisnikDTO1.setTezina(kk.getTezina());
		    	korisnikDTO1.setUsername(kk.getUsername());
		    	korisnikDTO1.setVisina(kk.getVisina());
		 
		 
		 	request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PREGLED");
		 	ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("novaOL");
	        return modelAndView;  			
	 }

	 @RequestMapping(value="/sacuvajNoviPregled/{lekarId}/{pacijentId}",method = { RequestMethod.GET, RequestMethod.POST }) // korisnik povezan sa valuom iz js
		public String cuvajPregled(@PathVariable String lekarId,@PathVariable Long pacijentId,@ModelAttribute PregledDTO pregledDTO, BindingResult bindingResult,
				HttpServletRequest request) throws ParseException {
		
			Pregled o= new Pregled();
			Long novii=Long.parseLong(lekarId);
			LekarZaPrikazIPreglede leka=lpService.findVeza(novii);
			o.setIdlekarpregled(leka.getId().toString());
			o.setKorisnikId(novii);
			o.setIdpacijenta(pacijentId);
			o.setTerminpregled(pregledDTO.getTerminpregled());
			o.setObradjen(false);
			Pregled postoji=pService.terminZauzet(o.getTerminpregled(),o.getKorisnikId());
			Operacija postojiO=oService.terminZauzet(o.getTerminpregled(),o.getKorisnikId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Date date1 = sdf.parse(o.getTerminpregled());
			LocalDate sada=java.time.LocalDate.now();
			Date date3=java.sql.Date.valueOf(sada);
			if(date1.compareTo(date3) < 0 || postoji!=null || postojiO!=null) {
	        	System.out.println("Date1 is before Date3");
	        	Long n=Long.parseLong( lekarId );
	        	Korisnik novi=korisnikService.findOne(pacijentId);
	 	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	 	    	korisnikDTO.setAdresa(novi.getAdresa());
	 	    	korisnikDTO.setAlergije(novi.getAlergije());
	 	    	korisnikDTO.setAnamneza(novi.getAnamneza());
	 	    	korisnikDTO.setBolesti(novi.getBolesti());
	 	    	korisnikDTO.setDatum(novi.getDatum());
	 	    	korisnikDTO.setDioptrija(novi.getDioptrija());
	 	    	korisnikDTO.setDrzava(novi.getDrzava());
	 	    	korisnikDTO.setEmail(novi.getEmail());
	 	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
	 	    	korisnikDTO.setGrad(novi.getGrad());
	 	    	korisnikDTO.setId(novi.getId());
	 	    	korisnikDTO.setIme(novi.getIme());
	 	    	korisnikDTO.setIsActive(novi.getIsActive());
	 	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
	 	    	korisnikDTO.setKgrupa(novi.getKgrupa());
	 	    	korisnikDTO.setPassword(novi.getPassword());
	 	    	korisnikDTO.setPol(novi.getPol());
	 	    	korisnikDTO.setPrezime(novi.getPrezime());
	 	    	korisnikDTO.setRole(novi.getRoleName());
	 	    	korisnikDTO.setTelefon(novi.getTelefon());
	 	    	korisnikDTO.setTezina(novi.getTezina());
	 	    	korisnikDTO.setUsername(novi.getUsername());
	 	    	korisnikDTO.setVisina(novi.getVisina());
	 	    	
	 	    	Korisnik kk=korisnikService.findOne(n);
	 		   	KorisnikDTO korisnikDTO1=new KorisnikDTO();
	 		    korisnikDTO1.setAdresa(kk.getAdresa());
	 		    korisnikDTO1.setAlergije(kk.getAlergije());
	 		    korisnikDTO1.setAnamneza(kk.getAnamneza());
	 		    korisnikDTO1.setBolesti(kk.getBolesti());
	 		    korisnikDTO1.setDatum(kk.getDatum());
	 		    korisnikDTO1.setDioptrija(kk.getDioptrija());
	 		    korisnikDTO1.setDrzava(kk.getDrzava());
	 		    korisnikDTO1.setEmail(kk.getEmail());
	 		    korisnikDTO1.setFirstLogin(kk.getFirst_Login());
	 		    korisnikDTO1.setGrad(kk.getGrad());
	 		    korisnikDTO1.setId(kk.getId());
	 		    korisnikDTO1.setIme(kk.getIme());
	 		    korisnikDTO1.setIsActive(kk.getIsActive());
	 		    korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
	 		    korisnikDTO1.setKgrupa(kk.getKgrupa());
	 		    korisnikDTO1.setPassword(kk.getPassword());
	 		    korisnikDTO1.setPol(kk.getPol());
	 		    korisnikDTO1.setPrezime(kk.getPrezime());
	 		    korisnikDTO1.setRole(kk.getRoleName());
	 		    korisnikDTO1.setTelefon(kk.getTelefon());
	 		    korisnikDTO1.setTezina(kk.getTezina());
	 		    korisnikDTO1.setUsername(kk.getUsername());
	 		    korisnikDTO1.setVisina(kk.getVisina());
	 		 
	        	request.setAttribute("lekar", korisnikDTO1);
	 			request.setAttribute("korisnik", korisnikDTO);
	 			request.setAttribute("mode", "MODE_PACIJENT");
	 			
	        	 return "drugiDatumPregleda";
	        }
			pService.save(o);
			request.setAttribute("message", "uspesno kreirana operacija");
			Long n=Long.parseLong( lekarId );
			 Korisnik novi=korisnikService.findOne(pacijentId);
	 	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
	 	    	korisnikDTO.setAdresa(novi.getAdresa());
	 	    	korisnikDTO.setAlergije(novi.getAlergije());
	 	    	korisnikDTO.setAnamneza(novi.getAnamneza());
	 	    	korisnikDTO.setBolesti(novi.getBolesti());
	 	    	korisnikDTO.setDatum(novi.getDatum());
	 	    	korisnikDTO.setDioptrija(novi.getDioptrija());
	 	    	korisnikDTO.setDrzava(novi.getDrzava());
	 	    	korisnikDTO.setEmail(novi.getEmail());
	 	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
	 	    	korisnikDTO.setGrad(novi.getGrad());
	 	    	korisnikDTO.setId(novi.getId());
	 	    	korisnikDTO.setIme(novi.getIme());
	 	    	korisnikDTO.setIsActive(novi.getIsActive());
	 	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
	 	    	korisnikDTO.setKgrupa(novi.getKgrupa());
	 	    	korisnikDTO.setPassword(novi.getPassword());
	 	    	korisnikDTO.setPol(novi.getPol());
	 	    	korisnikDTO.setPrezime(novi.getPrezime());
	 	    	korisnikDTO.setRole(novi.getRoleName());
	 	    	korisnikDTO.setTelefon(novi.getTelefon());
	 	    	korisnikDTO.setTezina(novi.getTezina());
	 	    	korisnikDTO.setUsername(novi.getUsername());
	 	    	korisnikDTO.setVisina(novi.getVisina());
	 	    	
	 	    	Korisnik kk=korisnikService.findOne(n);
	 		   	KorisnikDTO korisnikDTO1=new KorisnikDTO();
	 		    korisnikDTO1.setAdresa(kk.getAdresa());
	 		    korisnikDTO1.setAlergije(kk.getAlergije());
	 		    korisnikDTO1.setAnamneza(kk.getAnamneza());
	 		    korisnikDTO1.setBolesti(kk.getBolesti());
	 		    korisnikDTO1.setDatum(kk.getDatum());
	 		    korisnikDTO1.setDioptrija(kk.getDioptrija());
	 		    korisnikDTO1.setDrzava(kk.getDrzava());
	 		    korisnikDTO1.setEmail(kk.getEmail());
	 		    korisnikDTO1.setFirstLogin(kk.getFirst_Login());
	 		    korisnikDTO1.setGrad(kk.getGrad());
	 		    korisnikDTO1.setId(kk.getId());
	 		    korisnikDTO1.setIme(kk.getIme());
	 		    korisnikDTO1.setIsActive(kk.getIsActive());
	 		    korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
	 		    korisnikDTO1.setKgrupa(kk.getKgrupa());
	 		    korisnikDTO1.setPassword(kk.getPassword());
	 		    korisnikDTO1.setPol(kk.getPol());
	 		    korisnikDTO1.setPrezime(kk.getPrezime());
	 		    korisnikDTO1.setRole(kk.getRoleName());
	 		    korisnikDTO1.setTelefon(kk.getTelefon());
	 		    korisnikDTO1.setTezina(kk.getTezina());
	 		    korisnikDTO1.setUsername(kk.getUsername());
	 		    korisnikDTO1.setVisina(kk.getVisina());
	 		 
	        	request.setAttribute("lekar", korisnikDTO1);
	 			request.setAttribute("korisnik", korisnikDTO);request.setAttribute("mode", "MODE_PACIJENT");
			
	 			return "uspesan";
		}
	 @RequestMapping(value="/sacuvajNovuOperaciju/{pacijentId}/{lekarId}",method = { RequestMethod.GET, RequestMethod.POST }) // korisnik povezan sa valuom iz js
		public String cuvajOperaciju(@PathVariable Long pacijentId,@PathVariable Long lekarId,@ModelAttribute OperacijaDTO operacijaDTO, BindingResult bindingResult,
				HttpServletRequest request) throws ParseException {
		
			Operacija o= new Operacija();
			
			o.setIdpacijenta(pacijentId);
			o.setKorisnikId(lekarId);
			LekarZaPrikazIPreglede leka=lpService.findVeza(lekarId);
			o.setIdlekaroperacija(leka.getId());
			o.setTerminoperacija(operacijaDTO.getTerminoperacija());
			o.setObradjen(false);
			oService.save(o);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Date date1 = sdf.parse(o.getTerminoperacija());
			LocalDate sada=java.time.LocalDate.now();
			Date date3=java.sql.Date.valueOf(sada);
			Pregled postoji=pService.terminZauzet(o.getTerminoperacija(),o.getKorisnikId());
			Operacija postojiO=oService.terminZauzet(o.getTerminoperacija(),o.getKorisnikId());
			
			if(date1.compareTo(date3) < 0 || postoji!=null || postojiO!=null) {
	        	System.out.println("Date1 is before Date3");
	        	request.setAttribute("lekar", korisnikService.findOne(lekarId));
	 			request.setAttribute("korisnik", korisnikService.findOne(pacijentId));
	 			request.setAttribute("mode", "MODE_PACIJENT");
	 			
	        	return "drugiDatumOperacija";
	        }
			request.setAttribute("message", "uspesno kreirana operacija");
			
			Korisnik novi=korisnikService.findOne(pacijentId);
 	   		KorisnikDTO korisnikDTO=new KorisnikDTO();
 	    	korisnikDTO.setAdresa(novi.getAdresa());
 	    	korisnikDTO.setAlergije(novi.getAlergije());
 	    	korisnikDTO.setAnamneza(novi.getAnamneza());
 	    	korisnikDTO.setBolesti(novi.getBolesti());
 	    	korisnikDTO.setDatum(novi.getDatum());
 	    	korisnikDTO.setDioptrija(novi.getDioptrija());
 	    	korisnikDTO.setDrzava(novi.getDrzava());
 	    	korisnikDTO.setEmail(novi.getEmail());
 	    	korisnikDTO.setFirstLogin(novi.getFirst_Login());
 	    	korisnikDTO.setGrad(novi.getGrad());
 	    	korisnikDTO.setId(novi.getId());
 	    	korisnikDTO.setIme(novi.getIme());
 	    	korisnikDTO.setIsActive(novi.getIsActive());
 	    	korisnikDTO.setJedBrOsig(novi.getJedBrOsig());
 	    	korisnikDTO.setKgrupa(novi.getKgrupa());
 	    	korisnikDTO.setPassword(novi.getPassword());
 	    	korisnikDTO.setPol(novi.getPol());
 	    	korisnikDTO.setPrezime(novi.getPrezime());
 	    	korisnikDTO.setRole(novi.getRoleName());
 	    	korisnikDTO.setTelefon(novi.getTelefon());
 	    	korisnikDTO.setTezina(novi.getTezina());
 	    	korisnikDTO.setUsername(novi.getUsername());
 	    	korisnikDTO.setVisina(novi.getVisina());
 	    	
 	    	Korisnik kk=korisnikService.findOne(lekarId);
 		   	KorisnikDTO korisnikDTO1=new KorisnikDTO();
 		    korisnikDTO1.setAdresa(kk.getAdresa());
 		    korisnikDTO1.setAlergije(kk.getAlergije());
 		    korisnikDTO1.setAnamneza(kk.getAnamneza());
 		    korisnikDTO1.setBolesti(kk.getBolesti());
 		    korisnikDTO1.setDatum(kk.getDatum());
 		    korisnikDTO1.setDioptrija(kk.getDioptrija());
 		    korisnikDTO1.setDrzava(kk.getDrzava());
 		    korisnikDTO1.setEmail(kk.getEmail());
 		    korisnikDTO1.setFirstLogin(kk.getFirst_Login());
 		    korisnikDTO1.setGrad(kk.getGrad());
 		    korisnikDTO1.setId(kk.getId());
 		    korisnikDTO1.setIme(kk.getIme());
 		    korisnikDTO1.setIsActive(kk.getIsActive());
 		    korisnikDTO1.setJedBrOsig(kk.getJedBrOsig());
 		    korisnikDTO1.setKgrupa(kk.getKgrupa());
 		    korisnikDTO1.setPassword(kk.getPassword());
 		    korisnikDTO1.setPol(kk.getPol());
 		    korisnikDTO1.setPrezime(kk.getPrezime());
 		    korisnikDTO1.setRole(kk.getRoleName());
 		    korisnikDTO1.setTelefon(kk.getTelefon());
 		   	korisnikDTO1.setTezina(kk.getTezina());
 		    korisnikDTO1.setUsername(kk.getUsername());
 		    korisnikDTO1.setVisina(kk.getVisina());
			
 		    request.setAttribute("lekar", korisnikDTO1);
			request.setAttribute("korisnik", korisnikDTO);
			request.setAttribute("mode", "MODE_PACIJENT");
			
			return "uspesan";
		}
	 
}
