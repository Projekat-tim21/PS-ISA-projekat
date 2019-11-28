package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;

public class Admin extends Korisnik{
	
	@Column(name = "firstLogin", nullable = false)
	private boolean firstLogin;
	
	@Column(name = "predefinisani", nullable = false)
	private boolean predefinisani;
	
	public Admin() {
		
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public boolean isPredefinisani() {
		return predefinisani;
	}

	public void setPredefinisani(boolean predefinisani) {
		this.predefinisani = predefinisani;
	}
	

}
