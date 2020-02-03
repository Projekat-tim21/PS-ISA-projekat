package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ocenalekara")
public class OcenaLekara {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ocenalek", nullable=true)
	private double ocenalek;
	
	@Column(name="korisnikid", nullable=true)
	private Long korisnikid;
	
	@Column(name="pregledid", nullable=true)
	private Long pregledid;
	
	@Column(name="lekarid", nullable=true)
	private Long lekarid;

	@Version
	private Long version;
	
	
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getOcenalek() {
		return ocenalek;
	}

	public void setOcenalek(double ocenalek) {
		this.ocenalek = ocenalek;
	}

	public Long getKorisnikid() {
		return korisnikid;
	}

	public void setKorisnikid(Long korisnikid) {
		this.korisnikid = korisnikid;
	}

	public Long getPregledid() {
		return pregledid;
	}

	public void setPregledid(Long pregledid) {
		this.pregledid = pregledid;
	}

	public Long getLekarid() {
		return lekarid;
	}

	public void setLekarid(Long lekarid) {
		this.lekarid = lekarid;
	}

	public OcenaLekara() {
		super();
	}
	
	
	
}
