package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Lek;

public class InformacijeOpregleduDTO {

	private Long id;
	private Long lekarId;
	private Long pacijentId;
	private String informacije;;
	private String dijagnozaId;
	private String dijagnoza;
	public String getDijagnoza() {
		return dijagnoza;
	}
	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
	private Long pregledId;
	private Long tip;
	private Set<Lek> leks = new HashSet<Lek>();
	private String[] lekici=new String[20];
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
	
	public Boolean getOveren() {
		return overen;
	}
	public void setOveren(Boolean overen) {
		this.overen = overen;
	}
	public Set<Lek> getLeks() {
		return leks;
	}
	public void setLeks(Set<Lek> leks) {
		this.leks = leks;
	}
	public InformacijeOpregleduDTO(Long lekarId, Long pacijentId, String informacije, String dijagnozaId, Set<Lek> leks,
			Boolean overen) {
		super();
		this.lekarId = lekarId;
		this.pacijentId = pacijentId;
		this.informacije = informacije;
		this.dijagnozaId = dijagnozaId;
		this.leks = leks;
		this.overen = overen;
	}
	public InformacijeOpregleduDTO() {
		// TODO Auto-generated constructor stub
	}
	public Long getPregledId() {
		return pregledId;
	}
	public void setPregledId(Long pregledId) {
		this.pregledId = pregledId;
	}
	public String[] getLekici() {
		return lekici;
	}
	public void setLekici(String[] lekici) {
		this.lekici = lekici;
	}
	public Long getTip() {
		return tip;
	}
	public void setTip(Long tip) {
		this.tip = tip;
	}
	
	
	
	
	
}
