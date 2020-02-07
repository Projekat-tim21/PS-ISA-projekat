package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="pregled")
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="datum", nullable=true)
	private String datum;   //ovo se ne koristi vise

	@Column(name = "vreme", nullable = true)
	private String vreme;   //ovo se ne koristi vise
	
	@Column(name="terminpregled", nullable=true)
	private String terminpregled;
	
	@Column(name="tip", nullable=true)
	private String tip;
	
	@Column(name="lekarimepregled", nullable=true)
	private String lekarimepregled;
	
	@Column(name="lekarprezimepregled", nullable=true)
	private String lekarprezimepregled;
	
	@Column(name="idlekarpregled", nullable=false)
	private String idlekarpregled;
	
	@Column(name="idpacijenta", nullable=true)
	private Long idpacijenta;
	
	@Column(name = "lekar", nullable = true)
	private String lekar;  //ovo se ne koristi vise
	
	@Column(name = "cena", nullable = true)
	private int cena;
	
	@Column(name="ocenapregleda", nullable=true)
	private double ocenapregleda;

	@Column(name="trajanje", nullable=true)
	private String trajanje;

		
	@Column(name="sala", nullable=true)
	private String sala;
	
	
	@Column(name = "zakazan", nullable = true)
	private Boolean zakazan;
	
	@Column(name="obavljenpregled", nullable=true)
	private boolean obavljenpregled;
	
	@Column(name = "obradjen", nullable = true)
	private Boolean obradjen;
	
	public double getOcenapregleda() {
		return ocenapregleda;
	}

/*
	@Version
	private Long version;
	*/

	public void setOcenapregleda(double ocenapregleda) {
		this.ocenapregleda = ocenapregleda;
	}

	public Long getIdpacijenta() {
		return idpacijenta;
	}

	public void setIdpacijenta(Long idpacijenta) {
		this.idpacijenta = idpacijenta;
	}

	public String getTerminpregled() {
		return terminpregled;
	}


	
	/*
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
*/

	public void setTerminpregled(String terminpregled) {
		this.terminpregled = terminpregled;
	}

	public String getLekarimepregled() {
		return lekarimepregled;
	}

	public void setLekarimepregled(String lekarimepregled) {
		this.lekarimepregled = lekarimepregled;
	}

	
	
	public Boolean getObradjen() {
		return obradjen;
	}

	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}

	public String getLekarprezimepregled() {
		return lekarprezimepregled;
	}

	public void setLekarprezimepregled(String lekarprezimepregled) {
		this.lekarprezimepregled = lekarprezimepregled;
	}

	public String getIdlekarpregled() {
		return idlekarpregled;
	}

	public void setIdlekarpregled(String idlekarpregled) {
		this.idlekarpregled = idlekarpregled;
	}

	public boolean isObavljenpregled() {
		return obavljenpregled;
	}

	public void setObavljenpregled(boolean obavljenpregled) {
		this.obavljenpregled = obavljenpregled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getZakazan() {
		return zakazan;
	}

	public void setZakazan(Boolean zakazan) {
		this.zakazan = zakazan;
	}
	
	
	
/*	public Korisnik getZakazao() {
		return zakazao;
	}
	
	public void setZakazao(Korisnik zakazao) {
		this.zakazao = zakazao;
	}
	*/
	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	
	public Pregled() {
		super();
	}

	public Pregled(Long id, String datum, String vreme, String tip, String trajanje, String sala, String lekar,
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