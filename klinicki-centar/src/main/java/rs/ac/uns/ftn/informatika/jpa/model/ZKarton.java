package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zdravstveni_karton")
public class ZKarton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ime", nullable = false)
	private String ime;

	@Column(name = "prezime", nullable = false)
	private String prezime;
	
	@Column(name = "jedBrOsig", unique = true, nullable = false)
	private String jedBrOsig;
	
	@Column(name = "datum", nullable = false)
	private String datum;
	
	@Column(name = "pol", nullable = false)
	private String pol;
	
	@Column(name = "visina", nullable = false)
	private String visina;
	
	@Column(name = "tezina", nullable = false)
	private String tezina;
	
	@Column(name = "kgrupa", nullable = false)
	private String kgrupa;
	
	@Column(name = "dioptrija", nullable = true)
	private String dioptrija;
	
	@Column(name = "alergije", nullable = true)
	private String alergije;
	
	@Column(name = "bolesti", nullable = true)
	private String bolesti;
	
	@Column(name = "anamneza", nullable = true)
	private String anamneza;

	
	public ZKarton() {
		super();
	}

	
	
	public ZKarton(Long id, String ime, String prezime, String jedBrOsig, String datum, String pol, String visina,
			String tezina, String kgrupa, String dioptrija, String alergije, String bolesti, String anamneza) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jedBrOsig = jedBrOsig;
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



	public ZKarton(String ime, String prezime, String jedBrOsig, String datum, String pol, String visina,
			String tezina, String kgrupa, String dioptrija, String alergije, String bolesti, String anamneza) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jedBrOsig = jedBrOsig;
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

	public String getJedBrOsig() {
		return jedBrOsig;
	}

	public void setJedBrOsig(String jedBrOsig) {
		this.jedBrOsig = jedBrOsig;
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
	
	
	
	
	
}
