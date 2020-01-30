package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="odsustvo")
public class Odsustvo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="pocetak")
	private String pocetak;
	
	@Column(name="kraj")
	private String kraj;
	
	@Column(name="odobren")
	private boolean odobren;
	
	@Column(name="idkorisnika")
	private long idkorisnika;

	public Odsustvo(Long id, String pocetak, String kraj, boolean odobren, long idkorisnika) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.odobren = odobren;
		this.idkorisnika = idkorisnika;
	}

	public Odsustvo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}

	public long getIdkorisnika() {
		return idkorisnika;
	}

	public void setIdkorisnika(long idkorisnika) {
		this.idkorisnika = idkorisnika;
	}
	
	
	
	
}
