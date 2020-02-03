package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ocenaklinike")
public class OcenaKlinike {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ocenaklinike", nullable=true)
	private double ocenaklinike;
	
	@Column(name="korisnikid", nullable=true)
	private Long korisnikid;
	
	@Column(name="pregledid", nullable=true)
	private Long pregledid;
	
	@Column(name="lekarid", nullable=true)
	private Long lekarid;
	
	@Column(name="klinikaid", nullable=true)
	private Long klinikaid;

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

	public double getOcenaklinike() {
		return ocenaklinike;
	}

	public void setOcenaklinike(double ocenaklinike) {
		this.ocenaklinike = ocenaklinike;
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

	public Long getKlinikaid() {
		return klinikaid;
	}

	public void setKlinikaid(Long klinikaid) {
		this.klinikaid = klinikaid;
	}

	public OcenaKlinike() {
		super();
	}

	public OcenaKlinike(Long id, double ocenaklinike, Long korisnikid, Long pregledid, Long lekarid, Long klinikaid) {
		super();
		this.id = id;
		this.ocenaklinike = ocenaklinike;
		this.korisnikid = korisnikid;
		this.pregledid = pregledid;
		this.lekarid = lekarid;
		this.klinikaid = klinikaid;
	}
	
	
	
}
