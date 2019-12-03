package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lek")
public class Lek {
	
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

	public Lek() {
		
	}
	
	public Lek(String sifra, String name, String dodatno) {
		super();
		this.sifra = sifra;
		this.naziv = name;
		this.dodatno = dodatno;
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

	public void setNaziv(String name) {
		this.naziv = name;
	}

	public String getDodatno() {
		return dodatno;
	}

	public void setDodatno(String dodatno) {
		this.dodatno = dodatno;
	}

	@Override
	public String toString() {
		return "Lek [id=" + id + ", sifra=" + sifra + ", name=" + naziv + ", dodatno=" + dodatno + "]";
	}

	
}
