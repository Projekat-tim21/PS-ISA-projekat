package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	

	
}
