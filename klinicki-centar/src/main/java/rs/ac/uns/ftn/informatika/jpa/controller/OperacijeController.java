package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.service.OperacijeService;

@Controller
public class OperacijeController {

	@Autowired
	private OperacijeService oServis;


	@RequestMapping("/prikaziListuOperacija")
	public String idiNaPrikazListeOperacija(HttpServletRequest request) {
		request.setAttribute("operacije", oServis.pokaziSveOperacije());
		request.setAttribute("mode", "ALL_OPERACIJE");
		return "listaPregledaIOperacija";
	}

	
	
}
