package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="operacija")
public class Operacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="datum", nullable=false)
	String datum; //ovo se ne koristi vise
	
	@Column(name="vreme", nullable=false)
	String vreme; //ovo se ne koristi vise
	
	@Column(name="terminoperacija", nullable=true)
	private String terminoperacija;
	
	@Column(name="lekarimeoperacija", nullable=true)
	private String lekarimeoperacija;
	
	@Column(name="lekarprezimeoperacija", nullable=true)
	private String lekarprezimeoperacija;
	
	@Column(name="idlekaroperacija", nullable=false)
	private Long idlekaroperacija;
	
	@Column(name="idpacijenta", nullable=true)
	private Long idpacijenta;
	
	@Column(name="tip", nullable=false)
	private String tip;
	
	@Column(name="ocenaoperacije", nullable=true)
	private double ocenaoperacije;

	@Column(name="obavljenaoperacija", nullable=true)
	private boolean obavljenaoperacija;
	
	@Column(name = "zakazan", nullable = false)
	private Boolean zakazan;
	
	@Column(name="trajanje", nullable=false)
	private String trajanje;
	
	@Column(name="sala", nullable=false)
	private String sala;
	
	@Column(name="lekar", nullable=false)
	String lekar;  //ovo se ne koristi
	
	@Column(name="cena", nullable=false)
	int cena;

	@Version
	private Long version;
	
	
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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
	
	
	
	
	
	
}
