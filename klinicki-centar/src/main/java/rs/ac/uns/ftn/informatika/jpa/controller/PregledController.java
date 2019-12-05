package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.repository.PregledRepository;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;

@Controller
public class PregledController {
	
	@Autowired
	private PregledService pregledSer;
	
	@Autowired
	private PregledRepository pregledRepo;
	
	@RequestMapping("/zakaziPregled1")
	public String zakaziPregled() {
		return "zakaziPregled";
	}

}
