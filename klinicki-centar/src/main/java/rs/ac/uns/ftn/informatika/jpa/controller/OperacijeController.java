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

import rs.ac.uns.ftn.informatika.jpa.dto.OperacijaDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaKlinike;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaLekara;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.OperacijeRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OcenaKlinikeService;
import rs.ac.uns.ftn.informatika.jpa.service.OcenaLekaraServis;
import rs.ac.uns.ftn.informatika.jpa.service.OperacijeService;
import rs.ac.uns.ftn.informatika.jpa.service.ZaposleniUKlinikamaService;

@Controller
public class OperacijeController {

	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Autowired
	private LekarZaPrikazIPregledeRepository lipRepo;
	
	@Autowired
	private KlinikaRepository klinRepo;
	
	@Autowired
	private ZaposleniUKlinikamaService zipService;
	
	@Autowired
	private OcenaKlinikeService okServis;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private OcenaLekaraServis olServis;
	
	@Autowired
	private OperacijeService oServis;

	@Autowired
	private KlinikaService klinServis;
	
	@Autowired
	private OperacijeRepository oRepo;;
	
	@RequestMapping("/prikaziListuOperacija")
	public String idiNaPrikazListeOperacija(@RequestParam("id") int idpac,HttpServletRequest request) {
		
		List<OperacijaDTO> operacijedto = new ArrayList<OperacijaDTO>();
		for (Operacija operacija :  oRepo.findByObavljenaoperacija(true)) {
			if(operacija.getIdpacijenta()==idpac)
				operacijedto.add(new OperacijaDTO(operacija));
		}
		
		request.setAttribute("operacije", operacijedto);
		request.setAttribute("mode", "ALL_OPERACIJE");
		return "listaPregledaIOperacija";
	}

	
	@RequestMapping("/oceniLekaraOperacija")
	public String oceniLekaraIzListeOperacija(@RequestParam("idoperacije") int idoperacije,@RequestParam("idpacijenta") int idpac,@RequestParam("idlekar") int idlekar,HttpServletRequest request) {
	
		long idpacijenta=idpac;
		long idLekara=idlekar;
		long idOperacije=idoperacije;
		LekarZaPrikazIPreglede lip=lipServis.findOne(idLekara);
		Korisnik k=korisnikServis.findOne(idpacijenta);
		Operacija o=oServis.findOneById(idOperacije);
		request.setAttribute("operacija", o);
		request.setAttribute("korisnik", k);
		request.setAttribute("lip", lip);
		request.setAttribute("mode", "OCENA_LEKARA_SEKCIJA_OPERACIJA");
		return "listaPregledaIOperacija";
	}
	
	@RequestMapping("/oceniKlinikuOperacija")
	public String oceniKlinikuIzListeOperacija(@RequestParam("idoperacije") int idoperacije,@RequestParam("idpacijenta") int idpac,@RequestParam("idlekar") int idlekar,HttpServletRequest request) {
	
		long idpacijenta=idpac;
		long idLekara=idlekar;
		long idOperacije=idoperacije;
		ZaposleniUKlinikama zuk=zipService.findOne(idLekara);
		long idKlinikeKojuOcenjujem=zuk.getIdklinike(); 
		LekarZaPrikazIPreglede lip=lipServis.findOne(idLekara);
		Korisnik k=korisnikServis.findOne(idpacijenta);
		Operacija o=oServis.findOneById(idOperacije);
		
		request.setAttribute("operacija", o);
		request.setAttribute("korisnik", k);
		request.setAttribute("lip", lip);
		Klinika klin=klinServis.findOne(idKlinikeKojuOcenjujem);
		request.setAttribute("idKlinikeOvajTreba", klin.getId());
		request.setAttribute("klinika",klin);
		request.setAttribute("mode", "OCENA_KLINIKE_SEKCIJA_OPERACIJA");
		return "listaPregledaIOperacija";
	}
	
	
	@PostMapping("/ocenaKlinikeOperacija/{operacijaId}/{lekarid}/{korisnikid}/{klinikaid}")
	public String ocenaKlinikeOperacije(@ModelAttribute OperacijaDTO operacijadto,@PathVariable Long klinikaid,@PathVariable Long operacijaId,@PathVariable Long lekarid,@PathVariable Long korisnikid, HttpServletRequest request) {
		
		long idKlinike=klinikaid;
		long idKorisnika=korisnikid;
		OcenaKlinike ol=new OcenaKlinike();
		ol.setKorisnikid(idKorisnika);
		ol.setLekarid(lekarid);
		ol.setPregledid(operacijaId);
		ol.setKlinikaid(idKlinike); 
		okServis.saveOcenaKlinike(ol);
		
		double suma=0;
		double prosek=0;
		for(Klinika klin : klinRepo.findAll()) {
			if(klin.getId()==idKlinike) {
				suma=klin.getOcena()+operacijadto.getOcenaoperacije();
				prosek=suma/2;
			}
			klin.setOcena(prosek);  
			klinServis.saveOcenaKlinike(prosek, idKlinike); 
		}
		System.out.println("prosek klinike"+prosek);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("id", idKorisnika);
		session.setAttribute("idlek", lekarid);
		
		
		return "redirect:/idiNaLoginPoslePotvrde";

	}
	
	
	@PostMapping("/ocenaLekaraOperacije/{operacijaId}/{lekarid}/{korisnikid}")
	public String ocenalekaraOperacije(@ModelAttribute OperacijaDTO operacijadto,@PathVariable Long korisnikid,@PathVariable Long operacijaId,@PathVariable Long lekarid, HttpServletRequest request) {

		OcenaLekara ol=new OcenaLekara();
		ol.setKorisnikid(korisnikid);
		ol.setLekarid(lekarid);
		ol.setPregledid(operacijaId);
		ol.setOcenalek(operacijadto.getOcenaoperacije());
		olServis.saveOcenaLekara(ol);
		System.out.println("getOcenaoperacije  "+operacijadto.getOcenaoperacije());
		double suma=0;
		double prosek=0;
		for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
			if(lip.getId()==lekarid) {
				suma=lip.getOcena()+operacijadto.getOcenaoperacije();
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
	
	
}
