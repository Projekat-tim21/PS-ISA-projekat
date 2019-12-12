package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

public class PregledJDTO {
	
	private String id;
	private String datum;
	private String vreme;
	private String sala;
	private String lekar;
	private String cena;
	private String trajanje;
	private String tip;
	private Boolean zakazan;
	
	public PregledJDTO(String id, String datum, String vreme, String sala, String lekar, String cena, String trajanje, String tip, Boolean zakazan) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.sala = sala;
		this.lekar = lekar;
		this.cena = cena;
		this.trajanje = trajanje;
		this.tip = tip;
		this.zakazan = zakazan;
	}
	
	public Boolean getZakazan() {
		return zakazan;
	}

	public void setZakazan(Boolean zakazan) {
		this.zakazan = zakazan;
	}

	public PregledJDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getLekar() {
		return lekar;
	}

	public void setLekar(String lekar) {
		this.lekar = lekar;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	

}
