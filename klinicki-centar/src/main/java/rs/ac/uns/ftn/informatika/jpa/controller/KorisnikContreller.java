package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@Controller
public class KorisnikContreller {

	@Autowired
	private KorisnikService korisnikServis;

	@Autowired
	private KorisnikRepository userRepository;

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
	public String loginUser(@ModelAttribute KorisnikDTO korisnik, HttpServletRequest request) {
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
	public String registerKorisnik(@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
			HttpServletRequest request) {
		
		Korisnik existingUser = userRepository.findByUsername(korisnikd.getUsername());
		if (existingUser != null) {

			
			request.setAttribute("errorMessage", "Invalid username"); 
			return "ispravka";
			
		} else {
			Korisnik k=new Korisnik();
			k.setId(korisnikd.getId());
			k.setIme(korisnikd.getIme());
			k.setPrezime(korisnikd.getPrezime());
			k.setJedBrOsig(korisnikd.getJedBrOsig());
			k.setEmail(korisnikd.getEmail());
			k.setAdresa(korisnikd.getAdresa());
			k.setDrzava(korisnikd.getDrzava());
			k.setGrad(korisnikd.getGrad());
			k.setTelefon(korisnikd.getTelefon());
			k.setUsername(korisnikd.getUsername());
			k.setPassword(korisnikd.getPassword());
			
			korisnikServis.saveMogKorisnika(k);
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
