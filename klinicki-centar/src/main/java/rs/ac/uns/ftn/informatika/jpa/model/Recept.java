package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="recept")
public class Recept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="informacijepregled_id")
	private Long pregledId;
	
	@Column(name="pacijent_id")
	private Long pacijentId;
	
	@ManyToMany
	@JoinTable(name = "leks", joinColumns = @JoinColumn(name = "lek_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "informacijepregled_id", referencedColumnName = "id"))
	private Set<Lek> leks = new HashSet<Lek>();
	
	@Column(name="overen")
	private Boolean overen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPregledId() {
		return pregledId;
	}

	public void setPregledId(Long pregledId) {
		this.pregledId = pregledId;
	}

	public Long getPacijentId() {
		return pacijentId;
	}

	public void setPacijentId(Long pacijentId) {
		this.pacijentId = pacijentId;
	}

	public Set<Lek> getLeks() {
		return leks;
	}

	public void setLeks(Set<Lek> leks) {
		this.leks = leks;
	}

	public Boolean getOveren() {
		return overen;
	}

	public void setOveren(Boolean overen) {
		this.overen = overen;
	}

	public Recept(Long id, Long pregledId, Long pacijentId, Set<Lek> leks, Boolean overen) {
		super();
		this.id = id;
		this.pregledId = pregledId;
		this.pacijentId = pacijentId;
		this.leks = leks;
		this.overen = overen;
	}

	public Recept(Long pregledId, Long pacijentId, Set<Lek> leks, Boolean overen) {
		super();
		this.pregledId = pregledId;
		this.pacijentId = pacijentId;
		this.leks = leks;
		this.overen = overen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recept other = (Recept) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
}
