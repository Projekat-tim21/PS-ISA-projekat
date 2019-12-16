package rs.ac.uns.ftn.informatika.jpa.dto;

public class DijagnozaDTO {

	private Long id;
	private String sifra;
	private String naziv;
	private String dodatno;
	
	public DijagnozaDTO(Long id, String sifra, String naziv, String dodatno) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.dodatno = dodatno;
	}

	public DijagnozaDTO(){
		
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
