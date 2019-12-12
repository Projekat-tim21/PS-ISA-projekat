package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;

@Controller
public class PreglediController {

	@Autowired
	private  PregledService pServis;
	
	@Autowired
	private PregledRepository pregledRep;
	

	@RequestMapping("/zakaziPregled1")
	public String zakaziPregled() {
		return "zakaziPregled";
	}
	
	@RequestMapping("/preglediIoperacijePrikaz")
	public String prikazStraniceListaPregledaIOperacija(HttpServletRequest request) {
		return "listaPregledaIOperacija";
	}
	
	
	@RequestMapping("/prikaziListuPregleda")
	public String idiNaPrikazListePregelda(HttpServletRequest request) {
		request.setAttribute("pregledi", pServis.pokaziSvePreglede());
		request.setAttribute("mode", "ALL_PREGLEDI");
		return "listaPregledaIOperacija";
	}
	
	@RequestMapping("/naLogin")
	public String koranUnazad(HttpServletRequest request) {
		return "loginBezDobrodosli";
	}
	
	/*@RequestMapping("/zakaziPregledKojiJeDef")
	public String linkkaZakaziPregledKojiJeUnapreDef(HttpServletRequest request) {
		return "zaUnapredDefPreg";
	}

	@RequestMapping("/zakazivanjePregleda")
	public String zakaziPregled(HttpServletRequest request, Boolean zakazan) {
		//request.setAttribute("datumi", pServis.ListaDatuma());
	//	request.setAttribute("mode", "ALL_DATUMI");
		return "zakaziPregledNovi";
	}
	
	@RequestMapping("/zakazivanjePregledaOdobreno")
	public String odobrenoZakazivanje(HttpServletRequest request) {
		System.out.println("sdfssf");
	
		return "zakazanPregled";
	}
	

	*/

}
