package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="dijagnoza")
public class Dijagnoza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="sifra",unique=true,nullable=false)
	String sifra;
	
	@Column(name="naziv",unique=true,nullable=false)
	String naziv;
	
	@Column(name="dodatno",unique=true,nullable=false)
	String dodatno;

	public Dijagnoza(String sifra, String naziv, String dodatno) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.dodatno = dodatno;
	}
	
	public Dijagnoza() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getDodatno() {
		return dodatno;
	}

	public void setDodatno(String dodatno) {
		this.dodatno = dodatno;
	}
	
	
	
}
