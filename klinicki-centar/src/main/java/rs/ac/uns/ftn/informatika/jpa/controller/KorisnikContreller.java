package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@Controller
public class KorisnikContreller {

	@Autowired
	private KorisnikService korisnikServis;
	
	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	//prikaz neautentifikovanim korisnicima
	
	@RequestMapping("/prikazOsnovnihInfo")
	public String info(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "pocetna_stranica";
	}
	
	//logovanje
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
		if(korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword())!=null) {
			return "login";
		}else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
		
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		//request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@RequestMapping("/registracija")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	/*
	@GetMapping("/sacuvajProba")
	public String saveKorisnik(@RequestParam String jedBrOsig,@RequestParam String username, @RequestParam String ime, @RequestParam String prezime, @RequestParam String email, @RequestParam String adresa, @RequestParam String grad, @RequestParam String drzava, @RequestParam String telefon, @RequestParam String sifra  ) {
		Korisnik kor=new Korisnik(jedBrOsig, username, ime, prezime, email, adresa, grad, drzava, telefon, sifra);
		korisnikServis.saveMogKorisnika(kor);
		return "Korisnik sacuvan";
	}*/
	
	@PostMapping("/sacuvaj") //korisnik povezan sa valuom iz js
	public String registerKorisnik(@ModelAttribute Korisnik korisnik, BindingResult bindingResult, HttpServletRequest request) {
		korisnikServis.saveMogKorisnika(korisnik);  
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	
	
	@GetMapping("/pokazi-korisnika")
	public String pokaziSveKorisnike(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSveKorisnike());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
}
