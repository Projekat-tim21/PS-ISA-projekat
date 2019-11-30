package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;

@Controller
public class KlinikaController {

	@Autowired
	private  KlinikaService klinikaServis;

	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@RequestMapping("/listaSvihKlinika")
	public String idiNaPrikazListeKlinika(HttpServletRequest request) {
		request.setAttribute("klinike", klinikaServis.pokaziSveKlinike());
		request.setAttribute("mode", "ALL_KLINIKE");
		return "listaKlinika";
	}
	
	
}
