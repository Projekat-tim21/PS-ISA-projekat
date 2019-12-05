package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

public class PregledDTO {
	
	private String id;
	private String datum;
	private String satnica;
	private String sala;
	private String lekar;
	private String cena;
	//private String trajanjePregleda;
	private String tip;
	
	public PregledDTO(String id, String datum, String satnica, String sala, String lekar, String cena, String popust, String tip) {
		super();
		this.id = id;
		this.datum = datum;
		this.satnica = satnica;
		this.sala = sala;
		this.lekar = lekar;
		this.cena = cena;
	//	this.trajanjePregleda = trajanjePregleda;
		this.tip = tip;
	}
	
	public PregledDTO() {
		
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

	public String getSatnica() {
		return satnica;
	}

	public void setSatnica(String satnica) {
		this.satnica = satnica;
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

	/*public String getTrajanjePregleda() {
		return trajanjePregleda;
	}

	public void setTrajanjePregleda(String trajanjePregleda) {
		this.trajanjePregleda = trajanjePregleda;
	}*/

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	

}
