package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public class OperacijaDTO {
	
	private Long id;
	private String datum;
	private String vreme;
	private String terminoperacija;
	private String lekarimeoperacija;
	private String lekarprezimeoperacija;
	private Long idlekaroperacija;
	private Long idpacijenta;
	private String tip;
	private double ocenaoperacije;
	private boolean obavljenaoperacija;
	private Boolean zakazan;
	private Boolean obradjen;
	private String trajanje;
	private String sala;
	private String lekar;
	private int cena;
	private Long korisnikId;
	
	//novo
	public OperacijaDTO(Operacija op) {
		this(op.getId(),
				op.getDatum(),
				op.getVreme(),
				op.getTerminoperacija(),
				op.getLekarimeoperacija(),
				op.getLekarprezimeoperacija(),
				op.getIdlekaroperacija(),
				op.getIdpacijenta(),
				op.getTip(),
				op.getOcenaoperacije(),
				op.isObavljenaoperacija(),
				op.getZakazan(),
				op.getObradjen(),
				op.getTrajanje(),
				op.getSala(),
				op.getLekar(),
				op.getCena(),
				op.getKorisnikId());
	}
	
	
	
	



	public String getTerminoperacija() {
		return terminoperacija;
	}
	public OperacijaDTO(Long id, String datum, String vreme, String terminoperacija, String lekarimeoperacija,
			String lekarprezimeoperacija, Long idlekaroperacija, Long idpacijenta, String tip, double ocenaoperacije,
			boolean obavljenaoperacija, Boolean zakazan, Boolean obradjen, String trajanje, String sala, String lekar,
			int cena, Long korisnikId) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.terminoperacija = terminoperacija;
		this.lekarimeoperacija = lekarimeoperacija;
		this.lekarprezimeoperacija = lekarprezimeoperacija;
		this.idlekaroperacija = idlekaroperacija;
		this.idpacijenta = idpacijenta;
		this.tip = tip;
		this.ocenaoperacije = ocenaoperacije;
		this.obavljenaoperacija = obavljenaoperacija;
		this.zakazan = zakazan;
		this.obradjen = obradjen;
		this.trajanje = trajanje;
		this.sala = sala;
		this.lekar = lekar;
		this.cena = cena;
		this.korisnikId = korisnikId;
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
	
	
	
	
}
