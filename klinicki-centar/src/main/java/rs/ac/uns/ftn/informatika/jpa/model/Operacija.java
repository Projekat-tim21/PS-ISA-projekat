package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="operacija")
public class Operacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="datum", nullable=true)
	String datum; //ovo se ne koristi vise
	
	@Column(name="vreme", nullable=true)
	String vreme; //ovo se ne koristi vise
	
	@Column(name="terminoperacija", nullable=true)
	private String terminoperacija;
	
	@Column(name="lekarimeoperacija", nullable=true)
	private String lekarimeoperacija;
	
	@Column(name="lekarprezimeoperacija", nullable=true)
	private String lekarprezimeoperacija;
	
	@Column(name="idlekaroperacija", nullable=true)
	private Long idlekaroperacija;
	
	@Column(name="idpacijenta", nullable=true)
	private Long idpacijenta;
	
	@Column(name="tip", nullable=true)
	private String tip;
	
	@Column(name="ocenaoperacije", nullable=true)
	private double ocenaoperacije;

	@Column(name="obavljenaoperacija", nullable=true)
	private boolean obavljenaoperacija;
	
	@Column(name = "zakazan", nullable = true)
	private Boolean zakazan;
	
	@Column(name = "obradjen", nullable = true)
	private Boolean obradjen;
	
	@Column(name="trajanje", nullable=true)
	private String trajanje;
	
	@Column(name="sala", nullable=true)
	private String sala;
	
	@Column(name="lekar", nullable=true)
	String lekar;  //ovo se ne koristi
	
	@Column(name="cena", nullable=true)
	int cena;

	@Column(name="korisnikId", nullable=true)
	Long korisnikId;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lekari",joinColumns = @JoinColumn(name = "operacija_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "lekar_id", referencedColumnName = "user_id"))
	private Set<Korisnik> lekari = new HashSet<Korisnik>();

/*
	@Version
	private Long version;
*/
	
	
	
	
	public Set<Korisnik> getLekari() {
		return lekari;
	}

	public void setLekari(Set<Korisnik> lekari) {
		this.lekari = lekari;
	}

	public Boolean getObradjen() {
		return obradjen;
	}

	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}

	public String getTerminoperacija() {
		return terminoperacija;
	}

	public void setTerminoperacija(String terminoperacija) {
		this.terminoperacija = terminoperacija;
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

	public Operacija(Long id, String datum, String vreme, String tip, String trajanje, String sala, String lekar,
			int cena) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.tip = tip;
		this.trajanje = trajanje;
		this.sala = sala;
		this.lekar = lekar;
		this.cena = cena;
	}

	public Operacija() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Operacija(String datum, String vreme, String terminoperacija, String lekarimeoperacija,
			String lekarprezimeoperacija, Long idlekaroperacija, Long idpacijenta, String tip, double ocenaoperacije,
			boolean obavljenaoperacija, Boolean zakazan, Boolean obradjen, String trajanje, String sala, String lekar,
			int cena, Long korisnikId, Set<Korisnik> lekari) {
		super();
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
		this.lekari = lekari;
	}
	
	
	
	
	
	
}
