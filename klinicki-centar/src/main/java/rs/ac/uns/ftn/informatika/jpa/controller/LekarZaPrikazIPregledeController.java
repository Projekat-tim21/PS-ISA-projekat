package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;

import rs.ac.uns.ftn.informatika.jpa.model.Role;

import rs.ac.uns.ftn.informatika.jpa.model.OdobravanjePregleda;

import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OdobravanjePregledaService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class LekarZaPrikazIPregledeController {

	private Logger logger = LoggerFactory.getLogger(LekarZaPrikazIPregledeController.class);
	
	@Autowired
	private LekarZaPrikazIPregledeService lipServis;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private KorisnikRepository repoKorisnik;
	
	@Autowired
	private OdobravanjePregledaService opServis;
	
	@Autowired
	private EmailService emailService;
	
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
		long lekarId2 = Long.parseLong(lekarId);
		
		
		LekarZaPrikazIPreglede lekar=lipServis.findOne(lekarId2);
		
		TerminiSaId t = new TerminiSaId();
		t.setLekarime(lekar.getImelek());
		t.setTippregleda(lekar.getTipspecijalizacije());
		t.setLekarprezime(lekar.getPrezimelek());
		t.setCena(termini.getCena());
		t.setPopust(termini.getPopust());
		t.setSala(termini.getSala());
		t.setTermin(termini.getTermin());
		t.setLekarId(termini.getLekarId());
		t.setZakazan(false);//nije zakazan
		tisServis.saveMojTermin(t);
		request.setAttribute("message", "uspesno kreiran termin pregleda");
		request.setAttribute("mode", "VRATISE");
		return "adminZaPreglede";
	}
	
	@RequestMapping("/zakaziPregledKojiJeDef")
	public String prikazListeDefPregledaNaLoginu(HttpServletRequest request) {
	
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByZakazan(false)) {
			termini.add(termin);
		}
		
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_PREGLEDI_SA_LOGINA");
		return "listaLekara";
	}
	
	
	/*
	@RequestMapping("/zakaziPregledKojiJeDef")
	public String prikazListeZakazanihPregleda(HttpServletRequest request) {
	
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByZakazan(false)) {
			termini.add(termin);
		}
		
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ZAKAZANI_PREGLEDI2");
		return "listaLekara";
	}*/
	
	
	
	
	//ovde ubaci za email
	@RequestMapping("/uspesnoZakazanPregled")
	public String uspesnoJePacijentZakazaoUnapredDefPregled(@RequestParam("id") long idkor,@RequestParam("idter") long idTermina,@ModelAttribute TerminiSaId t, BindingResult bindingResult,HttpServletRequest request) {
	
		long idKorisnika=idkor;
		Korisnik k=korisnikServis.findOne(idKorisnika);
		k.getUsername();
		k.getIme();
		k.getPrezime();
		long idTerminaZakazi = idTermina;
		TerminiSaId tip=new TerminiSaId();
		tip=tisServis.findOne(idTerminaZakazi);
		TerminiSaId ukojisipam=new TerminiSaId();
		//System.out.println("ovde je zakazan termin  "+tip.isZakazan());
		ukojisipam.setZakazan(true);
		ukojisipam.setId(tip.getId());
		ukojisipam.setCena(tip.getCena());
		ukojisipam.setLekarId(tip.getLekarId());
		ukojisipam.setLekarprezime(tip.getLekarprezime());
		ukojisipam.setLekarime(tip.getLekarime());
		ukojisipam.setPopust(tip.getPopust());
		ukojisipam.setSala(tip.getSala());
		ukojisipam.setTermin(tip.getTermin());
		ukojisipam.setTippregleda(tip.getTippregleda());
		ukojisipam.setIdkorisnika(idKorisnika);
		tisServis.saveMojTermin(ukojisipam);
	
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByZakazan(true)) {
			if(termin.getIdkorisnika()==idKorisnika) {
				termini.add(termin);
			}
		}
		
		try {
			emailService.sendNotificaitionZaZakazanePreglede(k);
		} catch (Exception e) {
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		
		request.setAttribute("termini", termini);
		
		//request.setAttribute("termini",tisServis.findOne(idTerminaZakazi));
		request.setAttribute("mode", "ZAKAZANI_PREGLEDI");
		return "sviZakazaniPregledi";
	}
	
	
	
	@RequestMapping("/listaZakazanihPregleda")
	public String listaZakazanihPregleda(@RequestParam("id") long idkor,HttpServletRequest request) {
	
		long idKorisnika=idkor;
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByZakazan(true)) {
			if(termin.getIdkorisnika()==idKorisnika) {
			termini.add(termin);
			}
		}
		
		request.setAttribute("termini", termini);
		
		request.setAttribute("mode", "ZAKAZANI_PREGLEDI");
		return "sviZakazaniPregledi";
	}
	
	@RequestMapping("/zapocniPregled")
	public String zapocniPregledLekar(HttpServletRequest request) {
		request.setAttribute("mode", "ZAPOCNI_PREGLED");
		return "zapocniPregled";
	}
	
	@RequestMapping("/naPocetnu")
	public String vratiSeNazad(HttpServletRequest request) {
		return "naStranicuLekara";
	}
	
	//JECA
	/*@PostMapping("/sacuvajUKarton")
	public String sacuvajUZKarton(@ModelAttribute KorisnikDTO kdto, BindingResult bindingResult,
			HttpServletRequest request) {
		
		Korisnik korisnik = new Korisnik();
		korisnik.setId(kdto.getId());
		korisnik.setIme(kdto.getIme());
		korisnik.setPrezime(kdto.getPrezime());
		korisnik.setDatum(kdto.getDatum());
		korisnik.setJedBrOsig(kdto.getJedBrOsig());
		korisnik.setPol(kdto.getPol());
		korisnik.setVisina(kdto.getVisina());
		korisnik.setTezina(kdto.getTezina());
		korisnik.setKgrupa(kdto.getKgrupa());
		korisnik.setDioptrija(kdto.getDioptrija());
		korisnik.setAlergije(kdto.getAlergije());
		korisnik.setBolesti(kdto.getBolesti());
		korisnik.setAnamneza(kdto.getAnamneza());
		korisnik.setRoleName(Role.PACIJENT.name());
		korisnikServis.sacuvajKarton(korisnik);


		request.setAttribute("mode", "HOME_PAGE_LEKAR");
		
		return "lekarStranica";
	}
	*/
	
	@RequestMapping("/naPregled")
	public String vratiSeNaPretragu(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSvePacijente());
		request.setAttribute("mode", "ALL_USERS");
		return "naPregledPacijenata";
	}
	
	@RequestMapping("/zakaziPregledNovi")
	public String zakaziPregled(HttpServletRequest request, Boolean zakazan) {
		//request.setAttribute("datumi", pServis.ListaDatuma());
	//	request.setAttribute("mode", "ALL_DATUMI");
		return "zakaziPregledNovi";
	}
	
	@RequestMapping("/zKartonLekar")
	public String prikazZKartona(@RequestParam("id") Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		Korisnik k=korisnikServis.findOne(id);
		System.out.println(k.getVisina());
		request.setAttribute("mode", "MODE_ZKARTON");
		
		return "zKartonLekar";
	}
	
	
	@RequestMapping("/listaSvihDefinisanihPregledaZaLekara")
	public String prikazListePregeldaSaAdmina(@ModelAttribute TerminiSaId t,@ModelAttribute LekarZaPrikazIPreglede lip,  BindingResult bindingResult,HttpServletRequest request) {
		//uzeli smo id iz url-a
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		for(TerminiSaId termin : tidRepo.findByZakazan(false)) {
				termini.add(termin);
		}
		
		LekarZaPrikazIPreglede p=lipServis.findOne(lekarId);
		request.setAttribute("lipi", p);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_PREGLEDI_SA_ADMINA");
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
		
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini=new ArrayList<TerminiSaId>();
		System.out.println("hej hej");
		for(TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			if(termin.isZakazan()==false) {
				termini.add(termin);
			}
			
		}
		long pacijentId=idpac;
	
		
		Korisnik korisnici=korisnikServis.findOne(pacijentId);
		request.setAttribute("korisnik", korisnici);
		
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI");
		return "listaLekara";
	}
	
	
	
	@PostMapping("/posaljiZahtevZaPregledom")
	public String ZahtevZaPregledom(@ModelAttribute TerminiSaId termini,@ModelAttribute Korisnik korisnik, @ModelAttribute LekarZaPrikazIPreglede lipi, HttpServletRequest request) {
	
		OdobravanjePregleda op=new OdobravanjePregleda();
		HttpSession session = request.getSession();
		session.getAttribute("imepac");
		//sada upisujemo podatke u novu klasu kako bi slali zahtev adminu
		op.setImelekara(lipi.getImelek());
		op.setPrezimelekara(lipi.getPrezimelek());
		op.setTipspecijalizacije(lipi.getTipspecijalizacije());
		op.setImepacijenta(korisnik.getIme());
		op.setPrezimepacijenta(korisnik.getPrezime());
		op.setJedbrosigpac(korisnik.getJedBrOsig());
		op.setTerminzahtev(termini.getTermin());
		TerminiSaId ter=new TerminiSaId();
		ter=tidRepo.findByTermin(termini.getTermin());
		op.setCenaop(ter.getCena());
		op.setPopustop(ter.getPopust());
		op.setSalaop(ter.getSala());
		op.setIdtermina(ter.getId());
		op.setLekaridop(ter.getLekarId());
		
		
		opServis.sacuvaj(op);
		
		//request.setAttribute("korisnik", korisnikServis.findOne(idKorisnika));
		//request.setAttribute("lipi", lipServis.findOne(idLekara));
		//request.setAttribute("mode", "ZAKAZI_PREGLED");
		return "loginBezDobrodosli";
	}
	
	
	@RequestMapping("/zahteviZaPregledom")
	public String zahteviKodAdmina(HttpServletRequest request) {
		request.setAttribute("opi", opServis.pokaziSveZahteveZaPregledom());
		request.setAttribute("mode", "ALL_ZAHTEVI");
        return "adminZaPreglede";
	}
	
	
	
	  @GetMapping("/enable2/{opiId}")
	    public String enable(@PathVariable Long opiId) {
		  OdobravanjePregleda op=opServis.findOne(opiId);
	        TerminiSaId t=new TerminiSaId();
	        t.setCena(op.getCenaop());
	        t.setId(op.getIdtermina());
	        t.setLekarime(op.getImelekara());
	        t.setLekarprezime(op.getPrezimelekara());
	        t.setTippregleda(op.getTipspecijalizacije());
	        t.setTermin(op.getTerminzahtev());
	        t.setSala(op.getSalaop());
	        t.setCena(op.getCenaop());
	        t.setPopust(op.getPopustop());
	        t.setZakazan(true);
	        t.setLekarId(op.getLekaridop());
	        tisServis.saveMojTermin(t);
	        
	        
	        Korisnik k=repoKorisnik.findByJedBrOsig(op.getJedbrosigpac());
	        
	        //t.setPacijentjbo(op.getJedbrosigpac());
	        //t.setPacijentprz(op.getPrezimepacijenta());
	        //t.setZakazan(true);
	        //t.setCena(cena);
	        
	        try {
				emailService.sendNotificaitionOdobrenTermin(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviZaPregledom";
	    }
	
	
	@GetMapping("/zakazivanjePregledaIzaListeLekara")
	public String editUserProfilPregled(@RequestParam("idpac") int idpac,@ModelAttribute TerminiSaId tt,@RequestParam Long id, HttpServletRequest request) {
	
		OdobravanjePregleda op=new OdobravanjePregleda();
		
		String ida = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", ida);
		session.setAttribute("idpac", idpac);
		
		request.setAttribute("termini", tisServis.findOne(id));
		TerminiSaId terminiSaId=tisServis.findOne(id);
		long idLekara=terminiSaId.getLekarId();
		//LekarZaPrikazIPreglede lekar=lipServis.findOne(idLekara);
		//String idKorisnika = request.getParameter("id");
		String pacijentId = request.getParameter("idHidden");
		//System.out.println(request.getParameter("lekarId"));
		//HttpSession session = request.getSession();
		session.getAttribute("idHidden");
		//System.out.println("caos" + session.getAttribute("idHidden"));
		//System.out.println(pacijentId);
		session.setAttribute("pacijentId", pacijentId);
		TerminiSaId ttt=new TerminiSaId();
		long pacijentIdnovi=idpac;
		
		Korisnik korisnici=korisnikServis.findOne(pacijentIdnovi);
		request.setAttribute("korisnik", korisnici);
		
		//sada upisujemo podatke u novu klasu kako bi slali zahtev adminu
		op.setImelekara(terminiSaId.getLekarime());
		op.setPrezimelekara(terminiSaId.getLekarprezime());
		op.setTipspecijalizacije(terminiSaId.getTippregleda());
		op.setImepacijenta(korisnici.getIme());
		op.setPrezimepacijenta(korisnici.getPrezime());
		op.setJedbrosigpac(korisnici.getJedBrOsig());
		
		//request.setAttribute("korisnik", korisnikServis.findOne(idKorisnika));
		request.setAttribute("lipi", lipServis.findOne(idLekara));
		request.setAttribute("mode", "ZAKAZI_PREGLED");
		return "zahtevZaPregledom";
	}
	
	
	@RequestMapping("/vratiSeNaLoginBezDobrodosli2")
	public String vracanjenapocetak(HttpServletRequest request) {
		
	
		//request.setAttribute("termini", termini);
		//request.setAttribute("mode", "ALL_TERMINI");
		return "loginBezDobrodosli2";
	}
	
	@RequestMapping("/saljemoZahtevZaPregledom")
	public String uspesnoPoslatZahtevAdminu(HttpServletRequest request) {
		
		//long idpacijenta=idpac;
		//System.out.println("id pac         "+idpacijenta);
		//request.setAttribute("termini", termini);
		//request.setAttribute("mode", "VRACAJ_SE_NAZAD");
		//return "zahtevZaPregledom";
		//request.setAttribute("mode", "ZAKAZANI_PREGLEDI");
		return "loginBezDobrodosli2";
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
