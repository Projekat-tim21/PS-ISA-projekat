package rs.ac.uns.ftn.informatika.jpa.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SalaDTO {

	
	private Long id;
	private String naziv;
	private int br;
	private String datum;	
	private boolean rezervisana;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getBr() {
		return br;
	}
	public void setBr(int br) {
		this.br = br;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public boolean isRezervisana() {
		return rezervisana;
	}
	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
	public SalaDTO() {
		super();
	}
	public SalaDTO(String naziv, int br, String datum, boolean rezervisana) {
		super();
		this.naziv = naziv;
		this.br = br;
		this.datum = datum;
		this.rezervisana = rezervisana;
	}
	public SalaDTO(Long id, String naziv, int br, String datum, boolean rezervisana) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.br = br;
		this.datum = datum;
		this.rezervisana = rezervisana;
	}
	
	

	
}
