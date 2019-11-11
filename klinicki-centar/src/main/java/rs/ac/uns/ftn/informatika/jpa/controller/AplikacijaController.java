package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AplikacijaController {

	
	@RequestMapping("/pocetna")
	public String Welcome() {
		return "pocetna_stranica";
	}
	
	
	
}
