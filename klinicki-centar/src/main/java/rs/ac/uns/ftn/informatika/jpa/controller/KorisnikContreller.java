package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;


@Controller
public class KorisnikContreller {
	
	private Logger logger = LoggerFactory.getLogger(KorisnikContreller.class);
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private  KorisnikService korisnikServis;

	@Autowired
	private KorisnikRepository userRepository;

	

	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		
		
		return "welcomepage";
	}


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

		Korisnik k=korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword());
		//if(!k.getRoleName().equals(Role.PACIJENT.name())) {

		Korisnik k2=new Korisnik();
		k=korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword());

		if (korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword()) != null) {
		
			//Korisnik =korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword());
			request.setAttribute("message", "Dobrodosli, uspesno ste se ulogovali!");
			//Korisnik idK=korisnikServis.findOne(korisnik.getId());
			//System.out.println("id korisnika je: "+ k.getId()); 
			String username = request.getParameter("username");
			//String id=request.getParameter("id");
			//System.out.println("print1: "+request.getSession().getId()); //uzima id sesije
			//String password = request.getParameter("password");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//korisnikServis.findByUsername(username);
			//Korisnik k=korisnikServis.findByUsername(username);
			
			System.out.println("OVDE " + k.getRoleName() +"  "+ k.getId());
			
			System.out.println("Koja je uloga u klasi"+Role.ADMIN.name());
			System.out.println("Korisnikova uloga"+k.getRoleName());
			
			if(k.getRoleName().equals(Role.ADMIN.name())) {
				
				return "admin";
			}else if(k.getRoleName().equals(Role.LEKAR.name())) {
				return "lekarStranica";
			}else{
				return "login";
			}
			
			
			//return "";
		}
			

			return "login";
		//}
		}
		//return "ispravka";

	

	@RequestMapping("/registracija")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@RequestMapping("/lekarStranica")
	public String lekarStranica(HttpServletRequest request) {
		//request.setAttribute("mode", "MODE_ALLUSER");
		return "lekarStranica";
	}

	@PostMapping("/sacuvaj") // korisnik povezan sa valuom iz js
	public String registerKorisnik(@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
			HttpServletRequest request) {


		Korisnik existingUser = userRepository.findByUsername(korisnikd.getUsername());

		if (existingUser != null) {

			request.setAttribute("errorMessage", "Invalid username");
			return "ispravka";

		} else {
			Korisnik k = new Korisnik();
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
			k.setRoleName(Role.PACIJENT.name());
			System.out.println(k.getRoleName());
			korisnikServis.saveMogKorisnika(k);
			
			try {
				emailService.sendNotificaitionZaRegistraciju(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
			
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

	@GetMapping("/pokazi-korisnika2")
	public String pokaziSveKorisnike2(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSveKorisnike());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@GetMapping("/pokazikorisnikaSaLogina")
	public String pokaziSveKorisnikeNaLoginu(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSveKorisnike());
		request.setAttribute("mode", "ALL_USERS");
		return "pregledUseraSaLogina";
	}
	//JECA
	
	
	@GetMapping("/pregledSvihPacijenataMetoda")
	public String pokaziPacijente(HttpServletRequest request) {
		request.setAttribute("korisnici", korisnikServis.pokaziSvePacijente());
		request.setAttribute("mode", "ALL_USERS");
		
		return "pregledSvihPacijenata";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Map<String, Object> map) {
		Korisnik k = korisnikServis.findOne(id);
		map.put("korisnik", k);
		return "edit";
	}

	@PostMapping("/sacuvajupdate") // korisnik povezan sa valuom iz js
	public String UpdateKorisnik(@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
			HttpServletRequest request) {

		Korisnik k = new Korisnik();
		Long Idx = korisnikd.getId();

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
		k.setRoleName(Role.PACIJENT.name());

		korisnikServis.deleteMyUser(korisnikd.getId());
		k.setId(Idx);
		korisnikServis.saveMogKorisnika(k);

		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";

	}

	@PostMapping("/sacuvajupdateNaLogin") // korisnik povezan sa valuom iz js
	public String UpdateKorisnik2(@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
			HttpServletRequest request) {

		Korisnik k = new Korisnik();
		Long Idx = korisnikd.getId();
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
		k.setRoleName(Role.PACIJENT.name());
		k.setId(Idx);
		korisnikServis.saveMogKorisnika(k);
		// k.setId(Idx);
		
		try {
			emailService.sendNotificaitionSync(k);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "uspesnaIzmenaInfo";

	}

	@RequestMapping("/edit-user")
	public String editUser(@RequestParam Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}

	@RequestMapping("/idiNaLoginBezDobrodosli")
	public String idiNaLoginBezDobrodosliFunc(@RequestParam Long id, HttpServletRequest request) {

		return "loginBezDobrodosli";
	}

	@RequestMapping("/profilkaPregledu")
	public String editUserProfilPregled(@RequestParam Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		request.setAttribute("mode", "MODE_PREGLED");
		return "pregledInfo";
	}
	
	@RequestMapping("/profilkaPregleduDrugi")
	public String editUserProfilPregledDrugi(@RequestParam String username, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findByUsername(username));
		request.setAttribute("mode", "MODE_PREGLED");
		return "pregledInfo";
	}
	

	@RequestMapping("/izmenaPodatakaizBara")
	public String editUserProfilIzBara(@RequestParam Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		request.setAttribute("mode", "MODE_PREGLED");
		
		
		
		return "login";
	}

	@RequestMapping("/profil")
	public String editUserProfil(@RequestParam String username, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findByUsername(username));
		request.setAttribute("mode", "MODE_PREGLED");
		return "login";
	}

	@RequestMapping("/vratiSeNaPocetnu")
	public String VratiSeNaPocetnu(@RequestParam Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		return "loginBezDobrodosli";
	}

	@RequestMapping("/profilnaBezDob")
	public String editUserProfilBezDob(@RequestParam String username, HttpServletRequest request) {
		return "pregledInfo";
	}

	@RequestMapping("/izmenaPodataka")
	public String editUserProfil2(@RequestParam Long id, HttpServletRequest request) {
		request.setAttribute("korisnik", korisnikServis.findOne(id));
		request.setAttribute("mode", "MODE_PREGLED");
		
	
		return "login";
	}

	@RequestMapping("/profil2")
	public String editUserProfil2(@RequestParam Long id, HttpServletRequest request,
			@ModelAttribute KorisnikDTO korisnikd) {

		request.setAttribute("korisnik", korisnikServis.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");

		korisnikd.getId();
		korisnikd.getIme();
		korisnikd.getPrezime();
		korisnikd.getJedBrOsig();
		korisnikd.getEmail();
		korisnikd.getAdresa();
		korisnikd.getDrzava();
		korisnikd.getGrad();
		korisnikd.getTelefon();
		korisnikd.getUsername();
		korisnikd.getPassword();
		korisnikd.getRole();

		System.out.println(korisnikd.getId() + korisnikd.getIme());
;
		return "login";
	}

}
