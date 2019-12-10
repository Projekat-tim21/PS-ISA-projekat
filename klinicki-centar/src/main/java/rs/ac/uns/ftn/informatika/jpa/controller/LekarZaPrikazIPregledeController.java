package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class LekarZaPrikazIPregledeController {

	@Autowired
	private LekarZaPrikazIPregledeService lipServis;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private TerminSaIdRepository tidRepo;
	
	@Autowired
	private TerminSaIdService tisServis;
	
	@GetMapping("/prikaziListuLekara")
	public String pokaziSveLekare(HttpServletRequest request) {
		request.setAttribute("lipi", lipServis.pokaziSveKorisnikeKojiSuLekari());
		request.setAttribute("mode", "ALL_LEKARI");
		return "listaLekara";
	}
	
	@GetMapping("/AdminPraviPreglede")
	public String adminPraviPreglede(HttpServletRequest request) {
		request.setAttribute("lipi", lipServis.pokaziSveKorisnikeKojiSuLekari());
		request.setAttribute("mode", "ALL_LEKARI");
		return "adminZaPreglede";
	}
	
	@GetMapping("/kreirajPregledZaLekara")
	public String idemoDaPravimoPregled(HttpServletRequest request) {
		//request.setAttribute("lipi", lipServis.pokaziSveKorisnikeKojiSuLekari());
		request.setAttribute("mode", "ALL_PRAVIMOO");
		return "adminZaPreglede";
	}
	
	@GetMapping("/vratiSe")
	public String vratiSe(HttpServletRequest request) {
		request.setAttribute("lipi", lipServis.pokaziSveKorisnikeKojiSuLekari());
		request.setAttribute("mode", "ALL_LEKARI");
		return "adminZaPreglede";
	}
	
	@PostMapping("/sacuvajTermine2") // korisnik povezan sa valuom iz js
	public String cuvajTermine(@ModelAttribute TerminiSaId termini, BindingResult bindingResult,
			HttpServletRequest request) {
		//System.out.println("id je" + id);
		String lekarId = request.getParameter("lekarId");
		System.out.println(request.getParameter("lekarId"));
		HttpSession session = request.getSession();
		session.setAttribute("lekarId", lekarId);
		
		TerminiSaId t = new TerminiSaId();
		t.setTermin(termini.getTermin());
		t.setLekarId(termini.getLekarId());
		tisServis.saveMojTermin(t);
		request.setAttribute("message", "uspesno kreiran termin pregleda");
		request.setAttribute("mode", "VRATISE");
		return "adminZaPreglede";
	}
	
	
	@RequestMapping("/listaSvihTermina")
	public String prikazListeTermina(@ModelAttribute TerminiSaId t,@ModelAttribute LekarZaPrikazIPreglede lip,  BindingResult bindingResult,HttpServletRequest request) {
		//uzeli smo id iz url-a
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			termini.add(termin);
		}
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI");
		return "adminZaPreglede";
	}
	
	@RequestMapping("/listaSvihTerminaPacijent")
	public String prikazListeTerminaPacijent(@RequestParam("idpac") int idpac,@ModelAttribute TerminiSaId t,@ModelAttribute LekarZaPrikazIPreglede lip,  BindingResult bindingResult,HttpServletRequest request) {
		//uzeli smo id iz url-a
		System.out.println(idpac);
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			termini.add(termin);
		}
		long pacijentId=idpac;
		//List<Korisnik> korisnici=new ArrayList<Korisnik>();
		//for(Korisnik korisnik : korisnikServis.findOne(pacijentId)) {
		//	termini.add(termin);
		//}
		Korisnik korisnici=korisnikServis.findOne(pacijentId);
		request.setAttribute("korisnik", korisnici);
		
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI");
		return "listaLekara";
	}
	
	@GetMapping("/zakazivanjePregledaIzaListeLekara")
	public String editUserProfilPregled(@RequestParam("idpac") int idpac,@ModelAttribute TerminiSaId tt,@RequestParam Long id, HttpServletRequest request) {
	
		request.setAttribute("termini", tisServis.findOne(id));
		TerminiSaId terminiSaId=tisServis.findOne(id);
		long idLekara=terminiSaId.getLekarId();
		//LekarZaPrikazIPreglede lekar=lipServis.findOne(idLekara);
		//String idKorisnika = request.getParameter("id");
		String pacijentId = request.getParameter("idHidden");
		System.out.println(request.getParameter("lekarId"));
		HttpSession session = request.getSession();
		session.getAttribute("idHidden");
		System.out.println("caos" + session.getAttribute("idHidden"));
		System.out.println(pacijentId);
		session.setAttribute("pacijentId", pacijentId);
		TerminiSaId ttt=new TerminiSaId();
		long pacijentIdnovi=idpac;
		
		Korisnik korisnici=korisnikServis.findOne(pacijentIdnovi);
		request.setAttribute("korisnik", korisnici);
		
		//request.setAttribute("korisnik", korisnikServis.findOne(idKorisnika));
		request.setAttribute("lipi", lipServis.findOne(idLekara));
		request.setAttribute("mode", "ZAKAZI_PREGLED");
		return "zahtevZaPregledom";
	}
	
	
	/*
	
	@PostMapping("/sacuvajTermine") // korisnik povezan sa valuom iz js
	public String registerKorisnik(@ModelAttribute TerminiSaId termin, BindingResult bindingResult,
			HttpServletRequest request) {

		//Korisnik existingUser = userRepository.findByUsername(korisnikd.getUsername());

		//if (existingUser != null) {

		//	request.setAttribute("errorMessage", "Invalid username");
		//	return "ispravka";

		//} else {
		TerminiSaId t = new TerminiSaId();
			t.setId(termin.getId());
			t.setTermin(termin.getTermin());
			System.out.println(k.getRoleName());
			korisnikServis.saveMogKorisnika(k);

			


			return "welcomepage";
		}

	}
	
	*/
	
	
	
	
}
