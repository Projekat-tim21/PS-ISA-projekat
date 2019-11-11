package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@RestController
public class KorisnikContreller {

	@Autowired
	private KorisnikService korisnikServis;
	
	
	@GetMapping("/sacuvaj")
	public String saveKorisnik(@RequestParam String jedBrOsig,@RequestParam String username, @RequestParam String ime, @RequestParam String prezime, @RequestParam String email, @RequestParam String adresa, @RequestParam String grad, @RequestParam String drzava, @RequestParam String telefon, @RequestParam String sifra  ) {
		Korisnik kor=new Korisnik(jedBrOsig, username, ime, prezime, email, adresa, grad, drzava, telefon, sifra);
		korisnikServis.saveMogKorisnika(kor);
		return "Korisnik sacuvan";
	}
	
	
}
