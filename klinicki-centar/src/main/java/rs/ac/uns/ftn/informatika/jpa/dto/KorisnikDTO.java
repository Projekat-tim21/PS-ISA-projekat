package rs.ac.uns.ftn.informatika.jpa.dto;

import lombok.Data;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Student;


public class KorisnikDTO {

	private Long id;
	private String username;
	private String ime;
	private String prezime;
	private String jedBrOsig;
	private String email;
	private String adresa;
	private String grad;
	private String drzava;
	private String telefon;
	private String password;

	public KorisnikDTO(Long id, String username, String ime, String prezime, String jedBrOsig, String email,
			String adresa, String grad, String drzava, String telefon, String password) {
		super();
		this.id = id;
		this.username = username;
		this.ime = ime;
		this.prezime = prezime;
		this.jedBrOsig = jedBrOsig;
		this.email = email;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.password = password;
	}


	public KorisnikDTO(Korisnik korisnik) {
		this(korisnik.getId(), korisnik.getUsername(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getJedBrOsig(),korisnik.getEmail(), korisnik.getAdresa(), korisnik.getGrad(), korisnik.getDrzava(), korisnik.getTelefon(), korisnik.getPassword());
	}

	
	public KorisnikDTO() {
		super();
	}

	
	
	public String getJedBrOsig() {
		return jedBrOsig;
	}


	public void setJedBrOsig(String jedBrOsig) {
		this.jedBrOsig = jedBrOsig;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	
	
}
