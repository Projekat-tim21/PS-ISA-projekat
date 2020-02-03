package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "sala")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="naziv", nullable=false)
	String naziv;

	@Column(name = "br", nullable = false)
	int br;
	
	@Column(name="datum", nullable=false)
	String datum;
	
	@Column(name="rezervisana", nullable=true)
	private boolean rezervisana;

	public boolean isRezervisana() {
		return rezervisana;
	}

	@Version
	private Long version;

	
	
	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}


	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}


	public Sala() {
		
	}
	
	
	public Sala(Long id, String naziv, int br, String datum, boolean rezervisana) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.br = br;
		this.datum = datum;
		this.rezervisana = rezervisana;
	}

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
	
}
