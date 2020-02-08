package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;

public class OperacijaDTO {
	
	private Long id;
	private String terminoperacija;
	private Long idlekaroperacija;
	private Long idpacijenta;
	private Boolean obradjen;

	String datum; //ovo se ne koristi vise
	
	String vreme; //ovo se ne koristi vise
	
	
	private String lekarimeoperacija;

	private String lekarprezimeoperacija;
	
	private String tip;
	
	private double ocenaoperacije;

	private boolean obavljenaoperacija;
	
	private Boolean zakazan;

	private String trajanje;
	
	private String sala;
	

	String lekar;  //ovo se ne koristi
	
	int cena;

	private Long korisnikId;
	
	private Set<Korisnik> lekari = new HashSet<Korisnik>();

	
	public String getTerminoperacija() {
		return terminoperacija;
	}
	public void setTerminoperacija(String terminoperacija) {
		this.terminoperacija = terminoperacija;
	}
	public Long getIdlekaroperacija() {
		return idlekaroperacija;
	}
	public void setIdlekaroperacija(Long idlekaroperacija) {
		this.idlekaroperacija = idlekaroperacija;
	}
	public Long getIdpacijenta() {
		return idpacijenta;
	}
	public void setIdpacijenta(Long idpacijenta) {
		this.idpacijenta = idpacijenta;
	}
	public Boolean getObradjen() {
		return obradjen;
	}
	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}
	public OperacijaDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OperacijaDTO(String terminoperacija, Long idlekaroperacija, Long idpacijenta, Boolean obradjen) {
		super();
		this.terminoperacija = terminoperacija;
		this.idlekaroperacija = idlekaroperacija;
		this.idpacijenta = idpacijenta;
		this.obradjen = obradjen;
	}
	@Override
	public String toString() {
		return "OperacijaDTO [id=" + id + ", terminoperacija=" + terminoperacija + ", idlekaroperacija="
				+ idlekaroperacija + ", idpacijenta=" + idpacijenta + ", obradjen=" + obradjen + "]";
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
	public String getLekarimeoperacija() {
		return lekarimeoperacija;
	}
	public void setLekarimeoperacija(String lekarimeoperacija) {
		this.lekarimeoperacija = lekarimeoperacija;
	}
	public String getLekarprezimeoperacija() {
		return lekarprezimeoperacija;
	}
	public void setLekarprezimeoperacija(String lekarprezimeoperacija) {
		this.lekarprezimeoperacija = lekarprezimeoperacija;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public double getOcenaoperacije() {
		return ocenaoperacije;
	}
	public void setOcenaoperacije(double ocenaoperacije) {
		this.ocenaoperacije = ocenaoperacije;
	}
	public boolean isObavljenaoperacija() {
		return obavljenaoperacija;
	}
	public void setObavljenaoperacija(boolean obavljenaoperacija) {
		this.obavljenaoperacija = obavljenaoperacija;
	}
	public Boolean getZakazan() {
		return zakazan;
	}
	public void setZakazan(Boolean zakazan) {
		this.zakazan = zakazan;
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
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	public Set<Korisnik> getLekari() {
		return lekari;
	}
	public void setLekari(Set<Korisnik> lekari) {
		this.lekari = lekari;
	}
	
	
	
	
}
