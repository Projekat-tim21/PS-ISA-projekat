package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="termini")
public class TerminiSaId {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //u ovaj id ce se upisivati id lekara
	private Long id;


	@Column(name="termin")
	private String termin;
	
	@Column(name="lekar_id")
	private Long lekarId;
	
	@Column(name="lekarime")
	private String lekarime;
	
	@Column(name="lekarprezime")
	private String lekarprezime;
	
	@Column(name="tippregleda")
	private String tippregleda;
	
	@Column(name="sala" , nullable=true)
	private String sala;

	@Column(name="cena", nullable=true)
	private double cena;
	
	@Column(name="popust", nullable=true)
	private double popust;
	
	@Column(name="zakazan", nullable=true)
	private boolean zakazan;
	
	@Column(name="idkorisnika", nullable=true)
	private long idkorisnika;
	
	@Column(name="odobrenpregled", nullable=true)
	private boolean odobrenpregled;

	@Column(name="prikaz", nullable=true)
	private boolean prikaz;


	public boolean isPrikaz() {
		return prikaz;
	}

	public void setPrikaz(boolean prikaz) {
		this.prikaz = prikaz;
	}

	public boolean isOdobrenpregled() {
		return odobrenpregled;
	}

	public void setOdobrenpregled(boolean odobrenpregled) {
		this.odobrenpregled = odobrenpregled;
	}

	public TerminiSaId(Long id, String termin, Long lekarId, String lekarime, String lekarprezime, String tippregleda,
			String sala, double cena, double popust, boolean zakazan, long idkorisnika) {
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
	}

	public long getIdkorisnika() {
		return idkorisnika;
	}

	public void setIdkorisnika(long idkorisnika) {
		this.idkorisnika = idkorisnika;
	}

	public TerminiSaId(Long id, String termin, Long lekarId, String lekarime, String lekarprezime, String tippregleda,
			String sala, double cena, double popust, boolean zakazan) {
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
	}

	public boolean isZakazan() {
		return zakazan;
	}

	public void setZakazan(boolean zakazan) {
		this.zakazan = zakazan;
	}

	public String getTippregleda() {
		return tippregleda;
	}

	public void setTippregleda(String tippregleda) {
		this.tippregleda = tippregleda;
	}

	
	public TerminiSaId(Long id, String termin, Long lekarId, String lekarime, String lekarprezime, String tippregleda,
			String sala, double cena, double popust) {
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
	}

	public TerminiSaId(Long id, String termin, Long lekarId, String lekarime, String lekarprezime, String sala,
			double cena, double popust) {
		super();
		this.id = id;
		this.termin = termin;
		this.lekarId = lekarId;
		this.lekarime = lekarime;
		this.lekarprezime = lekarprezime;
		this.sala = sala;
		this.cena = cena;
		this.popust = popust;
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

	public TerminiSaId(Long id, String termin, Long lekarId, String sala, double cena, double popust) {
		super();
		this.id = id;
		this.termin = termin;
		this.lekarId = lekarId;
		this.sala = sala;
		this.cena = cena;
		this.popust = popust;
	}
	
	//Random r = new Random();
	//int randomInt = r.nextInt(100) + 1;
	
	public TerminiSaId(Long id, String termin, Long lekarId) {
		super();
		this.id = id;
		this.termin = termin;
		this.lekarId = lekarId;
	}

	public Long getLekarId() {
		return lekarId;
	}

	public void setLekarId(Long lekarId) {
		this.lekarId = lekarId;
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

	public TerminiSaId() {
		super();
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
	

	
}
