package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.repository.SalaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.SalaService;

@Controller
public class SalaController {
	
	@Autowired
	private SalaService salaS;
	
	@Autowired
	private SalaRepository salaRepo;
	
	@RequestMapping("/pretragaSale")
	public String prikaziListuSala(HttpServletRequest request) {
		request.setAttribute("sale", salaS.pokaziSveSale());
		request.setAttribute("mode", "ALL_SALE");
		return "listaSala";
	}
	
	@RequestMapping("/prikazKalendaraSala")
	public String prikaziKalendar(HttpServletRequest request) {
		
		return "listaSala";
	}
	

}
