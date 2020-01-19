package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InformacijeOpregleduDTO {

	private Long id;
	private Long lekarId;
	private Long pacijentId;
	private String informacije;;
	private String dijagnozaId;
	private List<String> leks = new ArrayList<String>();
	private Boolean overen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLekarId() {
		return lekarId;
	}
	public void setLekarId(Long lekarId) {
		this.lekarId = lekarId;
	}
	public Long getPacijentId() {
		return pacijentId;
	}
	public void setPacijentId(Long pacijentId) {
		this.pacijentId = pacijentId;
	}
	public String getInformacije() {
		return informacije;
	}
	public void setInformacije(String informacije) {
		this.informacije = informacije;
	}
	public String getDijagnozaId() {
		return dijagnozaId;
	}
	public void setDijagnozaId(String dijagnozaId) {
		this.dijagnozaId = dijagnozaId;
	}
	public List<String> getLeks() {
		return leks;
	}
	public void setLeks(List<String> leks) {
		this.leks = leks;
	}
	public Boolean getOveren() {
		return overen;
	}
	public void setOveren(Boolean overen) {
		this.overen = overen;
	}
	public InformacijeOpregleduDTO(Long lekarId, Long pacijentId, String informacije, String dijagnozaId, List<String> leks,
			Boolean overen) {
		super();
		this.lekarId = lekarId;
		this.pacijentId = pacijentId;
		this.informacije = informacije;
		this.dijagnozaId = dijagnozaId;
		this.leks = leks;
		this.overen = overen;
	}
	
	
	
}