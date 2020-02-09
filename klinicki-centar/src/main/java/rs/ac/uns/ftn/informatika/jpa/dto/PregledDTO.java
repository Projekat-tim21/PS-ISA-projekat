package rs.ac.uns.ftn.informatika.jpa.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PregledDTO {

	private Long id;
	private String terminpregled;
	private String idlekarpregled;
	private Long idpacijenta;
	private Boolean obradjen;	

	private String datum;   //ovo se ne koristi vise

	private String vreme;   //ovo se ne koristi vise
	
	private String tip;
	
	private String lekarimepregled;

	private String lekarprezimepregled;
	
	private String lekar;  //ovo se ne koristi vise

	private int cena;

	private double ocenapregleda;


	private String trajanje;
	
	private String sala;
	
	private Boolean zakazan;
	
	private boolean obavljenpregled;

	private Long korisnikId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTerminpregled() {
		return terminpregled;
	}
	public void setTerminpregled(String terminpregled) {
		this.terminpregled = terminpregled;
	}
	public String getIdlekarpregled() {
		return idlekarpregled;
	}
	public void setIdlekarpregled(String idlekarpregled) {
		this.idlekarpregled = idlekarpregled;
	}
	public Long getIdpacijenta() {
		return idpacijenta;
	}
	public void setIdpacijenta(Long idpacijenta) {
		this.idpacijenta = idpacijenta;
	}
	
	
	public PregledDTO(String terminpregled, String idlekarpregled, Long idpacijenta, Boolean obradjen) {
		super();
		this.terminpregled = terminpregled;
		this.idlekarpregled = idlekarpregled;
		this.idpacijenta = idpacijenta;
		this.obradjen = obradjen;
	}
	public Boolean getObradjen() {
		return obradjen;
	}
	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}
	public PregledDTO() {
		super();
	}
	public PregledDTO(String terminpregled, String idlekarpregled, Long idpacijenta) {
		super();
		this.terminpregled = terminpregled;
		this.idlekarpregled = idlekarpregled;
		this.idpacijenta = idpacijenta;
	}
	@Override
	public String toString() {
		return "PregledDTO [id=" + id + ", terminpregled=" + terminpregled + ", idlekarpregled=" + idlekarpregled
				+ ", idpacijenta=" + idpacijenta + "]";
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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getLekarimepregled() {
		return lekarimepregled;
	}
	public void setLekarimepregled(String lekarimepregled) {
		this.lekarimepregled = lekarimepregled;
	}
	public String getLekarprezimepregled() {
		return lekarprezimepregled;
	}
	public void setLekarprezimepregled(String lekarprezimepregled) {
		this.lekarprezimepregled = lekarprezimepregled;
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
	public double getOcenapregleda() {
		return ocenapregleda;
	}
	public void setOcenapregleda(double ocenapregleda) {
		this.ocenapregleda = ocenapregleda;
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
	public Boolean getZakazan() {
		return zakazan;
	}
	public void setZakazan(Boolean zakazan) {
		this.zakazan = zakazan;
	}
	public boolean isObavljenpregled() {
		return obavljenpregled;
	}
	public void setObavljenpregled(boolean obavljenpregled) {
		this.obavljenpregled = obavljenpregled;
	}
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	
}
