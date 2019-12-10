package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lekarIPregledi")
public class LekarZaPrikazIPreglede {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lekar_id")
	private Long id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="tipspecijalizacije")
	private String tipspecijalizacije;
	
	@Column(name="uloga")
	private String uloga;
	
	@Column(name="ocena", nullable=true)
	private double ocena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTipspecijalizacije() {
		return tipspecijalizacije;
	}

	public void setTipspecijalizacije(String tipspecijalizacije) {
		this.tipspecijalizacije = tipspecijalizacije;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public LekarZaPrikazIPreglede(Long id, String ime, String prezime, String tipspecijalizacije, String uloga,
			double ocena) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.tipspecijalizacije = tipspecijalizacije;
		this.uloga = Role.LEKAR.name();
		this.ocena = ocena;
	}

	public LekarZaPrikazIPreglede() {
		super();
	}
	
	
}
