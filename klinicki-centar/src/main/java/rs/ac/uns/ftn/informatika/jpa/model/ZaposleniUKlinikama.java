package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="zaposleni")
public class ZaposleniUKlinikama {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "idklinike", nullable = true)
	private Long idklinike;

	@Column(name = "idlekara", nullable = true)
	private Long idlekara;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdklinike() {
		return idklinike;
	}

	public void setIdklinike(Long idklinike) {
		this.idklinike = idklinike;
	}

	public Long getIdlekara() {
		return idlekara;
	}

	public void setIdlekara(Long idlekara) {
		this.idlekara = idlekara;
	}

	public ZaposleniUKlinikama() {
		super();
	}
	
	
	
}
