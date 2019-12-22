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

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.OcenaLekara;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.OperacijeRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OcenaLekaraServis;
import rs.ac.uns.ftn.informatika.jpa.service.OperacijeService;

@Controller
public class OperacijeController {

	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Autowired
	private LekarZaPrikazIPregledeRepository lipRepo;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private OcenaLekaraServis olServis;
	
	@Autowired
	private OperacijeService oServis;

	@Autowired
	private OperacijeRepository oRepo;;
	
	@RequestMapping("/prikaziListuOperacija")
	public String idiNaPrikazListeOperacija(@RequestParam("id") int idpac,HttpServletRequest request) {
		
		List<Operacija> operacije = new ArrayList<Operacija>();
		for (Operacija operacija :  oRepo.findByObavljenaoperacija(true)) {
			if(operacija.getIdpacijenta()==idpac)
				operacije.add(operacija);
		}
		
		request.setAttribute("operacije", operacije);
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
	
	
	@PostMapping("/ocenaLekaraOperacije/{operacijaId}/{lekarid}/{korisnikid}")
	public String mejlOdbijanja(@ModelAttribute Operacija operacija,@PathVariable Long korisnikid,@PathVariable Long operacijaId,@PathVariable Long lekarid, HttpServletRequest request) {

		OcenaLekara ol=new OcenaLekara();
		ol.setKorisnikid(korisnikid);
		ol.setLekarid(lekarid);
		ol.setPregledid(operacijaId);
		ol.setOcenalek(operacija.getOcenaoperacije());
		olServis.saveOcenaLekara(ol);
		
		double suma=0;
		double prosek=0;
		//List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
			if(lip.getId()==lekarid) {
				suma=lip.getOcena()+operacija.getOcenaoperacije();
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
