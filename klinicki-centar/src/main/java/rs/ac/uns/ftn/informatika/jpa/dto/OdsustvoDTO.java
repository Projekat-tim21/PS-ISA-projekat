package rs.ac.uns.ftn.informatika.jpa.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OdsustvoDTO {


	private Long id;

	private String pocetak;
	
	private String kraj;
	
	private boolean odobren;
	
	private long idkorisnika;

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

	public OdsustvoDTO() {
		super();
	}

	public OdsustvoDTO(Long id, String pocetak, String kraj, boolean odobren, long idkorisnika) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.odobren = odobren;
		this.idkorisnika = idkorisnika;
	}

	public OdsustvoDTO(String pocetak, String kraj, boolean odobren, long idkorisnika) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.odobren = odobren;
		this.idkorisnika = idkorisnika;
	}

	@Override
	public String toString() {
		return "OdsustvoDTO [id=" + id + ", pocetak=" + pocetak + ", kraj=" + kraj + ", odobren=" + odobren
				+ ", idkorisnika=" + idkorisnika + "]";
	}
	
	
}
