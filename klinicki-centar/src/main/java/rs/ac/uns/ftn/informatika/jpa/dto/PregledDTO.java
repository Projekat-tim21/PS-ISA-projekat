package rs.ac.uns.ftn.informatika.jpa.dto;

public class PregledDTO {

	private Long id;
	private String terminpregled;
	private String idlekarpregled;
	private Long idpacijenta;
	private Boolean obradjen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTerminpregled() {
		return terminpregled;
	}
	public void setTerminpregled(String terminpregled) {
		this.terminpregled = terminpregled;
	}
	public String getIdlekarpregled() {
		return idlekarpregled;
	}
	public void setIdlekarpregled(String idlekarpregled) {
		this.idlekarpregled = idlekarpregled;
	}
	public Long getIdpacijenta() {
		return idpacijenta;
	}
	public void setIdpacijenta(Long idpacijenta) {
		this.idpacijenta = idpacijenta;
	}
	
	
	public PregledDTO(String terminpregled, String idlekarpregled, Long idpacijenta, Boolean obradjen) {
		super();
		this.terminpregled = terminpregled;
		this.idlekarpregled = idlekarpregled;
		this.idpacijenta = idpacijenta;
		this.obradjen = obradjen;
	}
	public Boolean getObradjen() {
		return obradjen;
	}
	public void setObradjen(Boolean obradjen) {
		this.obradjen = obradjen;
	}
	public PregledDTO() {
		super();
	}
	public PregledDTO(String terminpregled, String idlekarpregled, Long idpacijenta) {
		super();
		this.terminpregled = terminpregled;
		this.idlekarpregled = idlekarpregled;
		this.idpacijenta = idpacijenta;
	}
	@Override
	public String toString() {
		return "PregledDTO [id=" + id + ", terminpregled=" + terminpregled + ", idlekarpregled=" + idlekarpregled
				+ ", idpacijenta=" + idpacijenta + "]";
	}
	
	
}
