package rs.ac.uns.ftn.informatika.jpa.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name = "pregled")
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "datum", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String datum;
	
	@Column(name = "satnica", unique = true, nullable = false)
	private String satnica;
	
	@Column(name = "sala", nullable = false)
	private String sala;
	
	@Column(name = "lekar", nullable = false)
	private String lekar;
	
	@Column(name = "cena", nullable = false)
	private String cena;
	
	//@Column(name = "trajanjePregleda", nullable = false)
	//private String trajanjePregleda;
	
	@Column(name = "tip", nullable = false)
	private String tip;
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
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



	public Pregled() {
		
	}
}
