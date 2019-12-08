package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.ArrayList;
import java.util.List;

public class LekarIPregledi {
//Lekar i lista njegovih termina za zakazivanje pregleda
	
	private Korisnik lekar;
	//private List<P>
	//private id
	
	private List<String>datum=new ArrayList<String>();
	public Korisnik getLekar() {
		return lekar;
	}
	public void setLekar(Korisnik lekar) {
		this.lekar = lekar;
	}
	public List<String> getDatum() {
		return datum;
	}
	public void setDatum(List<String> datum) {
		this.datum = datum;
	}
	public LekarIPregledi(Korisnik lekar, List<String> datum) {
		super();
		this.lekar = lekar;
		this.datum = datum;
	}
	public LekarIPregledi() {
		super();
	}
	
	
	
	
}
