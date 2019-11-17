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

	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute Korisnik korisnik, HttpServletRequest request) {
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
		ModelAndView modelAndView;
		Korisnik existingUser = userRepository.findByUsername(korisnik.getUsername());
		if (existingUser != null) {

			 request.setAttribute("errorMessage", "Invalid username"); 
			System.out.println("caoooooooooooooo");
		
			//return "welcomepage";
			// modelAndView.addObject("message","This username already exists!");
			// modelAndView.setViewName("error");
			 //System.out.println("caoooooooooooooo");
		} else {
			korisnikServis.saveMogKorisnika(korisnik);
			request.setAttribute("mode", "MODE_HOME");}
			return "welcomepage";
		
	}

	@GetMapping("/pokazi-korisnika")
	public String pokaziSveKorisnike(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSveKorisnike());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView, Korisnik user) {

		Korisnik existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			modelAndView.addObject("message", "This username already exists!");
			modelAndView.setViewName("error");
		} else {/*
				 * userRepository.save(user);
				 * 
				 * ConfirmationToken confirmationToken = new ConfirmationToken(user);
				 * 
				 * confirmationTokenRepository.save(confirmationToken);
				 * 
				 * SimpleMailMessage mailMessage = new SimpleMailMessage();
				 * mailMessage.setTo(user.getEmailId());
				 * mailMessage.setSubject("Complete Registration!");
				 * mailMessage.setFrom("chand312902@gmail.com");
				 * mailMessage.setText("To confirm your account, please click here : "
				 * +"http://localhost:8082/confirm-account?token="+confirmationToken.
				 * getConfirmationToken());
				 * 
				 * emailSenderService.sendEmail(mailMessage);
				 * 
				 * modelAndView.addObject("emailId", user.getEmailId());
				 */

			modelAndView.setViewName("successfulRegisteration");
		}

		return modelAndView;
	}

}
