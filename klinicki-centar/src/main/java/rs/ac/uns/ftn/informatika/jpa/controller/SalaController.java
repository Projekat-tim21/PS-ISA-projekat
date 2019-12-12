package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.Sala;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.repository.SalaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.SalaService;

@Controller
public class SalaController {
	
	@Autowired
	private SalaService salaS;
	
	@Autowired
	private SalaRepository salaRepo;
	
	@Autowired
	private LekarZaPrikazIPregledeService lServis;
	
	@RequestMapping("/pretragaSale")
	public String prikaziListuSala(HttpServletRequest request) {
		request.setAttribute("sale", salaS.pokaziSveSale());
		request.setAttribute("mode", "ALL_SALE");
		return "listaSala";
	}
	
	
	//KAKO DA MI PRIKAZE PO ISTOM IMENU ??????????
	//if(sala.getNaziv() == s.getNaziv()) 
	@RequestMapping("/prikazKalendaraSala")
	public String prikaziKalendar(HttpServletRequest request) {

		List<Sala> sale = new ArrayList<Sala>();
		for(Sala sala : salaRepo.findByRezervisana(false)) {
		
			sale.add(sala);
		}
		
		request.setAttribute("sale", sale);
		request.setAttribute("mode", "SVE_SLOBODNE_SALE");
		return "listaSala";
		
		
	}
	
	@RequestMapping("/rezervacija")
	public String rezervacijaSale( HttpServletRequest request) {
		
		
		return "rezervisaneSale";
	}
	

}
