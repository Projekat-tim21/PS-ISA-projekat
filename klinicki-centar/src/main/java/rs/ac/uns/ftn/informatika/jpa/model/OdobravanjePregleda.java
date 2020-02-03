package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="odobravanjepregleda")
public class OdobravanjePregleda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "terminzahtev")
	private String terminzahtev;
	
	@Column(name="imelekara")
	private String imelekara;
	
	@Column(name="prezimelekara")
	private String prezimelekara;
	
	@Column(name="tipspecijalizacije")
	private String tipspecijalizacije;
	
	@Column(name="imepacijenta")
	private String imepacijenta;
	
	@Column(name="idpacijenta")
	private Long idpacijenta;
	
	@Column(name="prezimepacijenta")
	private String prezimepacijenta;
	
	@Column(name="jedbrosigpac")
	private String jedbrosigpac;
	
	@Column(name="salaop")
	private String salaop;
	
	@Column(name="cenaop")
	private double cenaop;
	
	@Column(name="popustop")
	private double popustop;

	@Column(name="idtermina")
	private Long idtermina;
	
	@Column(name="lekaridop")
	private Long lekaridop;
	
	@Column(name="odobrenpregledop")
	private boolean odobrenpregledop;
	/*
	@Version
	private Long version;
	
	
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
*/
	public OdobravanjePregleda(Long id, String terminzahtev, String imelekara, String prezimelekara,
			String tipspecijalizacije, String imepacijenta, Long idpacijenta, String prezimepacijenta,
			String jedbrosigpac, String salaop, double cenaop, double popustop, Long idtermina, Long lekaridop,
			boolean odobrenpregledop) {
		super();
		this.id = id;
		this.terminzahtev = terminzahtev;
		this.imelekara = imelekara;
		this.prezimelekara = prezimelekara;
		this.tipspecijalizacije = tipspecijalizacije;
		this.imepacijenta = imepacijenta;
		this.idpacijenta = idpacijenta;
		this.prezimepacijenta = prezimepacijenta;
		this.jedbrosigpac = jedbrosigpac;
		this.salaop = salaop;
		this.cenaop = cenaop;
		this.popustop = popustop;
		this.idtermina = idtermina;
		this.lekaridop = lekaridop;
		this.odobrenpregledop = odobrenpregledop;
	}

	public boolean isOdobrenpregledop() {
		return odobrenpregledop;
	}

	public void setOdobrenpregledop(boolean odobrenpregledop) {
		this.odobrenpregledop = odobrenpregledop;
	}

	public OdobravanjePregleda(Long id, String terminzahtev, String imelekara, String prezimelekara,
			String tipspecijalizacije, String imepacijenta, Long idpacijenta, String prezimepacijenta,
			String jedbrosigpac, String salaop, double cenaop, double popustop, Long idtermina, Long lekaridop) {
		super();
		this.id = id;
		this.terminzahtev = terminzahtev;
		this.imelekara = imelekara;
		this.prezimelekara = prezimelekara;
		this.tipspecijalizacije = tipspecijalizacije;
		this.imepacijenta = imepacijenta;
		this.idpacijenta = idpacijenta;
		this.prezimepacijenta = prezimepacijenta;
		this.jedbrosigpac = jedbrosigpac;
		this.salaop = salaop;
		this.cenaop = cenaop;
		this.popustop = popustop;
		this.idtermina = idtermina;
		this.lekaridop = lekaridop;
	}

	public Long getIdpacijenta() {
		return idpacijenta;
	}

	public void setIdpacijenta(Long idpacijenta) {
		this.idpacijenta = idpacijenta;
	}

	public long getLekaridop() {
		return lekaridop;
	}

	public void setLekaridop(Long long1) {
		this.lekaridop = long1;
	}

	public OdobravanjePregleda(Long id, String terminzahtev, String imelekara, String prezimelekara,
			String tipspecijalizacije, String imepacijenta, String prezimepacijenta, String jedbrosigpac, String salaop,
			double cenaop, double popustop, Long idtermina) {
		super();
		this.id = id;
		this.terminzahtev = terminzahtev;
		this.imelekara = imelekara;
		this.prezimelekara = prezimelekara;
		this.tipspecijalizacije = tipspecijalizacije;
		this.imepacijenta = imepacijenta;
		this.prezimepacijenta = prezimepacijenta;
		this.jedbrosigpac = jedbrosigpac;
		this.salaop = salaop;
		this.cenaop = cenaop;
		this.popustop = popustop;
		this.idtermina = idtermina;
	}

	public Long getIdtermina() {
		return idtermina;
	}

	public void setIdtermina(Long idtermina) {
		this.idtermina = idtermina;
	}

	public OdobravanjePregleda(Long id, String terminzahtev, String imelekara, String prezimelekara,
			String tipspecijalizacije, String imepacijenta, String prezimepacijenta, String jedbrosigpac, String salaop,
			double cenaop, double popustop) {
		super();
		this.id = id;
		this.terminzahtev = terminzahtev;
		this.imelekara = imelekara;
		this.prezimelekara = prezimelekara;
		this.tipspecijalizacije = tipspecijalizacije;
		this.imepacijenta = imepacijenta;
		this.prezimepacijenta = prezimepacijenta;
		this.jedbrosigpac = jedbrosigpac;
		this.salaop = salaop;
		this.cenaop = cenaop;
		this.popustop = popustop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSalaop() {
		return salaop;
	}

	public void setSalaop(String salaop) {
		this.salaop = salaop;
	}

	public double getCenaop() {
		return cenaop;
	}

	public void setCenaop(double cenaop) {
		this.cenaop = cenaop;
	}

	public double getPopustop() {
		return popustop;
	}

	public void setPopustop(double d) {
		this.popustop = d;
	}

	public String getTerminzahtev() {
		return terminzahtev;
	}

	public void setTerminzahtev(String terminzahtev) {
		this.terminzahtev = terminzahtev;
	}

	public String getImelekara() {
		return imelekara;
	}

	public void setImelekara(String imelekara) {
		this.imelekara = imelekara;
	}

	public String getPrezimelekara() {
		return prezimelekara;
	}

	public void setPrezimelekara(String prezimelekara) {
		this.prezimelekara = prezimelekara;
	}

	public String getTipspecijalizacije() {
		return tipspecijalizacije;
	}

	public void setTipspecijalizacije(String tipspecijalizacije) {
		this.tipspecijalizacije = tipspecijalizacije;
	}

	public String getImepacijenta() {
		return imepacijenta;
	}

	public void setImepacijenta(String imepacijenta) {
		this.imepacijenta = imepacijenta;
	}

	public String getPrezimepacijenta() {
		return prezimepacijenta;
	}

	public void setPrezimepacijenta(String prezimepacijenta) {
		this.prezimepacijenta = prezimepacijenta;
	}

	public String getJedbrosigpac() {
		return jedbrosigpac;
	}

	public void setJedbrosigpac(String jedbrosigpac) {
		this.jedbrosigpac = jedbrosigpac;
	}

	public OdobravanjePregleda(String terminzahtev, String imelekara, String prezimelekara, String tipspecijalizacije,
			String imepacijenta, String prezimepacijenta, String jedbrosigpac) {
		super();
		this.terminzahtev = terminzahtev;
		this.imelekara = imelekara;
		this.prezimelekara = prezimelekara;
		this.tipspecijalizacije = tipspecijalizacije;
		this.imepacijenta = imepacijenta;
		this.prezimepacijenta = prezimepacijenta;
		this.jedbrosigpac = jedbrosigpac;
	}

	public OdobravanjePregleda() {
		super();
	}
	
	
	
}
