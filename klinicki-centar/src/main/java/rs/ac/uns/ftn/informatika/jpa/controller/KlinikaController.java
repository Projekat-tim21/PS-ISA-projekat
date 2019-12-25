package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.ZaposleniUKlinikamaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;
import rs.ac.uns.ftn.informatika.jpa.service.ZaposleniUKlinikamaService;

@Controller
public class KlinikaController {

	@Autowired
	private  KlinikaService klinikaServis;
	
	@Autowired
	private TerminSaIdService tisServis;
	
	@Autowired 
	private ZaposleniUKlinikamaRepository zRepo;
	
	@Autowired 
	private LekarZaPrikazIPregledeRepository lipRepo;
	
	@Autowired
	private  ZaposleniUKlinikamaService zaposleniServis;
	
	@Autowired
	private LekarZaPrikazIPregledeService lipServis;
	
	@RequestMapping("/listaSvihKlinika")
	public String idiNaPrikazListeKlinika(HttpServletRequest request) {
		request.setAttribute("klinike", klinikaServis.pokaziSveKlinike());
		request.setAttribute("mode", "ALL_KLINIKE");
		return "listaKlinika";
	}
	
	@RequestMapping("/korakUnazadNaLogin")
	public String korakNazad(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	@RequestMapping("/lekariUKlinici")
	public String pokaziSveLekare(@RequestParam("idklinike") long idklinike,@RequestParam("idpac") long idpac,HttpServletRequest request) {
	
		long idKlinike=idklinike;
		System.out.println("id pac  "+idpac+"  idKlinike   "+idklinike);
		ZaposleniUKlinikama uk =new ZaposleniUKlinikama();
		Klinika k=new Klinika();
		HttpSession session = request.getSession();
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
	
	
	
	//svi slobodni termini za lekare koji rade u toj klinici
	@RequestMapping("/terminiUKlinici")
	public String pokaziSveTermine(@RequestParam("idklinike") long idklinike,@RequestParam("id") long idpac,HttpServletRequest request) {
	
		long idKlinike=idklinike;
		System.out.println("id pac  "+idpac+"  idKlinike   "+idklinike);
		ZaposleniUKlinikama uk =new ZaposleniUKlinikama();
		Klinika k=new Klinika();
		HttpSession session = request.getSession();
		session.setAttribute("id", idpac);
	
		List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
		List<ZaposleniUKlinikama> zaposleni=new ArrayList<ZaposleniUKlinikama>();
		List<TerminiSaId> termini = new ArrayList<TerminiSaId>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(zaposlen);
			long idlekara=zaposlen.getIdlekara();
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(lip);
				}
				
					
			}
		}
		
		
		for(LekarZaPrikazIPreglede lip2 :  lipi) {
			for (TerminiSaId termin : tisServis.nadjiSlobodneTermineZaOveLekare()) {
				if(lip2.getId()==termin.getLekarId()) {
					termini.add(termin);
				}
				
			}
				
		}
		
		request.setAttribute("zaposleni", zaposleni);
		request.setAttribute("lipi", lipi);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI_2");
		return "listaKlinika";
	}
	
	
	
}
