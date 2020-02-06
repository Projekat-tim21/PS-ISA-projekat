package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity  //ovo je klasa za lekara 
@Table(name="lekarIPregledi")
public class LekarZaPrikazIPreglede {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lekar_id")
	private Long id;
	
	@Column(name="imelek")
	private String imelek;
	
	@Column(name="prezimelek")
	private String prezimelek;
	
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

	

	public String getImelek() {
		return imelek;
	}

	public void setImelek(String imelek) {
		this.imelek = imelek;
	}

	public String getPrezimelek() {
		return prezimelek;
	}

	public void setPrezimelek(String prezimelek) {
		this.prezimelek = prezimelek;
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



	public LekarZaPrikazIPreglede(Long id, String imelek, String prezimelek, String tipspecijalizacije, String uloga,
			double ocena) {
		super();
		this.id = id;
		this.imelek = imelek;
		this.prezimelek = prezimelek;
		this.tipspecijalizacije = tipspecijalizacije;
		this.uloga = uloga;
		this.ocena = ocena;
	}

	public LekarZaPrikazIPreglede() {
		super();
	}
	
	
}
