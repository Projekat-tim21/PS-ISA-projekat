package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.OdobravanjePregleda;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.OdobravanjePregledaRepozitorijum;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.ZaposleniUKlinikamaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OdobravanjePregledaService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class LekarZaPrikazIPregledeController {

	private Logger logger = LoggerFactory.getLogger(LekarZaPrikazIPregledeController.class);

	@Autowired 
	private ZaposleniUKlinikamaRepository zRepo;
	
	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Autowired
	private KorisnikService korisnikServis;

	@Autowired
	private KorisnikRepository repoKorisnik;

	@Autowired
	private OdobravanjePregledaService opServis;

	@Autowired
	OdobravanjePregledaRepozitorijum opRepo;

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
	public String idemoDaPravimoPregled(@RequestParam("id") long idLekara,HttpServletRequest request) {
		
		LekarZaPrikazIPreglede lekarObjekat=new LekarZaPrikazIPreglede();
		lekarObjekat=lipServis.findOne(idLekara);
		HttpSession session = request.getSession();
		session.setAttribute("imeLekaraTransfer", lekarObjekat.getImelek());
		session.setAttribute("przLekaraTransfer", lekarObjekat.getPrezimelek());
		
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
		// System.out.println("id je" + id);
		String lekarId = request.getParameter("lekarId");
		System.out.println(request.getParameter("lekarId"));
		HttpSession session = request.getSession();
		session.setAttribute("lekarId", lekarId);
		long lekarId2 = Long.parseLong(lekarId);

		LekarZaPrikazIPreglede lekar = lipServis.findOne(lekarId2);

		TerminiSaId t = new TerminiSaId();
		t.setLekarime(lekar.getImelek());
		t.setTippregleda(lekar.getTipspecijalizacije());
		t.setLekarprezime(lekar.getPrezimelek());
		t.setCena(termini.getCena());
		t.setPopust(termini.getPopust());
		t.setSala(termini.getSala());
		t.setTermin(termini.getTermin());
		t.setLekarId(termini.getLekarId());
		t.setZakazan(false);// nije zakazan
		tisServis.saveMojTermin(t);
		request.setAttribute("message", "uspesno kreiran termin pregleda");
		request.setAttribute("mode", "VRATISE");
		return "adminZaPreglede";
	}

	@RequestMapping("/zakaziPregledKojiJeDef")
	public String prikazListeDefPregledaNaLoginu(HttpServletRequest request) {

		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByZakazan(false)) {
			if(termin.isPoslatnaobradu()==false) {
				termini.add(termin);
			}
		}

		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_PREGLEDI_SA_LOGINA");
		return "listaLekara";
	}

	// ovde ubaci za email
	@RequestMapping("/uspesnoZakazanPregled")
	public String uspesnoJePacijentZakazaoUnapredDefPregled(@RequestParam("id") long idkor,
			@RequestParam("idter") long idTermina, @ModelAttribute TerminiSaId t, BindingResult bindingResult,
			HttpServletRequest request) {

		long idKorisnika = idkor;
		Korisnik k = korisnikServis.findOne(idKorisnika);
		k.getUsername();
		k.getIme();
		k.getPrezime();
		long idTerminaZakazi = idTermina;
		TerminiSaId tip = new TerminiSaId();
		tip = tisServis.findOne(idTerminaZakazi);
		TerminiSaId ukojisipam = new TerminiSaId();
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

		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByZakazan(true)) {
			if (termin.getIdkorisnika() == idKorisnika) {
				termini.add(termin);
			}
		}

		try {
			emailService.sendNotificaitionZaZakazanePreglede(k);
		} catch (Exception e) {
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		request.setAttribute("termini", termini);

		request.setAttribute("mode", "ZAKAZANI_PREGLEDI");
		return "sviZakazaniPregledi";
	}

	@RequestMapping("/listaZakazanihPregleda")
	public String listaZakazanihPregleda(@RequestParam("id") long idkor, HttpServletRequest request) {

		long idKorisnika = idkor;
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByZakazan(true)) {
			if (termin.getIdkorisnika() == idKorisnika) {
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

	@RequestMapping("/naPregled")
	public String vratiSeNaPretragu(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSvePacijente());
		request.setAttribute("mode", "ALL_USERS");
		return "naPregledPacijenata";
	}

	@RequestMapping("/zakaziPregledNovi")
	public String zakaziPregled(HttpServletRequest request, Boolean zakazan) {
		return "zakaziPregledNovi";
	}

	@RequestMapping("/zKartonLekar")
	public String prikazZKartona(@RequestParam("id") Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		Korisnik k = korisnikServis.findOne(id);
		System.out.println(k.getVisina());
		request.setAttribute("mode", "MODE_ZKARTON");

		return "zKartonLekar";
	}

	@RequestMapping("/listaSvihDefinisanihPregledaZaLekara")
	public String prikazListePregeldaSaAdmina(@ModelAttribute TerminiSaId t, @ModelAttribute LekarZaPrikazIPreglede lip,
			BindingResult bindingResult,@RequestParam("id") long idLekara, HttpServletRequest request) {
		// uzeli smo id iz url-a
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);

		long lekarId = Long.parseLong(idZaPoredjenje);
		
		LekarZaPrikazIPreglede lekarObjekat=new LekarZaPrikazIPreglede();
		lekarObjekat=lipServis.findOne(lekarId);
		
		session.setAttribute("imeLekaraTransfer", lekarObjekat.getImelek());
		session.setAttribute("przLekaraTransfer", lekarObjekat.getPrezimelek());
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByZakazan(true)) {
			if(termin.getLekarId().equals(idLekara)) {
				termini.add(termin);
			}
		}

		LekarZaPrikazIPreglede p = lipServis.findOne(lekarId);
		request.setAttribute("lipi", p);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_PREGLEDI_SA_ADMINA");
		return "adminZaPreglede";
	}

	@RequestMapping("/listaSvihTermina")
	public String prikazListeTermina(@ModelAttribute TerminiSaId t, @ModelAttribute LekarZaPrikazIPreglede lip,
			BindingResult bindingResult, HttpServletRequest request) {
		// uzeli smo id iz url-a
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		
		LekarZaPrikazIPreglede lekarObjekat=new LekarZaPrikazIPreglede();
		long lekarId = Long.parseLong(idZaPoredjenje);
		lekarObjekat=lipServis.findOne(lekarId);
		session.setAttribute("imeLekaraTransfer", lekarObjekat.getImelek());
		session.setAttribute("przLekaraTransfer", lekarObjekat.getPrezimelek());
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			termini.add(termin);
		}
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI");
		return "adminZaPreglede";
	}

	
	@RequestMapping("/listaSvihTerminaPacijent2")
	public String prikazListeTerminaPacijent2(@RequestParam("idpac") int idpac, @ModelAttribute TerminiSaId t,
			@ModelAttribute LekarZaPrikazIPreglede lip, BindingResult bindingResult, HttpServletRequest request) {

		//String lazniIdKlinike="klinika";
		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		System.out.println("hej hej");
		for (TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			if (termin.isZakazan() == false) {
				termini.add(termin);
			}

		}
		long pacijentId = idpac;

		Korisnik korisnici = korisnikServis.findOne(pacijentId);
		request.setAttribute("korisnik", korisnici);
		//session.setAttribute("idklinike", idklinike);
		//System.out.println("id klinike je : " + idklinike);
		//session.setAttribute("idklinike", lazniIdKlinike);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI_KOPIJA");
		return "listaLekara";
	}
	
	
	
	
	
	
	@RequestMapping("/listaSvihTerminaPacijent")
	public String prikazListeTerminaPacijent(@RequestParam("idpac") int idpac,@RequestParam("idklinike") String idklinike, @ModelAttribute TerminiSaId t,
			@ModelAttribute LekarZaPrikazIPreglede lip, BindingResult bindingResult, HttpServletRequest request) {

		String idZaPoredjenje = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", idZaPoredjenje);
		long lekarId = Long.parseLong(idZaPoredjenje);
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		System.out.println("hej hej");
		for (TerminiSaId termin : tidRepo.findByLekarId(lekarId)) {
			if (termin.isZakazan() == false) {
				termini.add(termin);
			}

		}
		long pacijentId = idpac;

		Korisnik korisnici = korisnikServis.findOne(pacijentId);
		request.setAttribute("korisnik", korisnici);
		session.setAttribute("idklinike", idklinike);
		System.out.println("id klinike je : " + idklinike);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI");
		return "listaLekara";
	}

	@PostMapping("/posaljiZahtevZaPregledom")
	public String ZahtevZaPregledom(@RequestParam("id") long idpac,@RequestParam("idtermina") long idTerminaOvaj, @ModelAttribute TerminiSaId termini,
			@ModelAttribute Korisnik korisnik, @ModelAttribute LekarZaPrikazIPreglede lipi,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		//String hej=(String) session.getAttribute("idtermina");
	
		//long terminIdUhvacen = Long.parseLong(hej);
		TerminiSaId ter2 = new TerminiSaId();
		ter2 = tisServis.findOne(idTerminaOvaj);
		OdobravanjePregleda op = new OdobravanjePregleda();

		// sada upisujemo podatke u novu klasu kako bi slali zahtev adminu
		op.setImelekara(lipi.getImelek());
		op.setPrezimelekara(lipi.getPrezimelek());
		op.setTipspecijalizacije(lipi.getTipspecijalizacije());
		op.setImepacijenta(korisnik.getIme());
		op.setPrezimepacijenta(korisnik.getPrezime());
		op.setJedbrosigpac(korisnik.getJedBrOsig());
		op.setTerminzahtev(termini.getTermin());
		op.setCenaop(ter2.getCena());
		op.setPopustop(ter2.getPopust());
		op.setSalaop(ter2.getSala());
		op.setIdtermina(idTerminaOvaj);
		op.setLekaridop(ter2.getLekarId());
		op.setIdpacijenta(idpac);
		opServis.sacuvaj(op);
		tisServis.deleteMyTermin(ter2.getId());
		Korisnik k2 = korisnikServis.findByUsername("ak");
		try {
			emailService.slanjePorukeAdminuOZahtevuZaPregledom(k2);
		} catch (Exception e) {
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "loginBezDobrodosli";
	}

	@RequestMapping("/zahteviZaPregledom")
	public String zahteviKodAdmina(HttpServletRequest request) {
		request.setAttribute("opi", opServis.pokaziSveZahteveZaPregledom());
		request.setAttribute("mode", "ALL_ZAHTEVI");
		return "adminZaPreglede";
	}

	@GetMapping("/disable2/{opiId}")
	public String disable(@PathVariable Long opiId, HttpServletRequest request) {
		OdobravanjePregleda op = opServis.findOne(opiId);
		TerminiSaId t = new TerminiSaId();
		t.setCena(op.getCenaop());
		t.setId(op.getIdtermina());
		t.setLekarime(op.getImelekara());
		t.setLekarprezime(op.getPrezimelekara());
		t.setTippregleda(op.getTipspecijalizacije());
		t.setTermin(op.getTerminzahtev());
		t.setSala(op.getSalaop());
		t.setCena(op.getCenaop());
		t.setPopust(op.getPopustop());
		t.setZakazan(false);
		t.setLekarId(op.getLekaridop());
		t.setOdobrenpregled(false);

		t.setIdkorisnika(op.getIdpacijenta());

		Korisnik k = korisnikServis.findOne(op.getIdpacijenta());
		tisServis.saveMojTermin(t);

		request.setAttribute("korisnik", k);
		request.setAttribute("termin", t);
		request.setAttribute("opi", op);
		return "odbijanjePregleda";
	}

	@GetMapping("/enable2/{opiId}")
	public String enable(@PathVariable Long opiId) {
		OdobravanjePregleda op = opServis.findOne(opiId);
		TerminiSaId t = new TerminiSaId();
		t.setCena(op.getCenaop());
		t.setId(op.getIdtermina());
		t.setLekarime(op.getImelekara());
		t.setLekarprezime(op.getPrezimelekara());
		t.setTippregleda(op.getTipspecijalizacije());
		t.setTermin(op.getTerminzahtev());
		t.setSala(op.getSalaop());
		t.setCena(op.getCenaop());
		t.setPopust(op.getPopustop());
		t.setZakazan(false);
		t.setLekarId(op.getLekaridop());
		t.setIdkorisnika(op.getIdpacijenta());
		t.setOdobrenpregled(true);
		t.setPrikaz(true);
		
		tisServis.saveMojTermin(t);
		opRepo.delete(op);
		Korisnik k = repoKorisnik.findByJedBrOsig(op.getJedbrosigpac());

		try {
			emailService.sendNotificaitionOdobrenTermin(k);
		} catch (Exception e) {
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "redirect:/zahteviZaPregledom";
	}

	@GetMapping("/enable3/{terminId}")
	public String enable3(@PathVariable Long terminId, HttpServletRequest request) {
		TerminiSaId ter = tisServis.findOne(terminId);
		System.out.println(ter.getIdkorisnika());
		Korisnik k = korisnikServis.findOne(ter.getIdkorisnika());

		HttpSession session = request.getSession();
		session.setAttribute("id", ter.getIdkorisnika());
		session.setAttribute("username", k.getUsername());
		TerminiSaId t = tisServis.findOne(terminId);
		TerminiSaId tnovi = new TerminiSaId();
		tnovi.setCena(t.getCena());
		tnovi.setLekarime(t.getLekarime());
		tnovi.setLekarprezime(t.getLekarprezime());
		tnovi.setTippregleda(t.getTippregleda());
		tnovi.setTermin(t.getTermin());
		tnovi.setSala(t.getSala());
		tnovi.setPopust(t.getPopust());
		tnovi.setZakazan(true);
		tnovi.setPrikaz(false);

		tisServis.saveMojTermin(tnovi);

		return "redirect:/idiNaLoginPoslePotvrde";
	}

	@GetMapping("/disable3/{terminId}")
	public String disable3(@PathVariable Long terminId, HttpServletRequest request) {
		TerminiSaId ter = tisServis.findOne(terminId);
		System.out.println(ter.getIdkorisnika());
		Korisnik k = korisnikServis.findOne(ter.getIdkorisnika());

		HttpSession session = request.getSession();
		session.setAttribute("id", ter.getIdkorisnika());
		session.setAttribute("username", k.getUsername());
		TerminiSaId t = tisServis.findOne(terminId);
		TerminiSaId tnovi = new TerminiSaId();
		tnovi.setId(t.getId());
		tnovi.setCena(t.getCena());
		tnovi.setLekarime(t.getLekarime());
		tnovi.setLekarprezime(t.getLekarprezime());
		tnovi.setTippregleda(t.getTippregleda());
		tnovi.setTermin(t.getTermin());
		tnovi.setSala(t.getSala());
		tnovi.setPopust(t.getPopust());
		tnovi.setZakazan(false);
		tnovi.setOdobrenpregled(false);
		
		tisServis.deleteMyTerminObjekat(t);
		
		tisServis.saveMojTermin(tnovi);

		return "redirect:/idiNaLoginPoslePotvrde";
	}

	@PostMapping("/razlogOdbijanjaPregleda/{opiId}")
	public String mejlOdbijanja(@PathVariable Long opiId, HttpServletRequest request) {
		OdobravanjePregleda op = opServis.findOne(opiId);
		Korisnik k = korisnikServis.findOne(op.getIdpacijenta());

		String s = request.getParameter("razlog2");

		try {
			emailService.sendNotificaitionRazlogOdbijanjaTermina(k, s);
		} catch (Exception e) {
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		opRepo.delete(op);
		return "redirect:/zahteviZaPregledom";

	}

	
	@RequestMapping("/odobreniZahteviKodPacijentaSaMaila")
	public String odobreniZahteviKodPacijenta(HttpServletRequest request) {

		//String ida = request.getParameter("id");
		//HttpSession session = request.getSession();
		//session.setAttribute("id", ida);

		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByOdobrenpregled(true)) {
			if (termin.isPrikaz() != false)
				termini.add(termin);
		}

		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_ZAHTEVI_ODOBRENI_SA_MAILA_KAD_ULAZIM");
		return "odobreniZahteviPacijent";
	}
	
	
	
	@RequestMapping("/odobreniZahteviKodPacijenta")
	public String odobreniZahteviKodPacijenta(@RequestParam("id") int id, HttpServletRequest request) {

		String ida = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", ida);

		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for (TerminiSaId termin : tidRepo.findByOdobrenpregled(true)) {
			if (termin.isPrikaz() != false)
				termini.add(termin);
		}

		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_ZAHTEVI_ODOBRENI");
		return "odobreniZahteviPacijent";
	}


	@GetMapping("/uspesnoZakazanPregled2") // ovaj id je idpac iz zakazivanjePregledaIzaListeLekara
	public String uspesnoJePacijentZakazaoUnapredDefPregled2(@RequestParam("idpac") long idpac,
			@RequestParam("id") long idTermina, @ModelAttribute TerminiSaId t, BindingResult bindingResult,
			HttpServletRequest request) {

		OdobravanjePregleda op = new OdobravanjePregleda();
		System.out.println(idTermina + "  id termina je taj");
		HttpSession session = request.getSession();
		session.setAttribute("idtermina", idTermina);
		session.setAttribute("idpac", idpac);
		request.setAttribute("termini", tisServis.findOne(idTermina));
		TerminiSaId terminiSaId = tisServis.findOne(idTermina);
		
		long idLekara = terminiSaId.getLekarId();
		String pacijentId = request.getParameter("idHidden");
		session.getAttribute("idHidden");
		session.setAttribute("pacijentId", pacijentId);
		long pacijentIdnovi = idpac;

		Korisnik korisnici = korisnikServis.findOne(pacijentIdnovi);
		request.setAttribute("korisnik", korisnici);

		// sada upisujemo podatke u novu klasu kako bi slali zahtev adminu
		op.setImelekara(terminiSaId.getLekarime());
		op.setPrezimelekara(terminiSaId.getLekarprezime());
		op.setTipspecijalizacije(terminiSaId.getTippregleda());
		op.setImepacijenta(korisnici.getIme());
		op.setPrezimepacijenta(korisnici.getPrezime());
		op.setJedbrosigpac(korisnici.getJedBrOsig());
		
	
		request.setAttribute("lipi", lipServis.findOne(idLekara));
		request.setAttribute("termini", terminiSaId);
		request.setAttribute("mode", "ZAKAZI_PREGLED");
		return "zahtevZaPregledom";
	}


	@GetMapping("/zakazivanjePregledaIzaListeLekara")
	public String editUserProfilPregled(@RequestParam("idpac") int idpac, @ModelAttribute TerminiSaId tt,
			@RequestParam Long id, HttpServletRequest request) {

		OdobravanjePregleda op = new OdobravanjePregleda();

		String ida = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("idtermina", ida);
		session.setAttribute("id", ida);
		session.setAttribute("idpac", idpac);
		TerminiSaId terminiSaId = tisServis.findOne(id);
		long idLekara = terminiSaId.getLekarId();
		session.setAttribute("pacijentId", idpac);
		long pacijentIdnovi = idpac;

		Korisnik korisnici = korisnikServis.findOne(pacijentIdnovi);
		request.setAttribute("korisnik", korisnici);
		// sada upisujemo podatke u novu klasu kako bi slali zahtev adminu
		op.setImelekara(terminiSaId.getLekarime());
		op.setPrezimelekara(terminiSaId.getLekarprezime());
		op.setTipspecijalizacije(terminiSaId.getTippregleda());
		op.setImepacijenta(korisnici.getIme());
		op.setPrezimepacijenta(korisnici.getPrezime());
		op.setJedbrosigpac(korisnici.getJedBrOsig());
		request.setAttribute("termini", terminiSaId);
		request.setAttribute("lipi", lipServis.findOne(idLekara));
		request.setAttribute("mode", "ZAKAZI_PREGLED");
		return "zahtevZaPregledom";
	}

	@RequestMapping("/vratiSeNaLoginBezDobrodosli2")
	public String vracanjenapocetak(HttpServletRequest request) {
		return "loginBezDobrodosli2";
	}

	@RequestMapping("/saljemoZahtevZaPregledom")
	public String uspesnoPoslatZahtevAdminu(HttpServletRequest request) {
		return "loginBezDobrodosli2";
	}

	@RequestMapping("/idiNaLoginPoslePotvrde")
	public String potvrdjenPregled(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping("/naListuLekaraSaZakazivanjaPregleda")
	public String vratiSeNazadNaListuLekara(@RequestParam("idpac") long idpac,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String ovajIdKlinike=(String) session.getAttribute("idklinike");
		long idKlinike= Long.parseLong(ovajIdKlinike);
		System.out.println("id pac  "+idpac+"  idKlinike   "+idKlinike);
		ZaposleniUKlinikama uk =new ZaposleniUKlinikama();
		Klinika k=new Klinika();
		//HttpSession session = request.getSession();
		session.setAttribute("id", idpac);
	
		List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		List<ZaposleniUKlinikama> zaposleni=new ArrayList<ZaposleniUKlinikama>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(zaposlen);
			long idlekara=zaposlen.getIdlekara();
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(lip);
				}
					
			}
		}
		
		request.setAttribute("zaposleni", zaposleni);
		request.setAttribute("lipi", lipi);
		request.setAttribute("mode", "ALL_LEKARI_2");
		return "listaKlinika";
	}

	
	
	@RequestMapping("/naListuLekaraSaZakazivanjaPregleda2")
	public String vratiSeNazadNaListuLekara2(@RequestParam("idpac") long idpac,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//String ovajIdKlinike=(String) session.getAttribute("idklinike");
		//long idKlinike= Long.parseLong(ovajIdKlinike);
		//System.out.println("id pac  "+idpac+"  idKlinike   "+idKlinike);
		ZaposleniUKlinikama uk =new ZaposleniUKlinikama();
		Klinika k=new Klinika();
		//HttpSession session = request.getSession();
		session.setAttribute("id", idpac);
	/*
		List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		List<ZaposleniUKlinikama> zaposleni=new ArrayList<ZaposleniUKlinikama>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(zaposlen);
			long idlekara=zaposlen.getIdlekara();
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(lip);
				}
					
			}
		}
		*/
		//request.setAttribute("zaposleni", zaposleni);
		//request.setAttribute("lipi", lipi);
		//request.setAttribute("mode", "ALL_LEKARI_2");
		
		request.setAttribute("lipi", lipServis.pokaziSveKorisnikeKojiSuLekari());
		request.setAttribute("mode", "ALL_LEKARI");
		return "listaLekara";
		
		//return "redirect:/prikaziListuLekara";
	}
	
	
	
}