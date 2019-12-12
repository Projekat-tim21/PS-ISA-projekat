package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="korisnik3")
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "jedBrOsig", unique = true, nullable = false)
	String jedBrOsig;

	@Column(name = "username", unique = true, nullable = false)
	String username;
	
	@Column(name = "ime", nullable = false)
	private String ime;

	@Column(name = "prezime", nullable = false)
	private String prezime;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "adresa", nullable = false)
	private String adresa;
	
	@Column(name = "grad", nullable = false)
	private String grad;
	
	@Column(name = "drzava", nullable = false)
	private String drzava;
	
	@Column(name = "telefon", nullable = false)
	private String telefon;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name="active",nullable=true)
	private Boolean isActive;
	
	@Column(name="role",nullable=true)
	private String roleName;
	
	@Column(name="login", nullable=true)
	private Boolean first_Login;
	
	
    
	@Column(name = "datum", nullable = true)
	private String datum;
	
	@Column(name = "pol", nullable = true)
	private String pol;
	
	@Column(name = "visina", nullable = true)
	private String visina;
	
	@Column(name = "tezina", nullable = true)
	private String tezina;
	
	@Column(name = "kgrupa", nullable = true)
	private String kgrupa;
	
	@Column(name = "dioptrija", nullable = true)
	private String dioptrija;
	
	@Column(name = "alergije", nullable = true)
	private String alergije;
	
	@Column(name = "bolesti", nullable = true)
	private String bolesti;
	
	@Column(name = "anamneza", nullable = true)
	private String anamneza;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Klinika klinika;
	
	//za zdravstveni karton
	public Korisnik(Long id, String jedBrOsig, String ime, String prezime, String datum, String pol, String visina,
			String tezina, String kgrupa, String dioptrija, String alergije, String bolesti, String anamneza) {
		super();
		this.id = id;
		this.jedBrOsig = jedBrOsig;
		this.ime = ime;
		this.prezime = prezime;
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

	public Korisnik() {
	}

	
	
	public Korisnik(Long id, String jedBrOsig, String username, String ime, String prezime, String email, String adresa,
			String grad, String drzava, String telefon, String password, Boolean isActive, String roleName,
			String datum, String pol, String visina, String tezina, String kgrupa, String dioptrija, String alergije,
			String bolesti, String anamneza) {
		super();
		this.id = id;
		this.jedBrOsig = jedBrOsig;
		this.username = username;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.password = password;
		this.isActive = isActive;
		this.roleName = roleName;
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

	public Korisnik(String jedBrOsig, String korIme, String ime, String prezime, String email, String adresa,
			String grad, String drzava, String telefon, String sifra, String roleName) {
		super();
		this.jedBrOsig = jedBrOsig;
		this.username = korIme;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.password = sifra;
		this.roleName=Role.PACIJENT.name();
		
	}
	
	

	public Korisnik(Long id, String jedBrOsig, String username, String ime, String prezime, String email, String adresa,
			String grad, String drzava, String telefon, String password, Boolean isActive, String roleName,
			Boolean first_Login) {
		super();
		this.id = id;
		this.jedBrOsig = jedBrOsig;
		this.username = username;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.password = password;
		this.isActive = isActive;
		this.roleName = roleName;
		this.first_Login = first_Login;
	}


	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getJedBrOsig() {
		return jedBrOsig;
	}

	public void setJedBrOsig(String jedBrOsig) {
		this.jedBrOsig = jedBrOsig;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String korIme) {
		this.username = korIme;
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

	public void setPassword(String sifra) {
		this.password = sifra;
	}
	

	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getFirst_Login() {
		return first_Login;
	}

	public void setFirst_Login(Boolean first_Login) {
		this.first_Login = first_Login;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	
	
	

	
	
}
