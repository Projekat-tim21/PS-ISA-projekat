package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.enums.Role;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@Controller
public class KorisnikContreller extends AuthorizationController {

	
	private final KorisnikService korisnikServis;

	public KorisnikContreller(KorisnikService service) {
		super(service);
		this.korisnikServis = service;
	}


	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	// prikaz neautentifikovanim korisnicima

	@RequestMapping("/prikazOsnovnihInfo")
	public String info(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "pocetna_stranica";
	}

	// logovanje

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
		boolean isAuthorised =  checkAuhtority("pera", new ArrayList<Role>() {{ add(Role.CLINIC_ADMIN);}});
		if (korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword()) != null) {
			return "login";
		} else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}

	}


	
	

	@RequestMapping("/registracija")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/sacuvaj") // korisnik povezan sa valuom iz js
	public String registerKorisnik(@ModelAttribute Korisnik korisnik, BindingResult bindingResult,
			HttpServletRequest request) {
		
		Korisnik existingUser = korisnikServis.findByUsername(korisnik.getUsername());
		if (existingUser != null) {

			
			request.setAttribute("errorMessage", "Invalid username"); 
			return "ispravka";
			
		} else {
			korisnikServis.saveMogKorisnika(korisnik);
			request.setAttribute("mode", "MODE_HOME");
			return "welcomepage";
		}
		
	}


	@GetMapping("/pokazi-korisnika")
	public String pokaziSveKorisnike(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSveKorisnike());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	

}
