package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.dto.LekarZaPrikazIPregledeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.TerminDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ZaposleniUKlinikamaDTO;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.ZaposleniUKlinikamaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@Controller
public class KlinikaController {

	@Autowired
	private  KlinikaService klinikaServis;
	
	@Autowired
	private TerminSaIdService tisServis;
	
	@Autowired 
	private ZaposleniUKlinikamaRepository zRepo;
	
	
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
	
	@RequestMapping("/korakUnazadNaListuKlinika")
	public String korakUnazadNaListuKlinika(HttpServletRequest request) {
		request.setAttribute("klinike", klinikaServis.pokaziSveKlinike());
		request.setAttribute("mode", "ALL_KLINIKE");
		return "listaKlinika";
	}
	
	@RequestMapping("/korakUnazadNaLisuLekara")
	public String korakUnazadNaLisuLekara(@RequestParam("idklinike") long idklinike,@RequestParam("id") long idpac,HttpServletRequest request) {
	
		long idKlinike=idklinike;
		
		HttpSession session = request.getSession();
		session.setAttribute("idpac", idpac);
		session.setAttribute("idklinike", idklinike);
		List<LekarZaPrikazIPregledeDTO> lipi=new ArrayList<LekarZaPrikazIPregledeDTO>();
		List<ZaposleniUKlinikamaDTO> zaposleni=new ArrayList<ZaposleniUKlinikamaDTO>();
		List<TerminDTO> termini = new ArrayList<TerminDTO>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(new ZaposleniUKlinikamaDTO(zaposlen));
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(new LekarZaPrikazIPregledeDTO(lip));
				}
				
					
			}
		}
		
		
		for(LekarZaPrikazIPregledeDTO lip2 :  lipi) {
			for (TerminiSaId termin : tisServis.nadjiSlobodneTermineZaOveLekare()) {
				if(lip2.getId()==termin.getLekarId()) {
					termini.add(new TerminDTO(termin));
				}
				
			}
				
		}
		
		request.setAttribute("zaposleni", zaposleni);
		request.setAttribute("lipi", lipi);
		request.setAttribute("termini", termini);
		request.setAttribute("mode", "ALL_TERMINI_2");
		return "listaKlinika";
	}
	
	
	@RequestMapping("/lekariUKlinici")
	public String pokaziSveLekare(@RequestParam("idklinike") long idklinike,@RequestParam("idpac") long idpac,HttpServletRequest request) {
	
		long idKlinike=idklinike;
		HttpSession session = request.getSession();
		session.setAttribute("id", idpac);
	
		List<LekarZaPrikazIPregledeDTO> lipi=new ArrayList<LekarZaPrikazIPregledeDTO>();
		List<ZaposleniUKlinikamaDTO> zaposleni=new ArrayList<ZaposleniUKlinikamaDTO>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(new ZaposleniUKlinikamaDTO(zaposlen));
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(new LekarZaPrikazIPregledeDTO(lip));
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
		HttpSession session = request.getSession();
		session.setAttribute("idpac", idpac);
		session.setAttribute("idklinike", idklinike);
		List<LekarZaPrikazIPregledeDTO> lipi=new ArrayList<LekarZaPrikazIPregledeDTO>();
		List<ZaposleniUKlinikamaDTO> zaposleni=new ArrayList<ZaposleniUKlinikamaDTO>();
		List<TerminDTO> termini = new ArrayList<TerminDTO>();
		for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
			zaposleni.add(new ZaposleniUKlinikamaDTO(zaposlen));
			for(LekarZaPrikazIPreglede lip :  lipServis.pokaziSveKorisnikeKojiSuLekari()) {
				if(zaposlen.getIdlekara()==lip.getId()) {
					lipi.add(new LekarZaPrikazIPregledeDTO( lip));
				}
				
					
			}
		}
		
		
		for(LekarZaPrikazIPregledeDTO lip2 :  lipi) {
			for (TerminiSaId termin : tisServis.nadjiSlobodneTermineZaOveLekare()) {
				if(lip2.getId()==termin.getLekarId()) {
					termini.add(new TerminDTO(termin));
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
