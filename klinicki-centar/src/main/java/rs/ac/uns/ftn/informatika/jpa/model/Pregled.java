package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
@Table(name="pregled")
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "datum", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String datum;
	
	@Column(name = "vreme", unique = true, nullable = false)
	private String vreme;
	
	@Column(name = "sala", nullable = false)
	private String sala;
	
	@Column(name = "lekar", nullable = false)
	private String lekar;
	
	@Column(name = "cena", nullable = false)
	private int cena;
	
	@Column(name = "tip", nullable = false)
	private String tip;

	@Column(name="trajanje", nullable=false)
	String trajanje;
	
	@Column(name = "zakazan", nullable = false)
	Boolean zakazan;
	
	public Boolean getZakazan() {
		return zakazan;
	}

	public void setZakazan(Boolean zakazan) {
		this.zakazan = zakazan;
	}
	
/*	public Korisnik getZakazao() {
		return zakazao;
	}
	
	public void setZakazao(Korisnik zakazao) {
		this.zakazao = zakazao;
	}
	*/
	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	

	public Pregled() {
		super();
	}

	public Pregled(Long id, String datum, String vreme, String tip, String trajanje, String sala, String lekar,
			int cena) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.tip = tip;
		this.trajanje = trajanje;
		this.sala = sala;
		this.lekar = lekar;
		this.cena = cena;
	}


	public void setId(Long id) {
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



	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
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

	public int getCena() {
		return cena;
	}



	public void setCena(int cena) {
		this.cena = cena;
	}


}
