package rs.ac.uns.ftn.informatika.jpa.dto;


import rs.ac.uns.ftn.informatika.jpa.model.Pregled;


public class PregledDTO {

	private Long id;
	private String datum;
	private String vreme;
	private String terminpregled;
	private String tip;
	private String lekarimepregled;
	private String lekarprezimepregled;
	private String idlekarpregled;
	private Long idpacijenta;
	private String lekar;
	private int cena;
	private double ocenapregleda;
	private String trajanje;
	private String sala;
	private Boolean zakazan;
	private boolean obavljenpregled;
	private Boolean obradjen;
	private Long korisnikId;
	
	
	public PregledDTO(Pregled p) {
		this(p.getId(),
				p.getDatum(),
				p.getVreme(),
				p.getTerminpregled(),
				p.getTip(),
				p.getLekarimepregled(),
				p.getLekarprezimepregled(),
				p.getIdlekarpregled(),
				p.getIdpacijenta(),
				p.getLekar(),
				p.getCena(),
				p.getOcenapregleda(),
				p.getTrajanje(),
				p.getSala(),
				p.getZakazan(),
				p.isObavljenpregled(),
				p.getObradjen(),
				p.getKorisnikId());
	}
	
	
	public PregledDTO(Long id, String datum, String vreme, String terminpregled, String tip, String lekarimepregled,
			String lekarprezimepregled, String idlekarpregled, Long idpacijenta, String lekar, int cena,
			double ocenapregleda, String trajanje, String sala, Boolean zakazan, boolean obavljenpregled,
			Boolean obradjen, Long korisnikId) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.terminpregled = terminpregled;
		this.tip = tip;
		this.lekarimepregled = lekarimepregled;
		this.lekarprezimepregled = lekarprezimepregled;
		this.idlekarpregled = idlekarpregled;
		this.idpacijenta = idpacijenta;
		this.lekar = lekar;
		this.cena = cena;
		this.ocenapregleda = ocenapregleda;
		this.trajanje = trajanje;
		this.sala = sala;
		this.zakazan = zakazan;
		this.obavljenpregled = obavljenpregled;
		this.obradjen = obradjen;
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