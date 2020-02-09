package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;

public class ZaposleniUKlinikamaDTO {
	private Long id;
	private Long idklinike;
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
	public ZaposleniUKlinikamaDTO(Long id, Long idklinike, Long idlekara) {
		super();
		this.id = id;
		this.idklinike = idklinike;
		this.idlekara = idlekara;
	}
	public ZaposleniUKlinikamaDTO() {
		super();
	}
	
	
	public ZaposleniUKlinikamaDTO(ZaposleniUKlinikama z) {
		this(z.getId(),
				z.getIdklinike(),
				z.getIdlekara());
	}
	
	
}



