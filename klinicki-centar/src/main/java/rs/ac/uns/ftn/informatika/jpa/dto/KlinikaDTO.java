package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;

public class KlinikaDTO {
	
	private Long id;
	private String naziv;
	private String grad;
	private String drzava;
	private int ocena;
	private String adresa;
	private String tip;
	private KorisnikDTO admin;
	

	public KlinikaDTO(Klinika klinika) {
		// TODO Auto-generated constructor stub
		id=klinika.getId();
		naziv=klinika.getNaziv();
		grad=klinika.getGrad();
		drzava=klinika.getDrzava();
		ocena=klinika.getOcena();
		tip=klinika.getTip();
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


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public int getOcena() {
		return ocena;
	}


	public void setOcena(int ocena) {
		this.ocena = ocena;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	public KorisnikDTO getAdmin() {
		return admin;
	}


	public void setAdmin(KorisnikDTO admin) {
		this.admin = admin;
	}


	public KlinikaDTO(String naziv, String grad, String drzava, String adresa) {
		super();
		this.naziv = naziv;
		this.grad = grad;
		this.drzava = drzava;
		this.adresa = adresa;
	}
	
	
	public KlinikaDTO() {
		
	}
	

}
