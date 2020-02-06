package rs.ac.uns.ftn.informatika.jpa.dto;

public class OperacijaDTO {
	
	private Long id;
	private String terminoperacija;
	private Long idlekaroperacija;
	private Long idpacijenta;
	private Boolean obradjen;
	public String getTerminoperacija() {
		return terminoperacija;
	}
	public void setTerminoperacija(String terminoperacija) {
		this.terminoperacija = terminoperacija;
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
	public Boolean getObradjen() {
		return obradjen;
	}
	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}
	public OperacijaDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OperacijaDTO(String terminoperacija, Long idlekaroperacija, Long idpacijenta, Boolean obradjen) {
		super();
		this.terminoperacija = terminoperacija;
		this.idlekaroperacija = idlekaroperacija;
		this.idpacijenta = idpacijenta;
		this.obradjen = obradjen;
	}
	@Override
	public String toString() {
		return "OperacijaDTO [id=" + id + ", terminoperacija=" + terminoperacija + ", idlekaroperacija="
				+ idlekaroperacija + ", idpacijenta=" + idpacijenta + ", obradjen=" + obradjen + "]";
	}
	
	
	
	
}
