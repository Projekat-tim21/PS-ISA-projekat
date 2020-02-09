package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public class LekarZaPrikazIPregledeDTO {

	private Long id;
	private String imelek;
	private String prezimelek;
	private String tipspecijalizacije;
	private String uloga;
	//private Long lekarveza;
	private double ocena;
	
	public LekarZaPrikazIPregledeDTO(Long id, String imelek, String prezimelek, String tipspecijalizacije, String uloga,
		 double ocena) {
		super();
		this.id = id;
		this.imelek = imelek;
		this.prezimelek = prezimelek;
		this.tipspecijalizacije = tipspecijalizacije;
		this.uloga = uloga;
		//this.lekarveza = lekarveza;
		this.ocena = ocena;
	}
	
	


	public LekarZaPrikazIPregledeDTO(LekarZaPrikazIPreglede lipi) {
		this(lipi.getId(), 
				lipi.getImelek(),
				lipi.getPrezimelek(),
				lipi.getTipspecijalizacije(),
				lipi.getUloga(),
				//lipi.getLekarveza(),
				lipi.getOcena());
	}
	
	
	//public LekarZaPrikazIPregledeDTO(LekarZaPrikazIPreglede lipi) {}
	
	public LekarZaPrikazIPregledeDTO() {
		super();
	}

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
	/*
	public Long getLekarveza() {
		return lekarveza;
	}
	public void setLekarveza(Long lekarveza) {
		this.lekarveza = lekarveza;
	}*/
	public double getOcena() {
		return ocena;
	}
	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
	
}
