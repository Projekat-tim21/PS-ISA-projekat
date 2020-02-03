package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="calendar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Pregled> pregledi;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<TerminiSaId> termini;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id")
	private Korisnik korisnik;
	

	@Version
	private Long version;

	
	
	public Set<TerminiSaId> getTermini() {
		return termini;
	}

	public void setTermini(Set<TerminiSaId> termini) {
		this.termini = termini;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(Set<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	
}

