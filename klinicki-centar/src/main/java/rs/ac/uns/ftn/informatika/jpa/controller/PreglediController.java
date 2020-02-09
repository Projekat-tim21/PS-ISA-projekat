package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.dto.PregledDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaKlinike;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaLekara;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OcenaKlinikeService;
import rs.ac.uns.ftn.informatika.jpa.service.OcenaLekaraServis;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;
import rs.ac.uns.ftn.informatika.jpa.service.ZaposleniUKlinikamaService;

@Controller
public class PreglediController {

	@Autowired
	private  PregledService pServis;
	
	@Autowired
	private KlinikaRepository klinRepo;
	
	@Autowired
	private OcenaKlinikeService okServis;
	
	@Autowired
	private KlinikaService klinServis;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private ZaposleniUKlinikamaService zipService;
	
	@Autowired
	private PregledRepository pregledRep;
	
	@Autowired
	private OcenaLekaraServis olServis;
	
	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Autowired
	private LekarZaPrikazIPregledeRepository lipRepo;
	
	@RequestMapping("/preglediIoperacijePrikaz")
	public String prikazStraniceListaPregledaIOperacija(HttpServletRequest request) {
		return "listaPregledaIOperacijaPocetna";
	}
	
	
	@RequestMapping("/prikaziListuPregleda")
	public String idiNaPrikazListePregelda(@RequestParam("id") int idpac,HttpServletRequest request) {
		
		List<PregledDTO> pregledidto = new ArrayList<PregledDTO>();
		for (Pregled pregled :  pregledRep.findByObavljenpregled(true)) {
			if(pregled.getIdpacijenta()==idpac)
				pregledidto.add(new PregledDTO(pregled));
		}

		request.setAttribute("pregledi", pregledidto);
		request.setAttribute("mode", "ALL_PREGLEDI");
		return "listaPregledaIOperacija";
	}
	
	@RequestMapping("/naLogin")
	public String koranUnazad(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	@RequestMapping("/odustaniOdOcenjivanjaLekaraPregled")
	public String odustaniOdOcenjivanjaLekaraPregled(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	@RequestMapping("/odustaniOdOcenjivanjaKlinikePregled")
	public String odustaniOdOcenjivanjaKlinikePregled(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	

	@RequestMapping("/odustaniOdOcenjivanjaKlinikePregled2")
	public String odustaniOdOcenjivanjaKlinikePregled2(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	
	@RequestMapping("/odustaniOdOcenjivanjaLekaraPregled3")
	public String odustaniOdOcenjivanjaKlinikePregled3(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	
	@RequestMapping("/oceniLekaraPregled")
	public String oceniLekaraIzListePregleda(@RequestParam("idpregleda") int idpregled,@RequestParam("idpacijenta") int idpac,@RequestParam("idlekar") int idlekar,HttpServletRequest request) {
		long idpacijenta=idpac;
		long idLekara=idlekar;
		long idPregled=idpregled;
		LekarZaPrikazIPreglede lip=lipServis.findOne(idLekara);
		Korisnik k=korisnikServis.findOne(idpacijenta);
		Pregled p=pServis.findOneById(idPregled);
	
		request.setAttribute("pregled", p);
		request.setAttribute("korisnik", k);
		request.setAttribute("lip", lip);
		request.setAttribute("mode", "OCENA_LEKARA_SEKCIJA_PREGLED");
		return "listaPregledaIOperacija";
	}
	
	

	@PostMapping("/ocenaLekaraPregled/{pregledId}/{lekarid}/{korisnikid}")
	public String mejlOdbijanja(@ModelAttribute PregledDTO pregleddto,@PathVariable Long korisnikid,@PathVariable Long pregledId,@PathVariable Long lekarid, HttpServletRequest request) {

		OcenaLekara ol=new OcenaLekara();
		ol.setKorisnikid(korisnikid);
		ol.setLekarid(lekarid);
		ol.setPregledid(pregledId);
		ol.setOcenalek(pregleddto.getOcenapregleda());
		olServis.saveOcenaLekara(ol);
		
		double suma=0;
		double prosek=0;
		for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
			if(lip.getId()==lekarid) {
				suma=lip.getOcena()+pregleddto.getOcenapregleda();
				prosek=suma/2;
			}
			lip.setOcena(prosek);
			lipServis.saveOcenaLekara(prosek, lekarid);
			
		}
		System.out.println(prosek);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("id", korisnikid);
		session.setAttribute("idlek", lekarid);
		
		return "redirect:/idiNaLoginPoslePotvrde";
	}
	
	@RequestMapping("/oceniKlinikuPregled")
	public String oceniKlinikuIzListeOperacija(@RequestParam("idlekar") int idlekar,@RequestParam("idpacijenta") int idpac,@RequestParam("idpregleda") int idpregleda,HttpServletRequest request) {
	
		long idpacijenta=idpac;
		long idLekara=idlekar;
		long idPregleda=idpregleda;
		ZaposleniUKlinikama zuk=zipService.findOne(idLekara);
		long idKlinikeKojuOcenjujem=zuk.getIdklinike(); 
		LekarZaPrikazIPreglede lip=lipServis.findOne(idLekara);
		Korisnik k=korisnikServis.findOne(idpacijenta);
		Pregled p=pServis.findOneById(idPregleda);
		request.setAttribute("pregled", p);
		request.setAttribute("korisnik", k);
		request.setAttribute("lip", lip);
		Klinika klin=klinServis.findOne(idKlinikeKojuOcenjujem);
		request.setAttribute("klinika",klin);
		request.setAttribute("mode", "OCENA_KLINIKE_SEKCIJA_PREGLED");
		return "listaPregledaIOperacija";
	}
	
	
	@PostMapping("/ocenaKlinikePregled/{idpregleda}/{lekarid}/{korisnikid}/{klinikaid}")
	public String ocenaKlinikePregled(@ModelAttribute PregledDTO pregleddto,@PathVariable Long idpregleda,@PathVariable Long klinikaid,@PathVariable Long lekarid,@PathVariable Long korisnikid, HttpServletRequest request) {

		long idKlinike=klinikaid;
		HttpSession session = request.getSession();
		long idKorisnika=korisnikid;
		OcenaKlinike ol=new OcenaKlinike();
		ol.setKorisnikid(idKorisnika);
		ol.setLekarid(lekarid);
		ol.setPregledid(idpregleda);
		ol.setKlinikaid(idKlinike); 
		okServis.saveOcenaKlinike(ol);
		double suma=0;
		double prosek=0;
		
		for(Klinika klin : klinRepo.findAll()) {
			if(klin.getId()==idKlinike) {
				suma=klin.getOcena()+pregleddto.getOcenapregleda();
				prosek=suma/2;
			}
			klin.setOcena(prosek);  
			klinServis.saveOcenaKlinike(prosek, idKlinike); 
		}
		System.out.println("prosek klinike pregled"+prosek);
		
		
		session.setAttribute("id", idKorisnika);
		session.setAttribute("idlek", lekarid);
		
		return "redirect:/idiNaLoginPoslePotvrde";

	}
	

}
