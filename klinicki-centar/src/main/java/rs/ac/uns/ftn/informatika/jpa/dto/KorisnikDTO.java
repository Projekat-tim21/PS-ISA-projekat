package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Role;

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
	private String repeatPassword;
	private String role;
	private Boolean firstLogin;
	private Boolean isActive;
	private String datum;
	private String pol;
	private String visina;
	private String tezina;
	private String kgrupa;
	private String dioptrija;
	private String alergije;
	private String bolesti;
	private String anamneza;
	private static KlinikaDTO klinika;

	public KorisnikDTO(Long id, String username, String ime, String prezime, String jedBrOsig, String email,
			String adresa, String grad, String drzava, String telefon, String password, String repeatPassword,
			String role, String datum, String pol, String visina, String tezina, String kgrupa, String dioptrija,
			String alergije, String bolesti, String anamneza) {
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
		this.repeatPassword = repeatPassword;
		this.role = role;
		this.datum = datum;
		this.pol = pol;
		this.visina = visina;
		this.tezina = tezina;
		this.kgrupa = kgrupa;
		this.dioptrija = dioptrija;
		this.alergije = alergije;
		this.bolesti = bolesti;
		this.anamneza = anamneza;
	}

	
	
	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public String getKgrupa() {
		return kgrupa;
	}

	public void setKgrupa(String kgrupa) {
		this.kgrupa = kgrupa;
	}

	public String getDioptrija() {
		return dioptrija;
	}

	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}

	public String getAlergije() {
		return alergije;
	}

	public void setAlergije(String alergije) {
		this.alergije = alergije;
	}

	public String getBolesti() {
		return bolesti;
	}

	public void setBolesti(String bolesti) {
		this.bolesti = bolesti;
	}

	public String getAnamneza() {
		return anamneza;
	}

	public void setAnamneza(String anamneza) {
		this.anamneza = anamneza;
	}

	public KorisnikDTO(Long id, String username, String ime, String prezime, String jedBrOsig, String email,
			String adresa, String grad, String drzava, String telefon, String password, String role,Boolean firstLogin) {
		

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

		this.role=role;
		this.firstLogin=firstLogin;
		this.role = Role.PACIJENT.name();
		this.isActive=true;
		this.firstLogin=false;
	}

	public String getRole() {
		return role;

	}

	public void setRole(String role) {
		this.role = role;
	}

	public KorisnikDTO(Korisnik korisnik) {

		this(korisnik.getId(), korisnik.getUsername(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getJedBrOsig(),korisnik.getEmail(), korisnik.getAdresa(), korisnik.getGrad(), korisnik.getDrzava(), korisnik.getTelefon(), korisnik.getPassword(),korisnik.getRoleName(),korisnik.getFirst_Login(),klinika=new KlinikaDTO(korisnik.getKlinika()));
	}

	
	
	public Boolean getFirstLogin() {
		return firstLogin;
	}


	public void setFirstLogin(Boolean firstLogin) {
		this.firstLogin = firstLogin;
	}



	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public KorisnikDTO(Long id, String username, String ime, String prezime, String jedBrOsig, String email,
			String adresa, String grad, String drzava, String telefon, String password, String repeatPassword,
			String role, Boolean firstLogin, Boolean isActive) {
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
		this.role = role;
		this.firstLogin = firstLogin;
		this.isActive = isActive;
	}



	public KorisnikDTO(Long id2, String username2, String ime2, String prezime2, String jedBrOsig2, String email2,
			String adresa2, String grad2, String drzava2, String telefon2, String password2, String roleName,
			Boolean first_Login, KlinikaDTO klinika2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.username = username2;
		this.ime = ime2;
		this.prezime = prezime2;
		this.jedBrOsig = jedBrOsig2;
		this.email = email2;
		this.adresa = adresa2;
		this.grad = grad2;
		this.drzava = drzava2;
		this.telefon = telefon2;
		this.password = password2;
		this.role = roleName;
		this.firstLogin = firstLogin;
		this.klinika=klinika2;
	}



	public static KlinikaDTO getKlinika() {
		return klinika;
	}



	public static void setKlinika(KlinikaDTO klinika) {
		KorisnikDTO.klinika = klinika;
	}
		
	
}
