package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;

public class TerminDTO {


	private Long id;

	private String termin;
	
	private Long lekarId;
	
	private String lekarime;
	
	private String lekarprezime;
	
	private String pacijentime;

	private String pacijentprezime;
	
	private String tippregleda;
	
	private String sala;

	private double cena;

	private double popust;
	
	private boolean zakazan;
	
	private Long idkorisnika;

	private boolean odobrenpregled;

	private boolean prikaz;
	
	private boolean poslatnaobradu;

	private Long korisnikId;
	
	public TerminDTO(TerminiSaId terminiSaId) {
		this(terminiSaId.getId(), 
				terminiSaId.getTermin(),
				terminiSaId.getLekarId(),
				terminiSaId.getLekarime(),
				terminiSaId.getLekarprezime(),
				terminiSaId.getTippregleda(),
				terminiSaId.getSala(),
			    terminiSaId.getCena(),
				terminiSaId.getPopust(),
				terminiSaId.isZakazan(),
				terminiSaId.getIdkorisnika(),
				terminiSaId.isOdobrenpregled(),
				terminiSaId.isPrikaz(),
				terminiSaId.isPoslatnaobradu());
	}
	
	
	public TerminDTO(Long id, String termin, Long lekarId, String lekarime, String lekarprezime,
			String tippregleda, String sala, double cena, double popust, boolean zakazan,
			Long idkorisnika, boolean odobrenpregled, boolean prikaz, boolean poslatnaobradu) {
		super();
		this.id = id;
		this.termin = termin;
		this.lekarId = lekarId;
		this.lekarime = lekarime;
		this.lekarprezime = lekarprezime;
		this.tippregleda = tippregleda;
		this.sala = sala;
		this.cena = cena;
		this.popust = popust;
		this.zakazan = zakazan;
		this.idkorisnika = idkorisnika;
		this.odobrenpregled = odobrenpregled;
		this.prikaz = prikaz;
		this.poslatnaobradu = poslatnaobradu;
	}

	public boolean isPoslatnaobradu() {
		return poslatnaobradu;
	}

	public void setPoslatnaobradu(boolean poslatnaobradu) {
		this.poslatnaobradu = poslatnaobradu;
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

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public Long getLekarId() {
		return lekarId;
	}

	public void setLekarId(Long lekarId) {
		this.lekarId = lekarId;
	}

	public String getLekarime() {
		return lekarime;
	}

	public void setLekarime(String lekarime) {
		this.lekarime = lekarime;
	}

	public String getLekarprezime() {
		return lekarprezime;
	}

	public void setLekarprezime(String lekarprezime) {
		this.lekarprezime = lekarprezime;
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

	public String getTippregleda() {
		return tippregleda;
	}

	public void setTippregleda(String tippregleda) {
		this.tippregleda = tippregleda;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public boolean isZakazan() {
		return zakazan;
	}

	public void setZakazan(boolean zakazan) {
		this.zakazan = zakazan;
	}

	public long getIdkorisnika() {
		return idkorisnika;
	}

	public void setIdkorisnika(long idkorisnika) {
		this.idkorisnika = idkorisnika;
	}

	public boolean isOdobrenpregled() {
		return odobrenpregled;
	}

	public void setOdobrenpregled(boolean odobrenpregled) {
		this.odobrenpregled = odobrenpregled;
	}

	public boolean isPrikaz() {
		return prikaz;
	}

	public void setPrikaz(boolean prikaz) {
		this.prikaz = prikaz;
	}

	public TerminDTO(Long id, String termin, Long lekarId, String lekarime, String lekarprezime, String pacijentime,
			String pacijentprezime, String tippregleda, String sala, double cena, double popust, boolean zakazan,
			long idkorisnika, boolean odobrenpregled, boolean prikaz) {
		super();
		this.id = id;
		this.termin = termin;
		this.lekarId = lekarId;
		this.lekarime = lekarime;
		this.lekarprezime = lekarprezime;
		this.pacijentime = pacijentime;
		this.pacijentprezime = pacijentprezime;
		this.tippregleda = tippregleda;
		this.sala = sala;
		this.cena = cena;
		this.popust = popust;
		this.zakazan = zakazan;
		this.idkorisnika = idkorisnika;
		this.odobrenpregled = odobrenpregled;
		this.prikaz = prikaz;
	}

	public TerminDTO(String termin, String pacijentime, String pacijentprezime, String tippregleda, String sala,
			boolean zakazan, long idkorisnika) {
		super();
		this.termin = termin;
		this.pacijentime = pacijentime;
		this.pacijentprezime = pacijentprezime;
		this.tippregleda = tippregleda;
		this.sala = sala;
		this.zakazan = zakazan;
		this.idkorisnika = idkorisnika;
	}

	public TerminDTO() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	
}
