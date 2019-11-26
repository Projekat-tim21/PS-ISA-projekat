package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.enums.Role;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@Controller
public class AuthorizationController {
	
	
	private final KorisnikService service;
	
	
	public AuthorizationController(KorisnikService service) {
		this.service = service;
	}
	
	boolean checkAuhtority(String username, List<Role> permittedRoles) {
		Korisnik user = service.findByUsername(username);
		//permittedRoles.contains(user.getRole());
		return true;
	}
}
