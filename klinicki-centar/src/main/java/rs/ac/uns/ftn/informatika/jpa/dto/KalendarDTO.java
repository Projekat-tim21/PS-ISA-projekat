package rs.ac.uns.ftn.informatika.jpa.dto;

public class KalendarDTO {
	
	private Long id;
	private String termin;
	private String terminkraj;
	private Long lekarId;
	private long idkorisnika;
	private String tippregleda;
	private String tipEventa;
	private String pacijentime;
	private String pacijentprezime;
	private String sala;
	private Long idEventa;// 0-odsustvo, 1-termin, 2-operacija, 3-pregled
	public Long getIdEventa() {
		return idEventa;
	}
	public void setIdEventa(Long idEventa) {
		this.idEventa = idEventa;
	}
	
	private boolean zakazan;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public boolean isZakazan() {
		return zakazan;
	}
	public void setZakazan(boolean zakazan) {
		this.zakazan = zakazan;
	}
	public String getPacijentime() {
		return pacijentime;
	}
	public void setPacijentime(String pacijentime) {
		this.pacijentime = pacijentime;
	}
	public String getPacijentprezime() {
		return pacijentprezime;
	}
	public void setPacijentprezime(String pacijentprezime) {
		this.pacijentprezime = pacijentprezime;
	}
	public String getTermin() {
		return termin;
	}
	public void setTermin(String termin) {
		this.termin = termin;
	}
	public String getTerminkraj() {
		return terminkraj;
	}
	public void setTerminkraj(String terminkraj) {
		this.terminkraj = terminkraj;
	}
	public Long getLekarId() {
		return lekarId;
	}
	public void setLekarId(Long lekarId) {
		this.lekarId = lekarId;
	}
	public long getIdkorisnika() {
		return idkorisnika;
	}
	public void setIdkorisnika(long idkorisnika) {
		this.idkorisnika = idkorisnika;
	}
	public String getTippregleda() {
		return tippregleda;
	}
	public void setTippregleda(String tippregleda) {
		this.tippregleda = tippregleda;
	}
	public String getTipEventa() {
		return tipEventa;
	}
	public void setTipEventa(String tipEventa) {
		this.tipEventa = tipEventa;
	}
	public KalendarDTO() {
		super();
	}
	public KalendarDTO(String termin, String terminkraj, Long lekarId, long idkorisnika, String tippregleda,
			String tipEventa) {
		super();
		this.termin = termin;
		this.terminkraj = terminkraj;
		this.lekarId = lekarId;
		this.idkorisnika = idkorisnika;
		this.tippregleda = tippregleda;
		this.tipEventa = tipEventa;
	}
	
	private String trajanje;
	public String getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	public KalendarDTO(String termin, String terminkraj, Long lekarId, long idkorisnika, String tippregleda,
			String tipEventa, String pacijentime, String pacijentprezime, String sala, Long idEventa, boolean zakazan,
			String trajanje) {
		super();
		this.termin = termin;
		this.terminkraj = terminkraj;
		this.lekarId = lekarId;
		this.idkorisnika = idkorisnika;
		this.tippregleda = tippregleda;
		this.tipEventa = tipEventa;
		this.pacijentime = pacijentime;
		this.pacijentprezime = pacijentprezime;
		this.sala = sala;
		this.idEventa = idEventa;
		this.zakazan = zakazan;
		this.trajanje = trajanje;
	}
	
	
	

}
